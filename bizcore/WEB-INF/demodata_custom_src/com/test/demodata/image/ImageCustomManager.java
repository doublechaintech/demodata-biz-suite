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
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.terapico.caf.BlobObject;
import com.terapico.uccaf.BaseUserContext;
import com.test.demodata.DemodataUserContext;
import com.test.demodata.UserContext;

public class ImageCustomManager extends ImageMiddleManager {
	
	
	
	
	SemanticImageFetcher fetcher;
	
	protected SemanticImageFetcher fetcherOf() {
		
		if(fetcher!=null) {
			return fetcher;
		}
		fetcher = new SemanticImageFetcher();
		return fetcher;
	}
	
	
	
	public ImageList listOf(DemodataUserContext userContext,String key) throws IOException {
		
		String [] files = fetcherOf().getFileCandidates(key);
		
		ImageList ret = new  ImageList();
		ret.setImageList(files);
		return ret;
	}
	
	public ImageList listOf2(DemodataUserContext userContext,String key) throws IOException {
		
		
		
		
		String [] files = fetcherOf().getFileCandidates(key);
		
		String [] finalFiles = new String[files.length];
		
		for(int i=0;i<finalFiles.length;i++) {
			
			finalFiles[i]=String.format("/demodata/imageManager/loadImage/%s%04d/400/300/red/", key,i);
			
		}
		
		
		ImageList ret = new  ImageList();
		ret.setImageList(finalFiles);
		return ret;
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
	
	
	public BlobObject loadImage(DemodataUserContext userContext,String note, int width, int height,String backgroundColor) throws IOException {
		
		String key = fetcherOf().keyOf(note);
		int index = fetcherOf().indexOf(note);
		
		String [] files = fetcherOf().getFileCandidates(key);
		
		String filePath = files[index%files.length];
		
		
		userContext.log("loading from " + filePath +" via "+ key +" and "+index);
		
		BlobObject blob = new BlobObject();
		blob.setData(fetcherOf().fileContentOf(filePath));
		blob.setMimeType(BlobObject.TYPE_JPEG);
		
		return blob;
		
	}
	
	public BlobObject genImage(DemodataUserContext userContext,String note, int width, int height,String backgroundColor) throws IOException {
		
		
		
		
		
		return this.helloImage2(note, width, height, backgroundColor);
	
	}
	public BlobObject genImage2(String note, int width, int height,String backgroundColor) throws IOException {

		return this.helloImage2(note, width, height, backgroundColor);



	}
	public String hello(String note) throws IOException {

		return "hello 水电费world"+note+ImageMiddleManager.OK;



	}
	public String hello3(String note) throws IOException {

		return "hello3: "+note;
		
	}
	
	public Object helloImage(DemodataUserContext userContext,String imageId) throws Exception {

		return this.view(userContext, imageId);
		
	}
	
	
	public SuperImage helloImage2(DemodataUserContext userContext,String imageId) throws Exception {

		Image image = (Image) this.view(userContext, imageId);
		
		SuperImage sImage=new SuperImage();
		image.copyTo(sImage);
		return sImage;
		
	}
	
	public SuperImage query(DemodataUserContext userContext,String imageId, String uploadTime) throws Exception {

		Image image = (Image) this.loadImage(userContext, imageId, this.emptyOptions() );
		
		SuperImage sImage=new SuperImage();
		image.copyTo(sImage);
		return sImage;
		
	}
	
	
	public static Object assignValue(Object[] valuesWithDefault, int index, String expr) {
		Object value=valuesWithDefault[index];
		try {
			
			
			if(value instanceof Integer) {
				return Integer.parseInt(expr);
			}
			if(value instanceof Long) {
				return Long.parseLong(expr);
			}
			if(value instanceof Double) {
				return Double.parseDouble(expr);
			}
			return expr;
			
		}catch(Exception e){
			//not able to parse
			return value;
		}
		
	}
	protected Object[] guessParameters(String input) {
		Object[] values= {"BANNER",400,200,"grey"};
		int index=input.lastIndexOf(".");
		if(index<0) {
			return values;
		}
		String [] parts=input.substring(0,index).split("-");
		
		//parts[0]=String.format("%s%02d", parts[0],lineNumber);
		
		int length = parts.length;
		
		

		for(int i=0;i<length;i++) {
			int offset = i;
			values[offset] = assignValue(values,offset,parts[i]);
			
		}
		
		for(int i=0;i<length;i++) {
			int offset = i;
			values[offset] = assignValue(values,offset,parts[i]);
			
		}
		return values;
		
	}
	public BlobObject genWithFileName(String noteExpr) throws IOException {
		//parameters like banner-123-123-red
		
		Object [] params=guessParameters(noteExpr);
		String note =(String)params[0];
		int width=(Integer)params[1];
		int height=(Integer)params[2];
		String backgroundColor=(String)params[3];;
		
		return this.helloImage2(note, width, height, backgroundColor);
	
	}
	
	protected Color parseColor(String backgroundColor) {
		
		String key = backgroundColor.toLowerCase();
		Map<String, Color> colorMap=new HashMap<String, Color>();
		
		colorMap.put("gray", Color.GRAY);
		colorMap.put("red", Color.RED);
		colorMap.put("blue", Color.BLUE);
		colorMap.put("lightgray", Color.LIGHT_GRAY);
		colorMap.put("darkgray", Color.DARK_GRAY);
		colorMap.put("green", Color.GREEN);
		colorMap.put("pink", Color.PINK);
		colorMap.put("black", Color.BLACK);
		colorMap.put("white", Color.WHITE);
		colorMap.put("yellow", Color.ORANGE);
		
		colorMap.put("magenta", Color.MAGENTA);
		colorMap.put("cyan", Color.CYAN);
		
		Color color = colorMap.get(key);
		if(color==null) {
			try {
				return Color.decode(backgroundColor);
			}catch(Exception e) {
				return Color.GRAY;
			}
		}
		return color;
	}
	
	public BlobObject helloImage2(String note, int width, int height,String backgroundColor) throws IOException {
		
		
		
		
		int internalWidth = outOfThen(width,10,2400,600);
		int internalHeight = outOfThen(height,10,2400,400);
		
		BufferedImage off_Image =
				  new BufferedImage(internalWidth, internalHeight,
				                    BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = off_Image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Monospaced", Font.BOLD, internalHeight/4);
		g2.setFont(font);
		
		//WritableRaster raster = bufferedImage .getRaster();
		//DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		Shape shape = new Rectangle2D.Double(0, 0,
				internalWidth,
				internalHeight);
		
		GradientPaint graytowhite = new GradientPaint(0,0,Color.GRAY,width, 0,Color.WHITE);
		g2.setPaint(graytowhite);
		g2.setStroke(new BasicStroke(2f));
		
		Color color = parseColor(backgroundColor);
		
        g2.setColor(color);
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
		bos.close();
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
	
}


