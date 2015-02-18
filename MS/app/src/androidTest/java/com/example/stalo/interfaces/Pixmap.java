package interfaces;

/**
 * Created by Stalo on 17. 2. 2015.
 */
public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public Graphics.PixmapFormat getFormat();

    public void dispose();
}

