package de.headshotharp.colors;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorUtils
{
	public static String toHtmlColor(Color color)
	{
		return String.format("#%06X", (0xFFFFFF & toInt(color)));
	}

	public static Color fromHtmlColor(String color)
	{
		return Color.decode(color);
	}

	public static int toInt(Color color)
	{
		int red = (color.getRed() << 16) & 0xFF0000;
		int green = (color.getGreen() << 8) & 0x00FF00;
		int blue = color.getBlue() & 0x0000FF;
		return 0x000000 | red | green | blue;
	}

	public static Color fromInt(int color)
	{
		return new Color(color);
	}

	public static Color averageColorFromImage(BufferedImage img)
	{
		int red = 0;
		int green = 0;
		int blue = 0;
		Color c;
		for (int x = 0; x < img.getWidth(); x++)
		{
			for (int y = 0; y < img.getHeight(); y++)
			{
				c = fromInt(img.getRGB(x, y));
				red += c.getRed();
				green += c.getGreen();
				blue = c.getBlue();
			}
		}
		int pixels = img.getWidth() * img.getHeight();
		red = red / pixels;
		green = green / pixels;
		blue = blue / pixels;
		return new Color(red, green, blue);
	}
}
