package com.test.demodata.image;

import java.awt.Font;
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
	
	public BlobObject helloImage2(int width, int height, String note) throws IOException {
		
		BlobObject blob = new BlobObject();
		
		int internalWidth = outOfThen(width,10,1400,600);
		int internalHeight = outOfThen(height,10,1400,400);
		
		BufferedImage off_Image =
				  new BufferedImage(internalWidth, internalHeight,
				                    BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = off_Image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		Font f = new Font("Monospaced", Font.BOLD, 14);
		g2.setFont(f);
		String text=String.format("%s(%dX%d)", note,internalWidth,internalHeight);
		g2.drawString(text,1,15); 
		//WritableRaster raster = bufferedImage .getRaster();
		//DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		Shape shape = new Rectangle2D.Double(1, 1,
				internalWidth-2,
				internalHeight-2);
		g2.draw(shape);
		shape = new Line2D.Double(0, 0, internalWidth, internalHeight);
		g2.draw(shape);
		shape = new Line2D.Double(internalWidth, 0, 0, internalHeight);
		g2.draw(shape);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ImageIO.write(off_Image, "png", bos);
		blob.setData(bos.toByteArray());
		blob.setMimeType(BlobObject.TYPE_PNG);
		//BlobObject.TYPE_XLSX
		return blob;
		
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


