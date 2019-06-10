package misha.graphsecondattempt;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
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
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by master22 on 4/24/2018.
 * Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private Context context;
    private int programId;
    private FloatBuffer vertexData;
    private int uColorLocation;
    private int aPositionLocation;
    private int uMatrixLocation;
    private Level game;
    private boolean needToBindData = false;
    //private String wantDelete = "-1";
    private ArrayList<String> wantDelete = new ArrayList<>();


    private float[] mModelMatrix = new float[16];

    OpenGLRenderer(Context context, Level level) {
        this.context = context;
        this.game = level;
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

        //Matrix.setIdentityM(mModelMatrix, 0);
        //bindMatrix();
        doAnimationIfNeed();
        doEvents();
        //удаление объектов, отмеченных на удаление
        if (this.needToBindData || SomeUtils.needToRebindData) {
            prepareData();
            bindData();
            this.needToBindData = false;
            SomeUtils.needToRebindData = false;
        }
//        glClear(GL_COLOR_BUFFER_BIT);

    }

    private void doAnimationIfNeed() {
        ArrayList<Boolean> indexes = new ArrayList<>();
        for (int i = 0; i < wantDelete.size(); ++i) {
            indexes.add(FALSE);
        }
        //Collections.fill(indexes, FALSE);
        ObjectContainer o;
        for (int i = 0; i < SomeUtils.obj.size(); ++i) {
            boolean cont = true;
//            if (needToBindData) {
//                prepareData();
//                bindData();
//                needToBindData = false;
//            }
            o = SomeUtils.obj.get(i);
            if (o.isNeedToDelete()) {
                SomeUtils.obj.remove(i);
                --i;
                needToBindData = true;
                cont = false;
            } else {//if (!wantDelete.isEmpty()) {
                //
                //Collections.fill(indexes, Boolean.FALSE);
                for (int j = 0; j < wantDelete.size(); ++j) {


                    if (wantDelete.get(j).equals(o.getName())) {
                        indexes.add(FALSE);
                        SomeUtils.obj.remove(i);
                        --i;
                        needToBindData = true;
                        //wantDelete.remove(j);

                        indexes.set(j, TRUE);
                        cont = false;
                    }
                    //else indexes.add(FALSE);


                }
            }


            if (cont) {
                if (o.isInOpenglCache() && o.isDrawed()) {
                    Matrix.setIdentityM(mModelMatrix, 0);
                    if (o.isAnimated() && !o.getAnim().isEmpty() && o.getAnim().get(0).isRedrawable()) {
                        int sw = redrawableAnimation(o);

                        if (sw == 2) {
                            o.getAnim().remove(0);
                            if (o.getAnim().size() == 0) {
                                o.setAnimated(false);
                                boolean outOfRange = true;
                                for (int x = 0, y = 1; x < o.getVertices().length; x += 3, y += 3) {
                                    outOfRange = outOfRange && (o.getVertices()[x] < -1 || o.getVertices()[x] > 1) && (o.getVertices()[y] < -1 || o.getVertices()[y] > 1);
                                }
                                if (outOfRange)
                                    o.setNeedToDelete(true);
                            }
                        }

                        prepareData();
                        bindData();
                    } else if (o.isAnimated()) {
                        int sw = setModelMatrix(o);
                        switch (sw) {
                            case 0:
                                o.setAnimated(false);
                                break;
                            case 2:
                                float sumX = 0;
                                float sumY = 0;
                                boolean outOfRange = true;
                                for (int x = 0, y = 1; x < o.getVertices().length; x += 3, y += 3) {
                                    if (o.getAnim().get(0).getDistanceX() > 0) {
                                        if (o.getAnim().get(0).isDirectionX()) {
                                            o.getVertices()[x] += o.getAnim().get(0).getDistanceX();
                                        } else {
                                            o.getVertices()[x] -= o.getAnim().get(0).getDistanceX();
                                        }

                                    }
                                    if (o.getAnim().get(0).getDistanceY() > 0) {
                                        if (o.getAnim().get(0).isDirectionY()) {
                                            o.getVertices()[y] += o.getAnim().get(0).getDistanceY();
                                        } else {
                                            o.getVertices()[y] -= o.getAnim().get(0).getDistanceY();
                                        }

                                    }
                                    sumX += o.getVertices()[x];
                                    sumY += o.getVertices()[y];
                                    outOfRange = outOfRange && (o.getVertices()[x] < -1 || o.getVertices()[x] > 1) && (o.getVertices()[y] < -1 || o.getVertices()[y] > 1);
                                }
                                o.setCenterX(sumX / (o.getVertices().length / 3.0f));
                                o.setCenterY(sumY / (o.getVertices().length / 3.0f));
                                //game.isClosely(o);
                                o.getAnim().remove(0);
                                if (o.getAnim().size() == 0) {
                                    o.setAnimated(false);

                                    if (outOfRange)
                                        o.setNeedToDelete(true);
                                }
                                prepareData();
                                bindData();
                                //SomeUtils.needToBindData = true;
                                break;
                        }
                    }
//                if (SomeUtils.needToBindData) {
//                    prepareData();
//                    bindData();
//                    needToBindDataFalse();//this.needToBindData = false;
//                }
//                    if (needToBindData) {
//                        prepareData();
//                        bindData();
//                    }
                    bindMatrix();
                    glUniform4f(uColorLocation, o.getColorR(), o.getColorG(), o.getColorB(), 0f);
//                    int fanOrStrip = GL_TRIANGLE_STRIP;
//                    if ()
                    glDrawArrays(o.getFanOrStrip(), o.getStartPoint(), o.getNumberOfPoints());
                }
                game.isClosely(o);
            }

        }
        int k = 0;
        for (int i = 0; i < indexes.size(); ++i) {
            if (indexes.get(i)) {
                wantDelete.remove(i - k);
                //indexes.remove(i);
                k += 1;
            }
        }
    }

    private void doEvents() {
        //совершение событий, которые должны были произойти к этому моменту, но еще не произошли
        long curTime = SystemClock.uptimeMillis();
        for (int i = 0; i < SomeUtils.events.size(); ++i) {
            EventContainer e = SomeUtils.events.get(i);
            if (!e.isPass()) {

                if (e.getPrevTime() < 0) {
                    e.setPrevTime(curTime);
                }

                if (e.isRandomizedTime() && e.getWaitTime() < 0) {
                    double rand = Math.random();
                    e.setWaitTime((int) (rand * (e.getRandomTop() - e.getRandomBottom())) + e.getRandomBottom());
                }
                if (e.getWaitTime() <= curTime - e.getPrevTime()) {
                    switch (e.getKindOfEvent()) {
                        case 'a':
                            //new object
                            //e.o -> SomeUtils.obj
                            if (game != null) {
                                ObjectContainer newO;
                                if (e.getNeedToGenerateObject() == 1)
                                    newO = SomeUtils.generateBullet();
                                else
                                    newO = ObjectContainer.copy(e.getO());
                                SomeUtils.obj.add(newO);

                            }

                            break;
                        case 'b':
                            //this.wantDelete = e.name;
                            if (!wantDelete.contains(e.getName()))
                                wantDelete.add(e.getName());
                            break;
                        case 'c':
                            //add animation


                            break;
                        case 'd':
                            //change animation
                            //ссылка на объект записана в событии
                            //тупо делаем уже описанное! ничего сверхестественного!
                            //e.newAnimX
                            //e.newAnimY
                            //e.o
                            AnimationContainer an = e.getO().getAnim().get(0);
                            // float speedX = an.distanceX/an.duration;
//                            float speedY = an.distanceY/an.duration;
//                            float distance = (float)Math.sqrt(an.distanceX*an.distanceX+an.distanceY*an.distanceY);
                            float canonDist1 = (float) Math.sqrt(an.getDistanceX() * an.getDistanceX() + an.getDistanceY() / SomeUtils.aspectRatio * an.getDistanceY() / SomeUtils.aspectRatio);
//                            float speed = distance/an.duration;
                            an.setDistanceX(e.getNewAnimX() - e.getO().getCenterX());
                            if (an.getDistanceX() < 0) {
                                an.setDistanceX(-an.getDistanceX());
                                an.setDirectionX(false);
                            } else an.setDirectionX(true);
                            an.setDistanceY(e.getNewAnimY() - e.getO().getCenterY());
                            if (an.getDistanceY() < 0) {
                                an.setDistanceY(-an.getDistanceY());
                                an.setDirectionY(false);
                            } else an.setDirectionY(true);
//                            distance = (float)Math.sqrt(an.distanceX*an.distanceX+an.distanceY*an.distanceY);
                            float canonDist2 = (float) Math.sqrt(an.getDistanceX() * an.getDistanceX() + an.getDistanceY() / SomeUtils.aspectRatio * an.getDistanceY() / SomeUtils.aspectRatio);
//                            an.duration = Math.round(distance/speed);
                            an.setDuration(Math.round(canonDist2 / canonDist1 * an.getDuration()));
                            //an.duration = Math.round(an.distanceX/speedX);
                            an.setStarted(false);
                            float differenceX = e.getO().getCenterX() - an.getStartCenterX();
                            float differenceY = e.getO().getCenterY() - an.getStartCenterY();
                            for (int j = 0; j < e.getO().getVertices().length; j += 3) {
                                e.getO().getVertices()[j] += differenceX;
                                e.getO().getVertices()[j + 1] += differenceY;
                            }

                            break;
                    }
                    if (e.isNeedToRebindData()) {
                        this.needToBindData = true;
                        //prepareData();
                        //bindData();
                    }
                    if (!e.isCycled()) {
                        e.setPass(true);
                        //SomeUtils.events.remove(i);
                        //   --i;
                    }
                    e.setPrevTime(curTime);
                    if (e.isRandomizedTime()) {
                        //double rand = Math.random();
                        e.setWaitTime(-1);
                    }
                }

            }
            //sleepTime = Math.max(sleepTime, e.waitTime);

        }
    }

    private void prepareData() {
        int sizeOfVertexData = 0;
        List<ObjectContainer> objects = SomeUtils.getObj();
        for (int i = 0; i < objects.size(); ++i) {
            sizeOfVertexData += objects.get(i).getVertices().length;
        }
        vertexData = ByteBuffer.allocateDirect(sizeOfVertexData * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        //synchronized (SomeUtils.obj) {
        int pos = 0;
        for (ObjectContainer o : objects) {
            vertexData.put(o.getVertices());
            o.setInOpenglCache(true);
            o.setStartPoint(pos);
            o.setNumberOfPoints(o.getVertices().length / 3);
            pos += o.getNumberOfPoints();
        }
        ///}
    }


    private int setModelMatrix(ObjectContainer o) {
        int returnedCommand = 1;
        if (o.getAnim().isEmpty()) {
            returnedCommand = 0;
        } else {
            long duration = o.getAnim().get(0).getDuration();
            float distanceX = o.getAnim().get(0).getDistanceX();
            float distanceY = o.getAnim().get(0).getDistanceY();
            long curTime = SystemClock.uptimeMillis();
            if (!o.getAnim().get(0).isStarted()) {

                o.getAnim().get(0).setStartTime(curTime);
                o.getAnim().get(0).setStarted(true);
//                o.centerX = SomeUtils.evaluateCenter(o.vertices, transX, 'x');
//                o.centerY = SomeUtils.evaluateCenter(o.vertices, transY, 'y');
                o.getAnim().get(0).setStartCenterX(SomeUtils.evaluateCenter(o.getVertices(), 0, 'x'));
                o.getAnim().get(0).setStartCenterY(SomeUtils.evaluateCenter(o.getVertices(), 0, 'y'));
            } else if (o.getAnim().get(0).isStarted()) {
                long timePassed = curTime - o.getAnim().get(0).getStartTime();
                if (timePassed >= duration) {
                    if (o.getAnim().get(0).isInfinite()) {
                        o.getAnim().get(0).setStarted(false);
                    } else {
                        returnedCommand = 2;
                    }
                } else {
                    float transX = 0;
                    float transY = 0;
                    if (distanceX > 0) {
                        transX = (float) timePassed / duration * distanceX;
                        if (!o.getAnim().get(0).isDirectionX()) {
                            transX = -transX;
                        }
                    }
                    if (distanceY > 0) {
                        transY = (float) timePassed / duration * distanceY;
                        if (!o.getAnim().get(0).isDirectionY()) {
                            transY = -transY;
                        }
                    }
                    Matrix.translateM(mModelMatrix, 0, transX, transY, 0);
                    o.setCenterX(SomeUtils.evaluateCenter(o.getVertices(), transX, 'x'));
                    o.setCenterY(SomeUtils.evaluateCenter(o.getVertices(), transY, 'y'));
                    //game.isClosely(o);
                }
            }
        }
        return returnedCommand;
    }

    private int redrawableAnimation(ObjectContainer o) {
        AnimationContainer a = o.getAnim().get(0);
        int returnedCommand = 1;
        long duration = a.getDuration();
        float distanceX = a.getDistanceX();
        float distanceY = a.getDistanceY();
        long curTime = SystemClock.uptimeMillis();
        if (!a.isStarted()) {
            a.setStartTime(curTime);
            a.setLastTime(curTime);
            a.setStarted(true);
//                o.centerX = SomeUtils.evaluateCenter(o.vertices, transX, 'x');
//                o.centerY = SomeUtils.evaluateCenter(o.vertices, transY, 'y');
            a.setStartCenterX(SomeUtils.evaluateCenter(o.getVertices(), 0, 'x'));
            a.setStartCenterY(SomeUtils.evaluateCenter(o.getVertices(), 0, 'y'));
        } else if (a.isStarted()) {
            long timePassed = curTime - a.getLastTime();
            if (curTime - a.getStartTime() >= duration) {
                if (a.isInfinite()) {
                    a.setStarted(false);
                } else {
                    returnedCommand = 2;
                }

            } else {
                float transX = 0;
                float transY = 0;
                if (distanceX > 0) {
                    transX = (float) timePassed / duration * distanceX;
                    if (!a.isDirectionX()) {
                        transX = -transX;
                    }
                }
                if (distanceY > 0) {
                    transY = (float) timePassed / duration * distanceY;
                    if (!a.isDirectionY()) {
                        transY = -transY;
                    }
                }
                o.increaseCenterX(transX);
                o.increaseCenterY(transY);
                if (o.getName().equals("bullet")) {
                    o.setVertices(SomeUtils.getEllipse(o.getCenterX(), o.getCenterY(), SomeUtils.changeDistance(22.5f, 'x'), SomeUtils.changeDistance(45, 'y')));
                } else {
                    for (int x = 0, y = 1; x < o.getVertices().length; x += 3, y += 3) {
                        o.getVertices()[x] += transX;
                        o.getVertices()[y] += transY;
                    }
                }


                //o.centerX = SomeUtils.evaluateCenter(o.vertices, transX, 'x');
                //o.centerY = SomeUtils.evaluateCenter(o.vertices, transY, 'y');


            }

        }

        return returnedCommand;
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
