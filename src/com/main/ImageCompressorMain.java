package com.main;

public class ImageCompressorMain 
{

	public static void main(String[] args) 
	{
		if (args.length < 1)
		{
			System.out.println("Usage: imgcomp -<flags> <folder or image> <divider>");
		}
		else
		{
			for (int i = 0;i < args.length;i++)
			{
				System.out.println("Args from java:" + args[i]);
			}
		}

	}

}
