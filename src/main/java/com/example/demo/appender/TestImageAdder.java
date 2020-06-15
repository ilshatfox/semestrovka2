package com.example.demo.appender;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestImageAdder {
    public static void main(String[] args) throws IOException {
        createImage("sdf");
    }
    public static Image createImage(String writeText) throws IOException {
//        InputStream ismain = ManagerService.class.getClassLoader().getResourceAsStream("img/Chrysanthemum.jpg");
//        BufferedImage read = ImageIO.read(ismain);
        BufferedImage read = ImageIO.read(new File("/Users/ilsat/myFiles/itis/4 sem/demo3/img.png"));
        Graphics g = read.getGraphics();
//        g.setFont(timesRoman1);
        g.setColor(Color.RED);
        g.drawString(writeText,50, 50);
        g.dispose();
        ImageIO.write(read, "png", new File("/Users/ilsat/myFiles/itis/4 sem/demo3/img2.png"));
        return read;
    }
}
