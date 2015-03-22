package com.badlogic.androidgames.Space3009;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.AndroidGame;

/**
 * Created by Stalo on 23. 2. 2015.
 */
public class Space3009Game extends AndroidGame {

    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}