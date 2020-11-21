package com.files;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

public class Files 
{
    public static List<File> listf(String directoryName) 
    {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        
        for (File file : fList) 
        {
            if (file.isFile())
            {
                //System.out.println(file.getAbsolutePath());
            } 
            else if (file.isDirectory()) 
            {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        return resultList;
    }
    
    public static String removeExtension(String path)
    {
    	return path.replaceFirst("[.][^.]+$", "");
    }
    
    public static BufferedImage getBufferedImage(File inputfile) throws IOException
    {
    	return ImageIO.read(inputfile);
    }
    
    public static BufferedImage resize(BufferedImage img, int width,int height) 
    {
        Image tmp = img.getScaledInstance(width, height, 1);
        BufferedImage resized = new BufferedImage(width, height, 2);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, (ImageObserver)null);
        g2d.dispose();
        return resized;
      }
}
