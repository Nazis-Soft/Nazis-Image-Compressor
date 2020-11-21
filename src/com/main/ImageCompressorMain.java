package com.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import com.files.Files;

public class ImageCompressorMain 
{

	public static void main(String[] args) 
	{
		if (args.length < 1)
		{
			System.out.println("Usage: imgcomp -<flags> <folder or image> <divider> <format>");
			System.out.println("Flags: -d - directory");
			System.out.println("Flags: -f - file");
			System.out.println("Flags: -k - keep original files");
			System.out.println("Flags use: -xyz");
			System.out.println("Divider: Resolution was divided by divider");
			System.out.println("Format: png/jpg/gif etc.. (gif recomended)");
			System.exit(0);
		}
		else
		{
			Args.directory = args[1];
			Args.divider = Double.parseDouble(args[2]);
			Args.format = args[3];
			
		}
		System.out.println("Searching files...");
		List<File> files = Files.listf(Args.directory);
		System.out.println(files.size() + " files found in all directories and subdirectories \n");
		
		for (int i = 0; i < files.size();i++)
		{
		    try 
		    {
		    	System.out.println("Compressed: " + ((i / files.size()) * 100)  + "%");
			    System.out.println("Resizing " + files.get(i).getName() + "...");
			    BufferedImage image = Files.getBufferedImage(files.get(i));
			    
			    BufferedImage resized = Files.resize(image,(int)(image.getWidth() / Args.divider),(int)( image.getHeight() / Args.divider));
			    
			    File output = new File(Files.removeExtension(files.get(i).getParent() + File.separator + files.get(i).getName()) + "-c." + Args.format);
			    files.get(i).delete();
			    
			    ImageIO.write(resized, Args.format, output);
			    System.out.println("Resize file: " + files.get(i).getName() + " complete!!!");
			    System.out.println("Output file: " + output.getName() + "\n");
		    } 
		    catch (Exception e) 
		    {
		    	System.out.println("File:" + files.get(i) + " is not image \n");
		    } 
		}

	} 

}
