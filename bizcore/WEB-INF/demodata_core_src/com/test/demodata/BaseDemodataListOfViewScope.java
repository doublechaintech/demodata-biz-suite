package com.test.demodata;

import java.util.HashMap;
import java.util.Map;
import com.terapico.caf.viewpage.SerializeScope;

import com.test.demodata.platform.Platform;
import com.test.demodata.image.Image;
import com.test.demodata.userdomain.UserDomain;
import com.test.demodata.userwhitelist.UserWhiteList;
import com.test.demodata.secuser.SecUser;
import com.test.demodata.userapp.UserApp;
import com.test.demodata.quicklink.QuickLink;
import com.test.demodata.listaccess.ListAccess;
import com.test.demodata.objectaccess.ObjectAccess;
import com.test.demodata.loginhistory.LoginHistory;
import com.test.demodata.genericform.GenericForm;
import com.test.demodata.formmessage.FormMessage;
import com.test.demodata.formfieldmessage.FormFieldMessage;
import com.test.demodata.formfield.FormField;
import com.test.demodata.formaction.FormAction;
import com.test.demodata.candidatecontainer.CandidateContainer;
import com.test.demodata.candidateelement.CandidateElement;
import com.test.demodata.wechatworkappidentify.WechatWorkappIdentify;
import com.test.demodata.wechatminiappidentify.WechatMiniappIdentify;
import com.test.demodata.treenode.TreeNode;


public class BaseDemodataListOfViewScope {

