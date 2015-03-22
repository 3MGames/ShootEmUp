package space.threem.Space3k9.framework.impl;

import space.threem.Space3k9.framework.Game;
import space.threem.Space3k9.framework.Screen;

public abstract class GLScreen extends Screen {
    protected final GLGraphics glGraphics;
    protected final GLGame glGame;
    
    public GLScreen(Game game) {
        super(game);
        glGame = (GLGame)game;
        glGraphics = glGame.getGLGraphics();
    }
}
