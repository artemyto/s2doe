package misha.graphsecondattempt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GameObjectsTest{
    @Test
    public void testGetTouchedBulletName() {

        float x = 240;
        float y = 480;

        ScreenUtils.setScreenParameters(720, 1280);

        GameObject gameObject = new GameObject();
        gameObject.setVertices(ObjectTemplates.getCircle(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y), ScreenUtils.transformDistanceX(50), 'x'));
        gameObject.setColorR(0.10f);
        gameObject.setColorG(0.50f);
        gameObject.setColorB(0.90f);
        gameObject.setStartPoint(0);
        gameObject.setNumberOfPoints(4);
        gameObject.setName("bullet");
        gameObject.setDrawn(true);
        gameObject.setInOpenglCache(true);
        gameObject.setMinX(-1);
        gameObject.setMinY(-1);
        gameObject.setCenterX(GameObjects.evaluateCenterX(gameObject.getVertices()));
        gameObject.setCenterY(GameObjects.evaluateCenterY(gameObject.getVertices()));
        GameObjects.addObject(gameObject);

        Assert.assertEquals("bullet", GameObjects.getTouchedBulletName(ScreenUtils.transformXCoordinateScreenToOpengl(240),ScreenUtils.transformYCoordinateScreenToOpengl(480)));
//        Assert.assertEquals("bullet", GameObjects.getTouchedBulletName(ScreenUtils.transformXCoordinateScreenToOpengl(300),ScreenUtils.transformYCoordinateScreenToOpengl(480)));
    }
}
