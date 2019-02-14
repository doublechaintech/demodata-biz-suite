package com.test.demodata;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class DemodataCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_PLATFORM ="platform.id";
	protected void checkIdOfPlatform(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PLATFORM ="platform.name";
	protected void checkNameOfPlatform(DemodataUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,5, 68,NAME_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PLATFORM ="platform.version";
	protected void checkVersionOfPlatform(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_IMAGE ="image.id";
	protected void checkIdOfImage(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_IMAGE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_IMAGE ="image.name";
	protected void checkNameOfImage(DemodataUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_IMAGE, messageList); 		
		
	}	 			
	
	public static final String  IMAGE_PATH_OF_IMAGE ="image.image_path";
	protected void checkImagePathOfImage(DemodataUserContext userContext, String imagePath, List<Message> messageList)
	{
		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_IMAGE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_IMAGE ="image.platform";
	protected void checkPlatformIdOfImage(DemodataUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfImage(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_IMAGE ="image.version";
	protected void checkVersionOfImage(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_IMAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(DemodataUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(DemodataUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(DemodataUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(DemodataUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(DemodataUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(DemodataUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(DemodataUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(DemodataUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(DemodataUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(DemodataUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(DemodataUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(DemodataUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(DemodataUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(DemodataUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(DemodataUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(DemodataUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(DemodataUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(DemodataUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(DemodataUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(DemodataUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(DemodataUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(DemodataUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(DemodataUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(DemodataUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(DemodataUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(DemodataUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(DemodataUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(DemodataUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(DemodataUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(DemodataUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(DemodataUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(DemodataUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(DemodataUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(DemodataUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(DemodataUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(DemodataUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(DemodataUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(DemodataUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(DemodataUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(DemodataUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(DemodataUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(DemodataUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(DemodataUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(DemodataUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(DemodataUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(DemodataUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(DemodataUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(DemodataUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(DemodataUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(DemodataUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(DemodataUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(DemodataUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(DemodataUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(DemodataUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(DemodataUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(DemodataUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(DemodataUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(DemodataUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(DemodataUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(DemodataUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(DemodataUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(DemodataUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(DemodataUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(DemodataUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(DemodataUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(DemodataUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(DemodataUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(DemodataUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(DemodataUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(DemodataUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(DemodataUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(DemodataUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(DemodataUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(DemodataUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(DemodataUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(DemodataUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(DemodataUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(DemodataUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof DemodataUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		DemodataUserContext userContext = (DemodataUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(DemodataUserContext userContext, List<Message> messageList, Class<? extends DemodataException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, DemodataException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











