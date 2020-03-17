
package com.test.demodata;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class DemodataChecker extends BaseChecker{

	
	public DemodataChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public DemodataChecker checkIdOfPlatform(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public DemodataChecker checkNameOfPlatform(String name)
	{		
	 	checkStringLengthRange(name,5, 68,NAME_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public DemodataChecker checkVersionOfPlatform(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_IMAGE ="image.id";
	public DemodataChecker checkIdOfImage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_IMAGE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_IMAGE ="image.name";
	public DemodataChecker checkNameOfImage(String name)
	{		
	 	checkStringLengthRange(name,3, 40,NAME_OF_IMAGE ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_IMAGE ="image.image_path";
	public DemodataChecker checkImagePathOfImage(String imagePath)
	{		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_IMAGE ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_IMAGE ="image.platform";
	public DemodataChecker checkPlatformIdOfImage(String platformId)
	{		
	 	checkIdOfImage(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_IMAGE ="image.version";
	public DemodataChecker checkVersionOfImage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_IMAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public DemodataChecker checkIdOfUserDomain(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public DemodataChecker checkNameOfUserDomain(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public DemodataChecker checkVersionOfUserDomain(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public DemodataChecker checkIdOfUserWhiteList(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public DemodataChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public DemodataChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public DemodataChecker checkDomainIdOfUserWhiteList(String domainId)
	{		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public DemodataChecker checkVersionOfUserWhiteList(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public DemodataChecker checkIdOfSecUser(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public DemodataChecker checkLoginOfSecUser(String login)
	{		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public DemodataChecker checkMobileOfSecUser(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public DemodataChecker checkEmailOfSecUser(String email)
	{		
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public DemodataChecker checkPwdOfSecUser(String pwd)
	{		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public DemodataChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public DemodataChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public DemodataChecker checkAccessTokenOfSecUser(String accessToken)
	{		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public DemodataChecker checkVerificationCodeOfSecUser(int verificationCode)
	{		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public DemodataChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public DemodataChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public DemodataChecker checkDomainIdOfSecUser(String domainId)
	{		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public DemodataChecker checkVersionOfSecUser(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_APP ="user_app.id";
	public DemodataChecker checkIdOfUserApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public DemodataChecker checkTitleOfUserApp(String title)
	{		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public DemodataChecker checkSecUserIdOfUserApp(String secUserId)
	{		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public DemodataChecker checkAppIconOfUserApp(String appIcon)
	{		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public DemodataChecker checkFullAccessOfUserApp(boolean fullAccess)
	{		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public DemodataChecker checkPermissionOfUserApp(String permission)
	{		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public DemodataChecker checkObjectTypeOfUserApp(String objectType)
	{		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public DemodataChecker checkObjectIdOfUserApp(String objectId)
	{		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public DemodataChecker checkLocationOfUserApp(String location)
	{		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public DemodataChecker checkVersionOfUserApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public DemodataChecker checkIdOfQuickLink(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public DemodataChecker checkNameOfQuickLink(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public DemodataChecker checkIconOfQuickLink(String icon)
	{		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public DemodataChecker checkImagePathOfQuickLink(String imagePath)
	{		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public DemodataChecker checkLinkTargetOfQuickLink(String linkTarget)
	{		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public DemodataChecker checkAppIdOfQuickLink(String appId)
	{		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public DemodataChecker checkVersionOfQuickLink(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public DemodataChecker checkIdOfListAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public DemodataChecker checkNameOfListAccess(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public DemodataChecker checkInternalNameOfListAccess(String internalName)
	{		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public DemodataChecker checkReadPermissionOfListAccess(boolean readPermission)
	{		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public DemodataChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public DemodataChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public DemodataChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public DemodataChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public DemodataChecker checkAppIdOfListAccess(String appId)
	{		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public DemodataChecker checkVersionOfListAccess(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public DemodataChecker checkIdOfObjectAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public DemodataChecker checkNameOfObjectAccess(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public DemodataChecker checkObjectTypeOfObjectAccess(String objectType)
	{		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public DemodataChecker checkList1OfObjectAccess(String list1)
	{		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public DemodataChecker checkList2OfObjectAccess(String list2)
	{		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public DemodataChecker checkList3OfObjectAccess(String list3)
	{		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public DemodataChecker checkList4OfObjectAccess(String list4)
	{		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public DemodataChecker checkList5OfObjectAccess(String list5)
	{		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public DemodataChecker checkList6OfObjectAccess(String list6)
	{		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public DemodataChecker checkList7OfObjectAccess(String list7)
	{		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public DemodataChecker checkList8OfObjectAccess(String list8)
	{		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public DemodataChecker checkList9OfObjectAccess(String list9)
	{		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public DemodataChecker checkAppIdOfObjectAccess(String appId)
	{		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public DemodataChecker checkVersionOfObjectAccess(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public DemodataChecker checkIdOfLoginHistory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public DemodataChecker checkFromIpOfLoginHistory(String fromIp)
	{		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public DemodataChecker checkDescriptionOfLoginHistory(String description)
	{		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public DemodataChecker checkSecUserIdOfLoginHistory(String secUserId)
	{		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public DemodataChecker checkVersionOfLoginHistory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public DemodataChecker checkIdOfGenericForm(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public DemodataChecker checkTitleOfGenericForm(String title)
	{		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public DemodataChecker checkDescriptionOfGenericForm(String description)
	{		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public DemodataChecker checkVersionOfGenericForm(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public DemodataChecker checkIdOfFormMessage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public DemodataChecker checkTitleOfFormMessage(String title)
	{		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public DemodataChecker checkFormIdOfFormMessage(String formId)
	{		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public DemodataChecker checkLevelOfFormMessage(String level)
	{		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public DemodataChecker checkVersionOfFormMessage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public DemodataChecker checkIdOfFormFieldMessage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public DemodataChecker checkTitleOfFormFieldMessage(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public DemodataChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public DemodataChecker checkFormIdOfFormFieldMessage(String formId)
	{		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public DemodataChecker checkLevelOfFormFieldMessage(String level)
	{		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public DemodataChecker checkVersionOfFormFieldMessage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public DemodataChecker checkIdOfFormField(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public DemodataChecker checkLabelOfFormField(String label)
	{		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public DemodataChecker checkLocaleKeyOfFormField(String localeKey)
	{		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public DemodataChecker checkParameterNameOfFormField(String parameterName)
	{		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public DemodataChecker checkTypeOfFormField(String type)
	{		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public DemodataChecker checkFormIdOfFormField(String formId)
	{		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public DemodataChecker checkPlaceholderOfFormField(String placeholder)
	{		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public DemodataChecker checkDefaultValueOfFormField(String defaultValue)
	{		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public DemodataChecker checkDescriptionOfFormField(String description)
	{		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public DemodataChecker checkFieldGroupOfFormField(String fieldGroup)
	{		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public DemodataChecker checkMinimumValueOfFormField(String minimumValue)
	{		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public DemodataChecker checkMaximumValueOfFormField(String maximumValue)
	{		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public DemodataChecker checkRequiredOfFormField(boolean required)
	{		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public DemodataChecker checkDisabledOfFormField(boolean disabled)
	{		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public DemodataChecker checkCustomRenderingOfFormField(boolean customRendering)
	{		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public DemodataChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		if(candidateValues == null) {
			return this;
		}
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public DemodataChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		if(suggestValues == null) {
			return this;
		}
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public DemodataChecker checkVersionOfFormField(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public DemodataChecker checkIdOfFormAction(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public DemodataChecker checkLabelOfFormAction(String label)
	{		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public DemodataChecker checkLocaleKeyOfFormAction(String localeKey)
	{		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public DemodataChecker checkActionKeyOfFormAction(String actionKey)
	{		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public DemodataChecker checkLevelOfFormAction(String level)
	{		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public DemodataChecker checkUrlOfFormAction(String url)
	{		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public DemodataChecker checkFormIdOfFormAction(String formId)
	{		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public DemodataChecker checkVersionOfFormAction(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public DemodataChecker checkIdOfCandidateContainer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public DemodataChecker checkNameOfCandidateContainer(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public DemodataChecker checkVersionOfCandidateContainer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public DemodataChecker checkIdOfCandidateElement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public DemodataChecker checkNameOfCandidateElement(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public DemodataChecker checkTypeOfCandidateElement(String type)
	{		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public DemodataChecker checkImageOfCandidateElement(String image)
	{		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public DemodataChecker checkContainerIdOfCandidateElement(String containerId)
	{		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public DemodataChecker checkVersionOfCandidateElement(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.id";
	public DemodataChecker checkIdOfWechatWorkappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.corp_id";
	public DemodataChecker checkCorpIdOfWechatWorkappIdentify(String corpId)
	{		
	 	checkStringLengthRange(corpId,0, 100,CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.user_id";
	public DemodataChecker checkUserIdOfWechatWorkappIdentify(String userId)
	{		
	 	checkStringLengthRange(userId,1, 100,USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.sec_user";
	public DemodataChecker checkSecUserIdOfWechatWorkappIdentify(String secUserId)
	{		
	 	checkIdOfWechatWorkappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.last_login_time";
	public DemodataChecker checkLastLoginTimeOfWechatWorkappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.version";
	public DemodataChecker checkVersionOfWechatWorkappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.id";
	public DemodataChecker checkIdOfWechatMiniappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.open_id";
	public DemodataChecker checkOpenIdOfWechatMiniappIdentify(String openId)
	{		
	 	checkStringLengthRange(openId,5, 128,OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.app_id";
	public DemodataChecker checkAppIdOfWechatMiniappIdentify(String appId)
	{		
	 	checkStringLengthRange(appId,5, 128,APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.sec_user";
	public DemodataChecker checkSecUserIdOfWechatMiniappIdentify(String secUserId)
	{		
	 	checkIdOfWechatMiniappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.last_login_time";
	public DemodataChecker checkLastLoginTimeOfWechatMiniappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.version";
	public DemodataChecker checkVersionOfWechatMiniappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_TREE_NODE ="tree_node.id";
	public DemodataChecker checkIdOfTreeNode(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_ID_OF_TREE_NODE ="tree_node.node_id";
	public DemodataChecker checkNodeIdOfTreeNode(String nodeId)
	{		
	 	checkStringLengthRange(nodeId,3, 40,NODE_ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_TYPE_OF_TREE_NODE ="tree_node.node_type";
	public DemodataChecker checkNodeTypeOfTreeNode(String nodeType)
	{		
	 	checkStringLengthRange(nodeType,3, 32,NODE_TYPE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  LEFT_VALUE_OF_TREE_NODE ="tree_node.left_value";
	public DemodataChecker checkLeftValueOfTreeNode(int leftValue)
	{		
	 	checkIntegerRange(leftValue,1, 10000000,LEFT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  RIGHT_VALUE_OF_TREE_NODE ="tree_node.right_value";
	public DemodataChecker checkRightValueOfTreeNode(int rightValue)
	{		
	 	checkIntegerRange(rightValue,2, 10000000,RIGHT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TREE_NODE ="tree_node.version";
	public DemodataChecker checkVersionOfTreeNode(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TREE_NODE ); 		
		
		return this;
	}	
}










