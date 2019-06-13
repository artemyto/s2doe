package misha.graphsecondattempt;

import java.util.ArrayList;
import java.util.Arrays;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;

/**
 * Created by master22 on 4/24/2018.
 Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class ObjectContainer {
//    public float[] vertices;
    private float[] vertices;
    private float[] GLvertices = new float[]{0,0,0,0};
    private boolean isDrawed = false;
    private boolean isInOpenglCache;
    private boolean isAnimated = false;
    private float colorR;
    private float colorG;
    private float colorB;
    private int numberOfPoints;
    private int startPoint;
    private float centerX;
    private float centerY;
    private float minX;
    private float minY;
    private boolean needToDelete= false;
    private int fanOrStrip = GL_TRIANGLE_FAN;
    //int typeOfTriangles = Trianngles_Striip;
    private String name;
    private ArrayList<AnimationContainer> anim = new ArrayList<AnimationContainer>();
    ObjectContainer() {
        this.vertices = new float[]{0,0,0,0};

    }
    static ObjectContainer copy (ObjectContainer oldO) {
        ObjectContainer newO = new ObjectContainer();
        for (AnimationContainer a:oldO.anim) {
            newO.anim.add(AnimationContainer.copy(a));
        }
        newO.centerX = oldO.centerX;
        newO.centerY = oldO.centerY;
        newO.colorR = oldO.colorR;
        newO.colorB = oldO.colorB;
        newO.colorG = oldO.colorG;
        newO.GLvertices = Arrays.copyOf(oldO.GLvertices, oldO.GLvertices.length);
        newO.vertices = Arrays.copyOf(oldO.vertices, oldO.vertices.length);
        newO.isDrawed = oldO.isDrawed;
        newO.isAnimated = oldO.isAnimated;
        newO.minX = oldO.minX;
        newO.minY = oldO.minY;
        newO.numberOfPoints = oldO.numberOfPoints;
        newO.startPoint = oldO.startPoint;
        newO.isInOpenglCache = oldO.isInOpenglCache;
        newO.needToDelete = oldO.needToDelete;
        newO.name = oldO.name;
        newO.fanOrStrip = oldO.fanOrStrip;
//        newO.GLvertices = oldO.GLvertices;

        return newO;
    }

    ObjectContainer getCopy () {
        ObjectContainer newO = new ObjectContainer();
        for (AnimationContainer a:anim) {
            newO.anim.add(a.getCopy());
        }
        newO.centerX = centerX;
        newO.centerY = centerY;
        newO.colorR = colorR;
        newO.colorB = colorB;
        newO.colorG = colorG;
        newO.GLvertices = Arrays.copyOf(GLvertices, GLvertices.length);
        newO.vertices = Arrays.copyOf(vertices, vertices.length);
        newO.isDrawed = isDrawed;
        newO.isAnimated = isAnimated;
        newO.minX = minX;
        newO.minY = minY;
        newO.numberOfPoints = numberOfPoints;
        newO.startPoint = startPoint;
        newO.isInOpenglCache = isInOpenglCache;
        newO.needToDelete = needToDelete;
        newO.name = name;
        newO.fanOrStrip = fanOrStrip;

        return newO;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    public void setGLvertices(float[] GLvertices) {
        this.GLvertices = GLvertices;
    }

    public boolean isDrawed() {
        return isDrawed;
    }

    public void setDrawed(boolean drawed) {
        isDrawed = drawed;
    }

    public boolean isInOpenglCache() {
        return isInOpenglCache;
    }

    public void setInOpenglCache(boolean inOpenglCache) {
        isInOpenglCache = inOpenglCache;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public float getColorB() {
        return colorB;
    }

    public float getColorG() {
        return colorG;
    }

    public float getColorR() {
        return colorR;
    }

    public void setColorB(float colorB) {
        this.colorB = colorB;
    }

    public void setColorG(float colorG) {
        this.colorG = colorG;
    }

    public void setColorR(float colorR) {
        this.colorR = colorR;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public float getMinX() {
        return minX;
    }

    public void setMinX(float minX) {
        this.minX = minX;
    }

    public float getMinY() {
        return minY;
    }

    public void setMinY(float minY) {
        this.minY = minY;
    }

    public boolean isNeedToDelete() {
        return needToDelete;
    }

    public void setNeedToDelete(boolean needToDelete) {
        this.needToDelete = needToDelete;
    }

    public int getFanOrStrip() {
        return fanOrStrip;
    }

    public void setFanOrStrip(int fanOrStrip) {
        this.fanOrStrip = fanOrStrip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<AnimationContainer> getAnim() {
        return anim;
    }

    public float[] getVertices() {
        return vertices;
    }

    public void increaseCenterX(float f) {
        this.centerX += f;
    }
    public void increaseCenterY(float f) {
        this.centerY += f;
    }
}
