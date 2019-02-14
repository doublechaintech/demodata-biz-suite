package com.test.demodata.platform;
import com.test.demodata.BaseForm;
import com.test.demodata.genericform.GenericForm;
import com.test.demodata.formfield.FormField;
import com.test.demodata.formaction.FormAction;
import com.test.demodata.formmessage.FormMessage;
import com.test.demodata.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}

	
	

	



	public PlatformForm imageIdFieldForImage(String parameterName, String initValue){
		FormField field =  idFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm imageIdFieldForImage(String initValue){
		return imageIdFieldForImage("imageId",initValue);
	}
	public PlatformForm imageIdFieldForImage(){
		return imageIdFieldForImage("imageId","");
	}


	public PlatformForm nameFieldForImage(String parameterName, String initValue){
		FormField field =  nameFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForImage(String initValue){
		return nameFieldForImage("name",initValue);
	}
	public PlatformForm nameFieldForImage(){
		return nameFieldForImage("name","");
	}


	public PlatformForm imagePathFieldForImage(String parameterName, String initValue){
		FormField field =  imagePathFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm imagePathFieldForImage(String initValue){
		return imagePathFieldForImage("imagePath",initValue);
	}
	public PlatformForm imagePathFieldForImage(){
		return imagePathFieldForImage("imagePath","");
	}


	public PlatformForm createTimeFieldForImage(String parameterName, String initValue){
		FormField field =  createTimeFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForImage(String initValue){
		return createTimeFieldForImage("createTime",initValue);
	}
	public PlatformForm createTimeFieldForImage(){
		return createTimeFieldForImage("createTime","");
	}


	public PlatformForm platformIdFieldForImage(String parameterName, String initValue){
		FormField field =  platformIdFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForImage(String initValue){
		return platformIdFieldForImage("platformId",initValue);
	}
	public PlatformForm platformIdFieldForImage(){
		return platformIdFieldForImage("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


