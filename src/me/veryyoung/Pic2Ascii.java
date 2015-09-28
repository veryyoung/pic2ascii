package me.veryyoung;

import java.awt.image.BufferedImage;

/**
 * Created by veryyoung on 2015/9/28.
 */
public class Pic2Ascii {

    /**
     * Some empirically chosen characters that give good results.
     */
    private static final char[] defaultCharacters = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
            .toCharArray();

    public static void main(String[] args) {
        BufferedImage image = Tools.getImage("C:\\8.bmp");

        if (null != image) {
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int index = (int) (Math.random() * defaultCharacters.length);
                    System.out.print(Tools.isBlack(image.getRGB(x, y)) ? " " : defaultCharacters[index]);
                }
                System.out.println();
            }
        }

    }

}
