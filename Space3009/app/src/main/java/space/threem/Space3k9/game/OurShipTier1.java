package space.threem.Space3k9.game;

public class OurShipTier1 extends ShipBase {


    public static final float SHIP_WIDTH = 0.8f;
    public static final float SHIP_HEIGHT = 0.8f;

    int state;
    float stateTime;    

    public OurShipTier1(float x, float y) {
        super(x, y, SHIP_WIDTH, SHIP_HEIGHT);
        state = SHIP_TURNING_LEFT;
        stateTime = 0;        
    }

    public void update(float deltaTime) {     
        velocity.add(SHIP_BACKWARD_SPEED * deltaTime, SHIP_BACKWARD_SPEED * deltaTime);
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        bounds.lowerLeft.set(position).sub(bounds.width / 2, bounds.height / 2);
        
        if(velocity.y > 0 && state != SHIP_HITTED) {
            if(state != SHIP_FORWARD) {
                state = SHIP_FORWARD;
                stateTime = 0;
            }
        }
        
        if(velocity.y < 0 && state != SHIP_HITTED) {
            if(state != SHIP_TURNING_LEFT) {
                state = SHIP_TURNING_LEFT;
                stateTime = 0;
            }
        }
        
        if(position.x < 0)
            position.x = World.WORLD_WIDTH;
        if(position.x > World.WORLD_WIDTH)
            position.x = 0;
        
        stateTime += deltaTime;
    }

    public void hitSquirrel() {
        velocity.set(0,0);
        state = SHIP_HITTED;
        stateTime = 0;
    }
    
    public void hitPlatform() {
        velocity.y = SHIP_TOWARD_SPEED;
        state = SHIP_FORWARD;
        stateTime = 0;
    }

    public void hitSpring() {
        velocity.y = SHIP_TOWARD_SPEED * 1.5f;
        state = SHIP_FORWARD;
        stateTime = 0;   
    }
}
