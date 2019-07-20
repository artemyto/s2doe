package misha.graphsecondattempt;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.GL_DEPTH_BUFFER_BIT;
import static android.opengl.GLES20.GL_DEPTH_TEST;
import static android.opengl.GLES20.GL_FLOAT;
import static android.opengl.GLES20.GL_FRAGMENT_SHADER;
import static android.opengl.GLES20.GL_VERTEX_SHADER;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glDrawArrays;
import static android.opengl.GLES20.glEnable;
import static android.opengl.GLES20.glEnableVertexAttribArray;
import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUniform4f;
import static android.opengl.GLES20.glUniformMatrix4fv;
import static android.opengl.GLES20.glUseProgram;
import static android.opengl.GLES20.glVertexAttribPointer;
import static android.opengl.GLES20.glViewport;

/**
 * Created by master22 on 4/24/2018.
 * Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class OpenGLRenderer implements GLSurfaceView.Renderer {
    private final Context context;
    private int programId;
    private FloatBuffer vertexData;
    private int uColorLocation;
    private int aPositionLocation;
    private int uMatrixLocation;
    private boolean needToBindData = false;

    private static List<GameObject> obj;

    private final float[] mModelMatrix = new float[16];

    OpenGLRenderer(Context context) {
        this.context = context;
        //prepareData();
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        glEnable(GL_DEPTH_TEST);
        glClearColor(0f, 0f, 0f, 1f);
        int vertexShaderId = ShaderUtils.createShader(context, GL_VERTEX_SHADER, R.raw.vertex_shader);
        int fragmentShaderId = ShaderUtils.createShader(context, GL_FRAGMENT_SHADER, R.raw.fragment_shader);
        programId = ShaderUtils.createProgram(vertexShaderId, fragmentShaderId);
        glUseProgram(programId);
        prepareData();
        bindData();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        Matrix.setIdentityM(mModelMatrix, 0);
        bindMatrix();
        for (GameObject o:obj) {

            glUniform4f(uColorLocation, o.getColorR(), o.getColorG(), o.getColorB(), 0f);
            glDrawArrays(o.getOpenglDrawingMode(), o.getStartPoint(), o.getNumberOfPoints());
        }
        if (this.needToBindData  || GameObjects.isObjectsChanged()) {
            prepareData();
            bindData();
            this.needToBindData = false;
            GameObjects.setObjectsNotChanged();
        }
    }

    private void prepareData() {
        int sizeOfVertexData = 0;
        obj = GameObjects.getObjects();
        for (int i = 0; i < obj.size(); ++i) {
            sizeOfVertexData += obj.get(i).getVertices().length;
        }
        vertexData = ByteBuffer.allocateDirect(sizeOfVertexData * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        int pos = 0;
        for (GameObject o : obj) {
            vertexData.put(o.getVertices());
            o.setStartPoint(pos);
            o.setNumberOfPoints(o.getVertices().length / 3);
            pos += o.getNumberOfPoints();
        }
    }

    private void bindData() {
        uColorLocation = glGetUniformLocation(programId, "u_Color");
        glUniform4f(uColorLocation, 0.0f, 0.0f, 1.0f, 1.0f);
        aPositionLocation = glGetAttribLocation(programId, "a_Position");
        vertexData.position(0);
        glVertexAttribPointer(aPositionLocation, 3, GL_FLOAT, false, 0, vertexData);
        glEnableVertexAttribArray(aPositionLocation);
        uMatrixLocation = glGetUniformLocation(programId, "u_Matrix");
    }

    private void bindMatrix() {
        glUniformMatrix4fv(uMatrixLocation, 1, false, mModelMatrix, 0);
    }
}
