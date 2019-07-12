package misha.graphsecondattempt;

import java.util.ArrayList;
import java.util.Arrays;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;

/**
 * Created by master22 on 4/24/2018.
 Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class GameObject {
//    float[] vertices;
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
    private final ArrayList<GameObjectAnimation> anim = new ArrayList<>();
    GameObject() {
        this.vertices = new float[]{0,0,0,0};

    }
    static GameObject copy (GameObject oldO) {
        GameObject newO = new GameObject();
        for (GameObjectAnimation a:oldO.anim) {
            newO.anim.add(GameObjectAnimation.copy(a));
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

    GameObject getCopy () {
        GameObject newO = new GameObject();
        for (GameObjectAnimation a:anim) {
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

    static void copy (GameObject where, GameObject what) {
        for (GameObjectAnimation a:what.anim) {
            where.anim.add(a.getCopy());
        }
        where.centerX = what.centerX;
        where.centerY = what.centerY;
        where.colorR = what.colorR;
        where.colorB = what.colorB;
        where.colorG = what.colorG;
        where.GLvertices = Arrays.copyOf(what.GLvertices, what.GLvertices.length);
        where.vertices = Arrays.copyOf(what.vertices, what.vertices.length);
        where.isDrawed = what.isDrawed;
        where.isAnimated = what.isAnimated;
        where.minX = what.minX;
        where.minY = what.minY;
        where.numberOfPoints = what.numberOfPoints;
        where.startPoint = what.startPoint;
        where.isInOpenglCache = what.isInOpenglCache;
        where.needToDelete = what.needToDelete;
        where.name = what.name;
        where.fanOrStrip = what.fanOrStrip;
    }

    void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    void setGLvertices(float[] GLvertices) {
        this.GLvertices = GLvertices;
    }

    boolean isDrawed() {
        return isDrawed;
    }

    void setDrawed(boolean drawed) {
        isDrawed = drawed;
    }

    boolean isInOpenglCache() {
        return isInOpenglCache;
    }

    void setInOpenglCache(boolean inOpenglCache) {
        isInOpenglCache = inOpenglCache;
    }

    boolean isAnimated() {
        return isAnimated;
    }

    void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    float getColorB() {
        return colorB;
    }

    float getColorG() {
        return colorG;
    }

    float getColorR() {
        return colorR;
    }

    void setColorB(float colorB) {
        this.colorB = colorB;
    }

    void setColorG(float colorG) {
        this.colorG = colorG;
    }

    void setColorR(float colorR) {
        this.colorR = colorR;
    }

    int getNumberOfPoints() {
        return numberOfPoints;
    }

    void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    int getStartPoint() {
        return startPoint;
    }

    void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    float getCenterX() {
        return centerX;
    }

    void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    float getCenterY() {
        return centerY;
    }

    void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    float getMinX() {
        return minX;
    }

    void setMinX(float minX) {
        this.minX = minX;
    }

    float getMinY() {
        return minY;
    }

    void setMinY(float minY) {
        this.minY = minY;
    }

    boolean isNeedToDelete() {
        return needToDelete;
    }

    void setNeedToDelete(boolean needToDelete) {
        this.needToDelete = needToDelete;
    }

    int getFanOrStrip() {
        return fanOrStrip;
    }

    void setFanOrStrip(int fanOrStrip) {
        this.fanOrStrip = fanOrStrip;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    ArrayList<GameObjectAnimation> getAnim() {
        return anim;
    }

    void addAnimation(GameObjectAnimation a) {
        anim.add(a);
    }

    float[] getVertices() {
        return vertices;
    }

    void increaseCenterX(float f) {
        this.centerX += f;
    }
    void increaseCenterY(float f) {
        this.centerY += f;
    }
}