	/** Platform的简单属性序列化列表 */
	protected SerializeScope getPlatformSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(Platform.ID_PROPERTY)
			.field(Platform.NAME_PROPERTY)
			.field(Platform.VERSION_PROPERTY)
		;
	}

	/** Image的简单属性序列化列表 */
	protected SerializeScope getImageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(Image.ID_PROPERTY)
			.field(Image.NAME_PROPERTY)
			.field(Image.IMAGE_PATH_PROPERTY)
			.field(Image.CREATE_TIME_PROPERTY)
			.field(Image.VERSION_PROPERTY)
		;
	}

	/** UserDomain的简单属性序列化列表 */
	protected SerializeScope getUserDomainSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY)
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的简单属性序列化列表 */
	protected SerializeScope getUserWhiteListSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY)
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的简单属性序列化列表 */
	protected SerializeScope getSecUserSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY)
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的简单属性序列化列表 */
	protected SerializeScope getUserAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY)
			.field(UserApp.APP_ICON_PROPERTY)
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的简单属性序列化列表 */
	protected SerializeScope getQuickLinkSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY)
			.field(QuickLink.ICON_PROPERTY)
			.field(QuickLink.IMAGE_PATH_PROPERTY)
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的简单属性序列化列表 */
	protected SerializeScope getListAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY)
			.field(ListAccess.INTERNAL_NAME_PROPERTY)
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** ObjectAccess的简单属性序列化列表 */
	protected SerializeScope getObjectAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(ObjectAccess.ID_PROPERTY)
			.field(ObjectAccess.NAME_PROPERTY)
			.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
			.field(ObjectAccess.LIST1_PROPERTY)
			.field(ObjectAccess.LIST2_PROPERTY)
			.field(ObjectAccess.LIST3_PROPERTY)
			.field(ObjectAccess.LIST4_PROPERTY)
			.field(ObjectAccess.LIST5_PROPERTY)
			.field(ObjectAccess.LIST6_PROPERTY)
			.field(ObjectAccess.LIST7_PROPERTY)
			.field(ObjectAccess.LIST8_PROPERTY)
			.field(ObjectAccess.LIST9_PROPERTY)
			.field(ObjectAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的简单属性序列化列表 */
	protected SerializeScope getLoginHistorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY)
			.field(LoginHistory.DESCRIPTION_PROPERTY)
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** GenericForm的简单属性序列化列表 */
	protected SerializeScope getGenericFormSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(GenericForm.ID_PROPERTY)
			.field(GenericForm.TITLE_PROPERTY)
			.field(GenericForm.DESCRIPTION_PROPERTY)
			.field(GenericForm.VERSION_PROPERTY)
		;
	}

	/** FormMessage的简单属性序列化列表 */
	protected SerializeScope getFormMessageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormMessage.ID_PROPERTY)
			.field(FormMessage.TITLE_PROPERTY)
			.field(FormMessage.LEVEL_PROPERTY)
			.field(FormMessage.VERSION_PROPERTY)
		;
	}

	/** FormFieldMessage的简单属性序列化列表 */
	protected SerializeScope getFormFieldMessageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormFieldMessage.ID_PROPERTY)
			.field(FormFieldMessage.TITLE_PROPERTY)
			.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
			.field(FormFieldMessage.LEVEL_PROPERTY)
			.field(FormFieldMessage.VERSION_PROPERTY)
		;
	}

	/** FormField的简单属性序列化列表 */
	protected SerializeScope getFormFieldSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormField.ID_PROPERTY)
			.field(FormField.LABEL_PROPERTY)
			.field(FormField.LOCALE_KEY_PROPERTY)
			.field(FormField.PARAMETER_NAME_PROPERTY)
			.field(FormField.TYPE_PROPERTY)
			.field(FormField.PLACEHOLDER_PROPERTY)
			.field(FormField.DEFAULT_VALUE_PROPERTY)
			.field(FormField.DESCRIPTION_PROPERTY)
			.field(FormField.FIELD_GROUP_PROPERTY)
			.field(FormField.MINIMUM_VALUE_PROPERTY)
			.field(FormField.MAXIMUM_VALUE_PROPERTY)
			.field(FormField.REQUIRED_PROPERTY)
			.field(FormField.DISABLED_PROPERTY)
			.field(FormField.CUSTOM_RENDERING_PROPERTY)
			.field(FormField.CANDIDATE_VALUES_PROPERTY)
			.field(FormField.SUGGEST_VALUES_PROPERTY)
			.field(FormField.VERSION_PROPERTY)
		;
	}

	/** FormAction的简单属性序列化列表 */
	protected SerializeScope getFormActionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormAction.ID_PROPERTY)
			.field(FormAction.LABEL_PROPERTY)
			.field(FormAction.LOCALE_KEY_PROPERTY)
			.field(FormAction.ACTION_KEY_PROPERTY)
			.field(FormAction.LEVEL_PROPERTY)
			.field(FormAction.URL_PROPERTY)
			.field(FormAction.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的简单属性序列化列表 */
	protected SerializeScope getCandidateContainerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY)
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的简单属性序列化列表 */
	protected SerializeScope getCandidateElementSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY)
			.field(CandidateElement.TYPE_PROPERTY)
			.field(CandidateElement.IMAGE_PROPERTY)
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatWorkappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
			.field(WechatWorkappIdentify.USER_ID_PROPERTY)
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatMiniappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
			.field(WechatMiniappIdentify.APP_ID_PROPERTY)
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** TreeNode的简单属性序列化列表 */
	protected SerializeScope getTreeNodeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY)
			.field(TreeNode.NODE_TYPE_PROPERTY)
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	/** Platform的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPlatformListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='Demo Data Service';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(Platform.ID_PROPERTY)
			.field(Platform.NAME_PROPERTY).as("title")
			.field(Platform.VERSION_PROPERTY)
		;
	}

	/** Image的ListOf时需要序列化的属性列表 */
	protected SerializeScope getImageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='demo image';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='image_path';
		//	type='string_image';
		//	value='banner-800-400-red.jpg';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_path';
		//	type='string_image';
		//	value='banner-800-400-red.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(Image.ID_PROPERTY)
			.field(Image.NAME_PROPERTY).as("title")
			.field(Image.IMAGE_PATH_PROPERTY).as("brief")
			.field(Image.CREATE_TIME_PROPERTY)
			.field(Image.PLATFORM_PROPERTY, getPlatformSummaryScope())
			.field(Image.VERSION_PROPERTY)
		;
	}

	/** UserDomain的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserDomainListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='用户区域';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY).as("title")
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserWhiteListListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='user_identity';
		//	type='string';
		//	value='clariones|13808188512';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='user_special_functions';
		//	type='string';
		//	value='tester;ios-spokesperson';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY).as("title")
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY).as("brief")
			.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSecUserListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='login';
		//	type='string';
		//	value='login';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='verification_code';
		//	type='int';
		//	value='0|9999999';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY).as("title")
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY).as("brief")
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='审车平台|账户管理|接车公司|审车公司|维修公司|顾客';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='app_icon';
		//	type='string';
		//	value='users|bank|wechat|bar-chart|user|users';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY).as("title")
			.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(UserApp.APP_ICON_PROPERTY).as("brief")
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的ListOf时需要序列化的属性列表 */
	protected SerializeScope getQuickLinkListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='icon';
		//	type='string';
		//	value='facebook|google';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_path';
		//	type='string_image';
		//	value='y-200-200-red.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY).as("title")
			.field(QuickLink.ICON_PROPERTY).as("brief")
			.field(QuickLink.IMAGE_PATH_PROPERTY).as("imageUrl")
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getListAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='internal_name';
		//	type='string';
		//	value='levelOneCategoryList';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY).as("title")
			.field(ListAccess.INTERNAL_NAME_PROPERTY).as("brief")
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** ObjectAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getObjectAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='控制访问列表1';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='object_type';
		//	type='string';
		//	value='FranchiseeStoreCountryCenter|AccountSet';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(ObjectAccess.ID_PROPERTY)
			.field(ObjectAccess.NAME_PROPERTY).as("title")
			.field(ObjectAccess.OBJECT_TYPE_PROPERTY).as("brief")
			.field(ObjectAccess.LIST1_PROPERTY)
			.field(ObjectAccess.LIST2_PROPERTY)
			.field(ObjectAccess.LIST3_PROPERTY)
			.field(ObjectAccess.LIST4_PROPERTY)
			.field(ObjectAccess.LIST5_PROPERTY)
			.field(ObjectAccess.LIST6_PROPERTY)
			.field(ObjectAccess.LIST7_PROPERTY)
			.field(ObjectAccess.LIST8_PROPERTY)
			.field(ObjectAccess.LIST9_PROPERTY)
			.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ObjectAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLoginHistoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='from_ip';
		//	type='string';
		//	value='192.168.1.1|192.168.1.2';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='登陆成功';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY).as("title")
			.field(LoginHistory.DESCRIPTION_PROPERTY).as("brief")
			.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** GenericForm的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGenericFormListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='登记输入单';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='姓名就是你身份证上的名字';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(GenericForm.ID_PROPERTY)
			.field(GenericForm.TITLE_PROPERTY).as("title")
			.field(GenericForm.DESCRIPTION_PROPERTY).as("brief")
			.field(GenericForm.VERSION_PROPERTY)
		;
	}

	/** FormMessage的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormMessageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='字段组合错误';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='level';
		//	type='string';
		//	value='success|info|warning|danger';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormMessage.ID_PROPERTY)
			.field(FormMessage.TITLE_PROPERTY).as("title")
			.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormMessage.LEVEL_PROPERTY).as("brief")
			.field(FormMessage.VERSION_PROPERTY)
		;
	}

	/** FormFieldMessage的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormFieldMessageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='输入错误';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='parameter_name';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormFieldMessage.ID_PROPERTY)
			.field(FormFieldMessage.TITLE_PROPERTY).as("title")
			.field(FormFieldMessage.PARAMETER_NAME_PROPERTY).as("brief")
			.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormFieldMessage.LEVEL_PROPERTY)
			.field(FormFieldMessage.VERSION_PROPERTY)
		;
	}

	/** FormField的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormFieldListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='parameter_name';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='姓名就是你身份证上的名字';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormField.ID_PROPERTY)
			.field(FormField.LABEL_PROPERTY)
			.field(FormField.LOCALE_KEY_PROPERTY)
			.field(FormField.PARAMETER_NAME_PROPERTY).as("title")
			.field(FormField.TYPE_PROPERTY)
			.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormField.PLACEHOLDER_PROPERTY)
			.field(FormField.DEFAULT_VALUE_PROPERTY)
			.field(FormField.DESCRIPTION_PROPERTY).as("brief")
			.field(FormField.FIELD_GROUP_PROPERTY)
			.field(FormField.MINIMUM_VALUE_PROPERTY)
			.field(FormField.MAXIMUM_VALUE_PROPERTY)
			.field(FormField.REQUIRED_PROPERTY)
			.field(FormField.DISABLED_PROPERTY)
			.field(FormField.CUSTOM_RENDERING_PROPERTY)
			.field(FormField.CANDIDATE_VALUES_PROPERTY)
			.field(FormField.SUGGEST_VALUES_PROPERTY)
			.field(FormField.VERSION_PROPERTY)
		;
	}

	/** FormAction的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormActionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='label';
		//	type='string';
		//	value='功能';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='locale_key';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(FormAction.ID_PROPERTY)
			.field(FormAction.LABEL_PROPERTY).as("title")
			.field(FormAction.LOCALE_KEY_PROPERTY).as("brief")
			.field(FormAction.ACTION_KEY_PROPERTY)
			.field(FormAction.LEVEL_PROPERTY)
			.field(FormAction.URL_PROPERTY)
			.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormAction.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateContainerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='我只是一个容器';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY).as("title")
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateElementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='搜索到的匹配字段';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='类型描述';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image';
		//	type='string_image';
		//	value='1.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY).as("title")
			.field(CandidateElement.TYPE_PROPERTY).as("brief")
			.field(CandidateElement.IMAGE_PROPERTY).as("imageUrl")
			.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatWorkappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='corp_id';
		//	type='string';
		//	value='corporation123';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='user_id';
		//	type='string';
		//	value='user123';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY).as("title")
			.field(WechatWorkappIdentify.USER_ID_PROPERTY).as("brief")
			.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatMiniappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='open_id';
		//	type='string';
		//	value='wechat_open_id_1234567890';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='app_id';
		//	type='string';
		//	value='wechat_miniapp_id_1234567890';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY).as("title")
			.field(WechatMiniappIdentify.APP_ID_PROPERTY).as("brief")
			.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** TreeNode的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTreeNodeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='node_id';
		//	type='string';
		//	value='node000001';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='node_type';
		//	type='string';
		//	value='nodetype';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(DemodataBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY).as("title")
			.field(TreeNode.NODE_TYPE_PROPERTY).as("brief")
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	
	public SerializeScope getListOfViewScope(String listClassName, String ownerClassName) {
		return scopes.get(listClassName);
	}
	
	
	protected Map<String, SerializeScope> scopes;
	protected void initAllViewScope() {
		scopes = new HashMap<>();
		scopes.put(Platform.class.getName(),getPlatformListOfViewScope());
		scopes.put(Image.class.getName(),getImageListOfViewScope());
		scopes.put(UserDomain.class.getName(),getUserDomainListOfViewScope());
		scopes.put(UserWhiteList.class.getName(),getUserWhiteListListOfViewScope());
		scopes.put(SecUser.class.getName(),getSecUserListOfViewScope());
		scopes.put(UserApp.class.getName(),getUserAppListOfViewScope());
		scopes.put(QuickLink.class.getName(),getQuickLinkListOfViewScope());
		scopes.put(ListAccess.class.getName(),getListAccessListOfViewScope());
		scopes.put(ObjectAccess.class.getName(),getObjectAccessListOfViewScope());
		scopes.put(LoginHistory.class.getName(),getLoginHistoryListOfViewScope());
		scopes.put(GenericForm.class.getName(),getGenericFormListOfViewScope());
		scopes.put(FormMessage.class.getName(),getFormMessageListOfViewScope());
		scopes.put(FormFieldMessage.class.getName(),getFormFieldMessageListOfViewScope());
		scopes.put(FormField.class.getName(),getFormFieldListOfViewScope());
		scopes.put(FormAction.class.getName(),getFormActionListOfViewScope());
		scopes.put(CandidateContainer.class.getName(),getCandidateContainerListOfViewScope());
		scopes.put(CandidateElement.class.getName(),getCandidateElementListOfViewScope());
		scopes.put(WechatWorkappIdentify.class.getName(),getWechatWorkappIdentifyListOfViewScope());
		scopes.put(WechatMiniappIdentify.class.getName(),getWechatMiniappIdentifyListOfViewScope());
		scopes.put(TreeNode.class.getName(),getTreeNodeListOfViewScope());
	}

}







