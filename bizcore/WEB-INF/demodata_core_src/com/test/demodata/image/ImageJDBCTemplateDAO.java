
package com.test.demodata.image;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.test.demodata.DemodataNamingServiceDAO;
import com.test.demodata.BaseEntity;
import com.test.demodata.SmartList;
import com.test.demodata.AccessKey;
import com.test.demodata.DateKey;
import com.test.demodata.StatsInfo;
import com.test.demodata.StatsItem;

import com.test.demodata.MultipleAccessKey;
import com.test.demodata.DemodataUserContext;


import com.test.demodata.platform.Platform;

import com.test.demodata.platform.PlatformCustom2DAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ImageJDBCTemplateDAO extends DemodataNamingServiceDAO implements ImageDAO{
 
 	
 	private  PlatformCustom2DAO  platformDAO;
 	public void setPlatformDAO(PlatformCustom2DAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformCustom2DAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected Image load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalImage(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Image load(String id,Map<String,Object> options) throws Exception{
		return loadInternalImage(ImageTable.withId(id), options);
	}
	
	
	
	public Image save(Image image,Map<String,Object> options){
		
		String methodName="save(Image image,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(image, methodName, "image");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalImage(image,options);
	}
	public Image clone(String imageId, Map<String,Object> options) throws Exception{
	
		return clone(ImageTable.withId(imageId),options);
	}
	
	protected Image clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String imageId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Image newImage = loadInternalImage(accessKey, options);
		newImage.setVersion(0);
		
		

		
		saveInternalImage(newImage,options);
		
		return newImage;
	}
	
	
	
	

	protected void throwIfHasException(String imageId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ImageVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ImageNotFoundException(
					"The " + this.getTableName() + "(" + imageId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String imageId, int version) throws Exception{
	
		String methodName="delete(String imageId, int version)";
		assertMethodArgumentNotNull(imageId, methodName, "imageId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{imageId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(imageId,version);
		}
		
	
	}
	
	
	
	
	

	public Image disconnectFromAll(String imageId, int version) throws Exception{
	
		
		Image image = loadInternalImage(ImageTable.withId(imageId), emptyOptions());
		image.clearFromAll();
		this.saveImage(image);
		return image;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ImageTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "image";
	}
	@Override
	protected String getBeanName() {
		
		return "image";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ImageTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ImageTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ImageTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected ImageMapper getImageMapper(){
		return new ImageMapper();
	}

	
	
	protected Image extractImage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Image image = loadSingleObject(accessKey, getImageMapper());
			return image;
		}catch(EmptyResultDataAccessException e){
			throw new ImageNotFoundException("Image("+accessKey+") is not found!");
		}

	}

	
	

	protected Image loadInternalImage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Image image = extractImage(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(image, loadOptions);
 		}
 
		
		return image;
		
	}

	 

 	protected Image extractPlatform(Image image, Map<String,Object> options) throws Exception{

		if(image.getPlatform() == null){
			return image;
		}
		String platformId = image.getPlatform().getId();
		if( platformId == null){
			return image;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			image.setPlatform(platform);
		}
		
 		
 		return image;
 	}
 		
 
		
		
  	
 	public SmartList<Image> findImageByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Image> resultList = queryWith(ImageTable.COLUMN_PLATFORM, platformId, options, getImageMapper());
		// analyzeImageByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Image> findImageByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Image> resultList =  queryWithRange(ImageTable.COLUMN_PLATFORM, platformId, options, getImageMapper(), start, count);
 		//analyzeImageByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeImageByPlatform(SmartList<Image> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Image.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Image.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("Image");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Image.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Image.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countImageByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ImageTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countImageByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ImageTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Image saveImage(Image  image){
		
		if(!image.isChanged()){
			return image;
		}
		
		
		String SQL=this.getSaveImageSQL(image);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveImageParameters(image);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		image.incVersion();
		return image;
	
	}
	public SmartList<Image> saveImageList(SmartList<Image> imageList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitImageList(imageList);
		
		batchImageCreate((List<Image>)lists[CREATE_LIST_INDEX]);
		
		batchImageUpdate((List<Image>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Image image:imageList){
			if(image.isChanged()){
				image.incVersion();
			}
			
		
		}
		
		
		return imageList;
	}

	public SmartList<Image> removeImageList(SmartList<Image> imageList,Map<String,Object> options){
		
		
		super.removeList(imageList, options);
		
		return imageList;
		
		
	}
	
	protected List<Object[]> prepareImageBatchCreateArgs(List<Image> imageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Image image:imageList ){
			Object [] parameters = prepareImageCreateParameters(image);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareImageBatchUpdateArgs(List<Image> imageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Image image:imageList ){
			if(!image.isChanged()){
				continue;
			}
			Object [] parameters = prepareImageUpdateParameters(image);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchImageCreate(List<Image> imageList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareImageBatchCreateArgs(imageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchImageUpdate(List<Image> imageList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareImageBatchUpdateArgs(imageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitImageList(List<Image> imageList){
		
		List<Image> imageCreateList=new ArrayList<Image>();
		List<Image> imageUpdateList=new ArrayList<Image>();
		
		for(Image image: imageList){
			if(isUpdateRequest(image)){
				imageUpdateList.add( image);
				continue;
			}
			imageCreateList.add(image);
		}
		
		return new Object[]{imageCreateList,imageUpdateList};
	}
	
	protected boolean isUpdateRequest(Image image){
 		return image.getVersion() > 0;
 	}
 	protected String getSaveImageSQL(Image image){
 		if(isUpdateRequest(image)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveImageParameters(Image image){
 		if(isUpdateRequest(image) ){
 			return prepareImageUpdateParameters(image);
 		}
 		return prepareImageCreateParameters(image);
 	}
 	protected Object[] prepareImageUpdateParameters(Image image){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = image.getName();
 		parameters[1] = image.getImagePath();
 		parameters[2] = image.getCreateTime(); 	
 		if(image.getPlatform() != null){
 			parameters[3] = image.getPlatform().getId();
 		}
 		
 		parameters[4] = image.nextVersion();
 		parameters[5] = image.getId();
 		parameters[6] = image.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareImageCreateParameters(Image image){
		Object[] parameters = new Object[5];
		String newImageId=getNextId();
		image.setId(newImageId);
		parameters[0] =  image.getId();
 
 		parameters[1] = image.getName();
 		parameters[2] = image.getImagePath();
 		parameters[3] = image.getCreateTime(); 	
 		if(image.getPlatform() != null){
 			parameters[4] = image.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Image saveInternalImage(Image image, Map<String,Object> options){
		
		saveImage(image);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(image, options);
 		}
 
		
		return image;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Image savePlatform(Image image, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(image.getPlatform() == null){
 			return image;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(image.getPlatform(),options);
 		return image;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Image present(Image image,Map<String, Object> options){
	

		return image;
	
	}
		

	

	protected String getTableName(){
		return ImageTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Image> imageList) {		
		this.enhanceListInternal(imageList, this.getImageMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Image> imageList = ownerEntity.collectRefsWithType(Image.INTERNAL_TYPE);
		this.enhanceList(imageList);
		
	}
	
	@Override
	public SmartList<Image> findImageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getImageMapper());

	}
	@Override
	public int countImageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countImageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Image> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getImageMapper());
	}
}


