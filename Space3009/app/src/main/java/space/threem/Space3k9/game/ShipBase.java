package space.threem.Space3k9.game;

import space.threem.Space3k9.framework.DynamicGameObject;

/**
 * Created by Stalo on 8. 3. 2015.
 */
public class ShipBase extends DynamicGameObject {
    public static final int SHIP_FORWARD = 0;
    public static final int SHIP_BACKWARD = 1;
    public static final int SHIP_TURNING_LEFT = 2;
    public static final int SHIP_TURNING_RIGHT = 3;
    public static final int SHIP_HITTED = 4;
    public static final float SHIP_TOWARD_SPEED = 11;
    public static final float SHIP_BACKWARD_SPEED = -3;
    public static final float SHIP_MOVE_VELOCITY = 20;

    public ShipBase(float x, float y, float width, float height){
        super(x, y, width, height);
    }
}
