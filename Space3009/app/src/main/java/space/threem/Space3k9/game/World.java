package space.threem.Space3k9.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import space.threem.Space3k9.framework.math.Vector2;

public class World {
    public interface WorldListener {
        public void jump();
        public void highJump();
        public void hit();
        public void coin();
    }

    public static final float WORLD_WIDTH = 10;
    public static final float WORLD_HEIGHT = 15 * 20;    
    public static final int WORLD_STATE_RUNNING = 0;
    public static final int WORLD_STATE_NEXT_LEVEL = 1;
    public static final int WORLD_STATE_GAME_OVER = 2;
    //public static final Vector2 gravity = new Vector2(0, -12);

    public final OurShipTier1 T1Ship;
    /*public final List<Platform> platforms;
    public final List<Spring> springs;*/
    public final List<Squirrel> squirrels;
   /* public final List<Coin> coins;
    public Castle castle;    */
    public final WorldListener listener;
    public final Random rand;
    
    public float heightSoFar;
    public int score;    
    public int state;

    public World(WorldListener listener) {
        this.T1Ship = new OurShipTier1(5, 1);
        /*this.platforms = new ArrayList<Platform>();
        this.springs = new ArrayList<Spring>();*/
        this.squirrels = new ArrayList<Squirrel>();
        //this.coins = new ArrayList<Coin>();
        this.listener = listener;
        rand = new Random();
        generateLevel();
        
        this.heightSoFar = 0;
        this.score = 0;
        this.state = WORLD_STATE_RUNNING;
    }

    private void generateLevel() {
        /*float y = Platform.PLATFORM_HEIGHT / 2;
        float maxJumpHeight = OurShipTier1.SHIP_TOWARD_SPEED * OurShipTier1.SHIP_TOWARD_SPEED
                / (2 * -gravity.y);
        while (y < WORLD_HEIGHT - WORLD_WIDTH / 2) {
            int type = rand.nextFloat() > 0.8f ? Platform.PLATFORM_TYPE_MOVING
                    : Platform.PLATFORM_TYPE_STATIC;
            float x = rand.nextFloat()
                    * (WORLD_WIDTH - Platform.PLATFORM_WIDTH)
                    + Platform.PLATFORM_WIDTH / 2;

            Platform platform = new Platform(type, x, y);
            platforms.add(platform);

            if (rand.nextFloat() > 0.9f
                    && type != Platform.PLATFORM_TYPE_MOVING) {
                Spring spring = new Spring(platform.position.x,
                        platform.position.y + Platform.PLATFORM_HEIGHT / 2
                                + Spring.SPRING_HEIGHT / 2);
                springs.add(spring);
            }

            if (y > WORLD_HEIGHT / 3 && rand.nextFloat() > 0.8f) {
                Squirrel squirrel = new Squirrel(platform.position.x
                        + rand.nextFloat(), platform.position.y
                        + Squirrel.SQUIRREL_HEIGHT + rand.nextFloat() * 2);
                squirrels.add(squirrel);
            }

            if (rand.nextFloat() > 0.6f) {
                Coin coin = new Coin(platform.position.x + rand.nextFloat(),
                        platform.position.y + Coin.COIN_HEIGHT
                                + rand.nextFloat() * 3);
                coins.add(coin);
            }

            y += (maxJumpHeight - 0.5f);
            y -= rand.nextFloat() * (maxJumpHeight / 3);
        }

        castle = new Castle(WORLD_WIDTH / 2, y);*/
    }

    public void update(float deltaTime, float accelX) {
        updateShip(deltaTime, accelX);
        updatePlatforms(deltaTime);
        updateSquirrels(deltaTime);
        updateCoins(deltaTime);
        if (T1Ship.state != OurShipTier1.SHIP_HITTED)
            checkCollisions();
        checkGameOver();
    }

    private void updateShip(float deltaTime, float accelX) {
        if (T1Ship.state != OurShipTier1.SHIP_HITTED && T1Ship.position.y <= 0.5f)
            T1Ship.hitPlatform();
        if (T1Ship.state != OurShipTier1.SHIP_HITTED)
            T1Ship.velocity.x = -accelX / 10 * OurShipTier1.SHIP_MOVE_VELOCITY;
        T1Ship.update(deltaTime);
        heightSoFar = Math.max(T1Ship.position.y, heightSoFar);
    }

    private void updatePlatforms(float deltaTime) {
       /* int len = platforms.size();
        for (int i = 0; i < len; i++) {
            Platform platform = platforms.get(i);
            platform.update(deltaTime);
            if (platform.state == Platform.PLATFORM_STATE_PULVERIZING
                    && platform.stateTime > Platform.PLATFORM_PULVERIZE_TIME) {
                platforms.remove(platform);
                len = platforms.size();
            }
        }*/
    }

    private void updateSquirrels(float deltaTime) {
       /* int len = squirrels.size();
        for (int i = 0; i < len; i++) {
            Squirrel squirrel = squirrels.get(i);
            squirrel.update(deltaTime);
        }*/
    }

    private void updateCoins(float deltaTime) {
        /*int len = coins.size();
        for (int i = 0; i < len; i++) {
            Coin coin = coins.get(i);
            coin.update(deltaTime);
        }*/
    }

    private void checkCollisions() {
       /* checkPlatformCollisions();
        checkSquirrelCollisions();
        checkItemCollisions();
        checkCastleCollisions();*/
    }

    private void checkPlatformCollisions() {
       /* if (T1Ship.velocity.y > 0)
            return;

        int len = platforms.size();
        for (int i = 0; i < len; i++) {
            Platform platform = platforms.get(i);
            if (T1Ship.position.y > platform.position.y) {
                if (OverlapTester
                        .overlapRectangles(T1Ship.bounds, platform.bounds)) {
                    T1Ship.hitPlatform();
                    listener.jump();
                    if (rand.nextFloat() > 0.5f) {
                        platform.pulverize();
                    }
                    break;
                }
            }
        }*/
    }

    private void checkSquirrelCollisions() {
        /*int len = squirrels.size();
        for (int i = 0; i < len; i++) {
            Squirrel squirrel = squirrels.get(i);
            if (OverlapTester.overlapRectangles(squirrel.bounds, T1Ship.bounds)) {
                T1Ship.hitSquirrel();
                listener.hit();
            }
        }*/
    }

    private void checkItemCollisions() {
      /*  int len = coins.size();
        for (int i = 0; i < len; i++) {
            Coin coin = coins.get(i);
            if (OverlapTester.overlapRectangles(T1Ship.bounds, coin.bounds)) {
                coins.remove(coin);
                len = coins.size();
                listener.coin();
                score += Coin.COIN_SCORE;
            }

        }

        if (T1Ship.velocity.y > 0)
            return;

        len = springs.size();
        for (int i = 0; i < len; i++) {
            Spring spring = springs.get(i);
            if (T1Ship.position.y > spring.position.y) {
                if (OverlapTester.overlapRectangles(T1Ship.bounds, spring.bounds)) {
                    T1Ship.hitSpring();
                    listener.highJump();
                }
            }
        }*/
    }

    private void checkCastleCollisions() {
      /*  if (OverlapTester.overlapRectangles(castle.bounds, T1Ship.bounds)) {
            state = WORLD_STATE_NEXT_LEVEL;
        }*/
    }

    private void checkGameOver() {
        /*if (heightSoFar - 7.5f > T1Ship.position.y) {
            state = WORLD_STATE_GAME_OVER;
        }*/
    }
}
