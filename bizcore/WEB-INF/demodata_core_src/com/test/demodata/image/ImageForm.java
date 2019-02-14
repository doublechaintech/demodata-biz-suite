package com.test.demodata.image;
import com.test.demodata.BaseForm;
import com.test.demodata.genericform.GenericForm;
import com.test.demodata.formfield.FormField;
import com.test.demodata.formaction.FormAction;
import com.test.demodata.formmessage.FormMessage;
import com.test.demodata.formfieldmessage.FormFieldMessage;



public class ImageForm extends BaseForm {
	
	
	public ImageForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ImageForm imageIdField(String parameterName, String initValue){
		FormField field = idFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ImageForm imageIdField(String initValue){
		return imageIdField("imageId",initValue);
	}
	public ImageForm imageIdField(){
		return imageIdField("imageId","");
	}


	public ImageForm nameField(String parameterName, String initValue){
		FormField field = nameFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ImageForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ImageForm nameField(){
		return nameField("name","");
	}


	public ImageForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ImageForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public ImageForm createTimeField(){
		return createTimeField("createTime","");
	}


	public ImageForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromImage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ImageForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ImageForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ImageForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ImageForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ImageForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ImageForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ImageForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ImageForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	


	

	
 	public ImageForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/imageId/");
		this.addFormAction(action);
		return this;
	}

 

	public ImageForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


