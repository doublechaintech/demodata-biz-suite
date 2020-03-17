
package com.test.demodata.platform;
import com.test.demodata.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	public  static  PlatformTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PlatformTokens tokens = new PlatformTokens(options);
		return tokens;
		
	}
	protected PlatformTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withImageList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public PlatformTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String IMAGE_LIST = "imageList";
	public String getImageList(){
		return IMAGE_LIST;
	}
	public PlatformTokens withImageList(){		
		addSimpleOptions(IMAGE_LIST);
		return this;
	}
	public PlatformTokens analyzeImageList(){		
		addSimpleOptions(IMAGE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeImageListEnabled(){		
		
		if(checkOptions(this.options(), IMAGE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromImageList(String idsSeperatedWithComma){		
		addSimpleOptions(IMAGE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int imageListSortCounter = 0;
	public PlatformTokens sortImageListWith(String field, String descOrAsc){		
		addSortMoreOptions(IMAGE_LIST,imageListSortCounter++, field, descOrAsc);
		return this;
	}
	private int imageListSearchCounter = 0;
	public PlatformTokens searchImageListWith(String field, String verb, String value){		
		
		withImageList();
		addSearchMoreOptions(IMAGE_LIST,imageListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens searchAllTextOfImageList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(IMAGE_LIST,imageListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfImageList(int rowsPerPage){		
		addSimpleOptions(IMAGE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfImageList(int currentPageNumber){		
		addSimpleOptions(IMAGE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfImageList(String[] columns){		
		addSimpleOptions(IMAGE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfImageList(String[] columns){		
		addSimpleOptions(IMAGE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfImageList(verb, value);	
		return this;
	}
}

