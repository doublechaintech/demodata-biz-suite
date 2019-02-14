
package com.test.demodata.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.test.demodata.image.Image;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String IMAGE_LIST                               = "imageList"         ;

	public static final String INTERNAL_TYPE="Platform";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Image>    	mImageList          ;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name)
	{
		setName(name);

		this.mImageList = new SmartList<Image>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<Image> getImageList(){
		if(this.mImageList == null){
			this.mImageList = new SmartList<Image>();
			this.mImageList.setListInternalName (IMAGE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mImageList;	
	}
	public  void setImageList(SmartList<Image> imageList){
		for( Image image:imageList){
			image.setPlatform(this);
		}

		this.mImageList = imageList;
		this.mImageList.setListInternalName (IMAGE_LIST );
		
	}
	
	public  void addImage(Image image){
		image.setPlatform(this);
		getImageList().add(image);
	}
	public  void addImageList(SmartList<Image> imageList){
		for( Image image:imageList){
			image.setPlatform(this);
		}
		getImageList().addAll(imageList);
	}
	
	public  Image removeImage(Image imageIndex){
		
		int index = getImageList().indexOf(imageIndex);
        if(index < 0){
        	String message = "Image("+imageIndex.getId()+") with version='"+imageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Image image = getImageList().get(index);        
        // image.clearPlatform(); //disconnect with Platform
        image.clearFromAll(); //disconnect with Platform
		
		boolean result = getImageList().planToRemove(image);
        if(!result){
        	String message = "Image("+imageIndex.getId()+") with version='"+imageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return image;
        
	
	}
	//断舍离
	public  void breakWithImage(Image image){
		
		if(image == null){
			return;
		}
		image.setPlatform(null);
		//getImageList().remove();
	
	}
	
	public  boolean hasImage(Image image){
	
		return getImageList().contains(image);
  
	}
	
	public void copyImageFrom(Image image) {

		Image imageInList = findTheImage(image);
		Image newImage = new Image();
		imageInList.copyTo(newImage);
		newImage.setVersion(0);//will trigger copy
		getImageList().add(newImage);
		addItemToFlexiableObject(COPIED_CHILD, newImage);
	}
	
	public  Image findTheImage(Image image){
		
		int index =  getImageList().indexOf(image);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Image("+image.getId()+") with version='"+image.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getImageList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpImageList(){
		getImageList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getImageList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getImageList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, IMAGE_LIST, getImageList());
		if(!getImageList().isEmpty()){
			appendKeyValuePair(result, "imageCount", getImageList().getTotalCount());
			appendKeyValuePair(result, "imageCurrentPageNumber", getImageList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setImageList(getImageList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

