package misha.graphsecondattempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;

class GameObject {
    private List<GameObjectAnimation> anim;
    private boolean animated = false;
    private float centerX;
    private float centerY;
    private float colorB;
    private float colorG;
    private float colorR;
    private boolean drawn = false;
    private float minX;
    private float minY;
    private String name;
    private int numberOfPoints;
    private int openglDrawingMode = GL_TRIANGLE_FAN;
    private int startPoint;
    private float[] vertices;

    GameObject() {

    }

    private GameObject(Builder builder) {
        anim = builder.anim;
        animated = builder.animated;
        centerX = builder.centerX;
        centerY = builder.centerY;
        colorB = builder.colorB;
        colorG = builder.colorG;
        colorR = builder.colorR;
        drawn = builder.drawn;
        minX = builder.minX;
        minY = builder.minY;
        name = builder.name;
        numberOfPoints = builder.numberOfPoints;
        openglDrawingMode = builder.openglDrawingMode;
        startPoint = builder.startPoint;
        vertices = builder.vertices;
    }

    static class Builder {
        private List<GameObjectAnimation> anim;
        private boolean animated = false;
        private float centerX;
        private float centerY;
        private float colorB;
        private float colorG;
        private float colorR;
        private boolean drawn = false;
        private float minX = -1f;
        private float minY = -1f;
        private String name;
        private int numberOfPoints;
        private int openglDrawingMode = GL_TRIANGLE_FAN;
        private int startPoint = 0;
        private float[] vertices;

        GameObject build() {
            return new GameObject(this);
        }

        Builder animation(List<GameObjectAnimation> anim) {
            this.anim = anim;
            this.animated = true;
            return this;
        }

        Builder color(float blue, float green, float red) {
            colorB = blue;
            colorG = green;
            colorR = red;
            return this;
        }

        Builder drawn() {
            this.drawn = true;
            return this;
        }

        Builder minXY(float x, float y) {
            minX = x;
            minY = y;
            return this;
        }

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder openglDrawingMode(int mode) {
            openglDrawingMode = mode;
            return this;
        }

        Builder vertices(float[] vertices) {
            this.vertices = vertices;
            numberOfPoints = vertices.length / 3;
            centerX = GameObjects.evaluateCenterX(vertices);
            centerY = GameObjects.evaluateCenterY(vertices);
            return this;
        }
    }

    static GameObject copy (GameObject oldO) {
        GameObject newO = new GameObject();
        if (oldO.anim != null) {
            newO.anim = new ArrayList<>();
            for (GameObjectAnimation a : oldO.anim) {
                newO.anim.add(GameObjectAnimation.copy(a));
            }
        }
        newO.centerX = oldO.centerX;
        newO.centerY = oldO.centerY;
        newO.colorR = oldO.colorR;
        newO.colorB = oldO.colorB;
        newO.colorG = oldO.colorG;
        newO.vertices = Arrays.copyOf(oldO.vertices, oldO.vertices.length);
        newO.drawn = oldO.drawn;
        newO.animated = oldO.animated;
        newO.minX = oldO.minX;
        newO.minY = oldO.minY;
        newO.numberOfPoints = oldO.numberOfPoints;
        newO.startPoint = oldO.startPoint;
        newO.name = oldO.name;
        newO.openglDrawingMode = oldO.openglDrawingMode;

        return newO;
    }

    GameObject getCopy () {
        GameObject newO = new GameObject();
        if (anim != null) {
            newO.anim = new ArrayList<>();
            for (GameObjectAnimation a : anim) {
                newO.anim.add(a.getCopy());
            }
        }
        newO.centerX = centerX;
        newO.centerY = centerY;
        newO.colorR = colorR;
        newO.colorB = colorB;
        newO.colorG = colorG;
        newO.vertices = Arrays.copyOf(vertices, vertices.length);
        newO.drawn = drawn;
        newO.animated = animated;
        newO.minX = minX;
        newO.minY = minY;
        newO.numberOfPoints = numberOfPoints;
        newO.startPoint = startPoint;
        newO.name = name;
        newO.openglDrawingMode = openglDrawingMode;

        return newO;
    }

    static void copy (GameObject where, GameObject what) {
        if (what.anim != null) {
            where.anim = new ArrayList<>();
            for (GameObjectAnimation a : what.anim) {
                where.anim.add(a.getCopy());
            }
        }
        where.centerX = what.centerX;
        where.centerY = what.centerY;
        where.colorR = what.colorR;
        where.colorB = what.colorB;
        where.colorG = what.colorG;
        where.vertices = Arrays.copyOf(what.vertices, what.vertices.length);
        where.drawn = what.drawn;
        where.animated = what.animated;
        where.minX = what.minX;
        where.minY = what.minY;
        where.numberOfPoints = what.numberOfPoints;
        where.startPoint = what.startPoint;
        where.name = what.name;
        where.openglDrawingMode = what.openglDrawingMode;
    }

    void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    boolean isDrawn() {
        return drawn;
    }

    void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    boolean isAnimated() {
        return animated;
    }

    void setAnimated(boolean animated) {
        this.animated = animated;
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

    int getOpenglDrawingMode() {
        return openglDrawingMode;
    }

    void setOpenglDrawingMode(int openglDrawingMode) {
        this.openglDrawingMode = openglDrawingMode;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    List<GameObjectAnimation> getAnim() {
        return anim;
    }

    void addAnimation(GameObjectAnimation a) {
        anim.add(a);
    }

    float[] getVertices() {
        return vertices;
    }

    void changeCenterX(float f) {
        this.centerX += f;
    }
    void changeCenterY(float f) {
        this.centerY += f;
    }
}
