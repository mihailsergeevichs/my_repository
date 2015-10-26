package my.decided.tasks.level16.lesson13.bonus01;

import my.decided.tasks.level16.lesson13.bonus01.common.*;

/**
 * Created by Overlord on 08.06.2015.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes t)
    {
        ImageReader reader;
        if (t == ImageTypes.BMP) {
            reader = new BmpReader();
        }
        else if (t == ImageTypes.PNG) {
            reader = new PngReader();
        }
        else if (t == ImageTypes.JPG) {
        reader = new JpgReader();
        }
        else {throw new IllegalArgumentException();}
        return reader;
    }
}
