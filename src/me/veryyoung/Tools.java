package me.veryyoung;

/**
 * Created by veryyoung on 2015/9/28.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tools {


    public static boolean isBlack(int pixel) {
        boolean result = false;

        int r = (pixel >> 16) & 0xff;
        int g = (pixel >> 8) & 0xff;
        int b = (pixel) & 0xff;


        int tmp = r * r + g * g + b * b;
        if (tmp > 3 * 128 * 128) {
            result = true;
        }

        return result;
    }

    public static BufferedImage getImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("未能获取到图片");
            e.printStackTrace();
        }

        return image;
    }

}
