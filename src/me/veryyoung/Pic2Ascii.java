package me.veryyoung;

/**
 * Created by veryyoung on 2015/9/28.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pic2Ascii {


    /**
     * Some empirically chosen characters that give good results.
     */
    private static final char[] defaultCharacters = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
            .toCharArray();

    public static void main(String[] args) {
        if (0 == args.length || args[0].equals("")) {
            System.err.println("请输入正确的图片路径");
            return;
        }
        System.out.println(transform(args[0]));

    }

    public static String transform(String path) {
        BufferedImage image = getImage(path);

        StringBuffer stringBuffer = new StringBuffer();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int index = (int) (Math.random() * defaultCharacters.length);
                stringBuffer.append(isBlack(image.getRGB(x, y)) ? " " : defaultCharacters[index]);
                stringBuffer.append(isBlack(image.getRGB(x, y)) ? " " : defaultCharacters[index]);
            }
            stringBuffer.append("\n\r");
        }
        return stringBuffer.toString();

    }


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
