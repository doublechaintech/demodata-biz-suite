
package com.test.demodata.image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.test.demodata.BaseRowMapper;
import com.test.demodata.platform.Platform;

public class ImageMapper extends BaseRowMapper<Image>{
	
	protected Image internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Image image = getImage();		
		 		
 		setId(image, rs, rowNumber); 		
 		setName(image, rs, rowNumber); 		
 		setCreateTime(image, rs, rowNumber); 		
 		setPlatform(image, rs, rowNumber); 		
 		setVersion(image, rs, rowNumber);

		return image;
	}
	
	protected Image getImage(){
		return new Image();
	}		
		
	protected void setId(Image image, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ImageTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		image.setId(id);
	}
		
	protected void setName(Image image, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ImageTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		image.setName(name);
	}
		
	protected void setCreateTime(Image image, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(ImageTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		image.setCreateTime(convertToDateTime(createTime));
	}
		 		
 	protected void setPlatform(Image image, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ImageTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = image.getPlatform();
 		if( platform != null ){
 			//if the root object 'image' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		image.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(Image image, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ImageTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		image.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


