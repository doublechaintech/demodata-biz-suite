package com.test.demodata.image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.terapico.caf.BlobObject;
import com.terapico.uccaf.BaseUserContext;

public class ImageCustomManager extends ImageManagerImpl {
	
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
	
		if(methodName.startsWith("hello")){
            return accessOK();
        }//indexIt
		if(methodName.startsWith("index")){
            return accessOK();
        }
		if(methodName.startsWith("show")){
            return accessOK();
        }
		if(methodName.startsWith("gen")){
            return accessOK();
        }
		return super.checkAccess(baseUserContext, methodName, parameters);
	}
	
	
	protected int outOfThen(int value, int min, int max, int defaultValue) {
		
		if(value<min) {
			return defaultValue;
		}
		if(value>max) {
			return defaultValue;
		}
		
		return value;
	}
	public BlobObject genImage(String note, int width, int height,String backgroundColor) throws IOException {
	
		return this.helloImage2(note, width, height, backgroundColor);
	
	}
	public BlobObject helloImage2(String note, int width, int height,String backgroundColor) throws IOException {
		
		int internalWidth = outOfThen(width,10,1400,600);
		int internalHeight = outOfThen(height,10,1400,400);
		
		BufferedImage off_Image =
				  new BufferedImage(internalWidth, internalHeight,
				                    BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = off_Image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Monospaced", Font.BOLD, height/2);
		g2.setFont(font);
		
		//WritableRaster raster = bufferedImage .getRaster();
		//DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		Shape shape = new Rectangle2D.Double(0, 0,
				internalWidth,
				internalHeight);
		
		GradientPaint graytowhite = new GradientPaint(0,0,Color.GRAY,width, 0,Color.WHITE);
		g2.setPaint(graytowhite);
		g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.LIGHT_GRAY);
		g2.fill(shape);
		g2.setColor(Color.WHITE);
		
		shape = new Line2D.Double(0, 0, internalWidth-1, internalHeight-1);
		//g2.draw(shape);
		shape = new Line2D.Double(internalWidth-1, 0, 0, internalHeight-1);
		//g2.draw(shape);
		
		
		String text=String.format("%s", note,internalWidth,internalHeight);
		//g2.drawString(text,1,height/2); 
		//this.drawCenteredString(g2, text, rectangle, font);
		this.drawCenteredString(g2, text, 0,0,internalWidth,internalHeight, font);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ImageIO.write(off_Image, "png", bos);
		BlobObject blob = new BlobObject();
		blob.setData(bos.toByteArray());
		blob.setMimeType(BlobObject.TYPE_PNG);
		//BlobObject.TYPE_XLSX
		return blob;
		
	}
	public void drawCenteredString(Graphics g, String text, int left, int top, int width,int height, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x =left + (width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = top + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
	public BlobObject helloImage() throws IOException {
		
		BlobObject blob = new BlobObject();
		
		BufferedImage off_Image =
				  new BufferedImage(400, 300,
				                    BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = off_Image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		Font f = new Font("Monospaced", Font.BOLD, 44);
		g2.setFont(f);
		g2.drawString("Big Banner",10,50); 
		//WritableRaster raster = bufferedImage .getRaster();
		//DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(off_Image, "png", bos);
		blob.setData(bos.toByteArray());
		blob.setMimeType("image/png");
		return blob;
		
	}
}


