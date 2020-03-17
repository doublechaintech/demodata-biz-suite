package com.test.demodata;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class DemodataObjectChecker extends DemodataChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		DemodataChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		DemodataObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> DemodataObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> DemodataObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  DemodataChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public DemodataObjectChecker checkAndFixPlatform(BaseEntity platformAsBaseEntity){

		if( isChecked(platformAsBaseEntity) ){
			return this;
		}
		markAsChecked(platformAsBaseEntity);
		commonObjectPropertyCheck(platformAsBaseEntity,"id",this::checkIdOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"name",this::checkNameOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"version",this::checkVersionOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"imageList",this::checkImageListOfPlatform);
		return this;

	}

	public DemodataObjectChecker checkAndFixImage(BaseEntity imageAsBaseEntity){

		if( isChecked(imageAsBaseEntity) ){
			return this;
		}
		markAsChecked(imageAsBaseEntity);
		commonObjectPropertyCheck(imageAsBaseEntity,"id",this::checkIdOfImage);
		commonObjectPropertyCheck(imageAsBaseEntity,"name",this::checkNameOfImage);
		commonObjectPropertyCheck(imageAsBaseEntity,"imagePath",this::checkImagePathOfImage);
		commonObjectPropertyAssign(imageAsBaseEntity,"createTime",this::assignCreateTimeOfImage);
		commonObjectPropertyCheck(imageAsBaseEntity,"platform",this::checkPlatformOfImage);
		commonObjectPropertyCheck(imageAsBaseEntity,"version",this::checkVersionOfImage);
		return this;

	}

	public DemodataObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		return this;

	}

	public DemodataObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public DemodataObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatWorkappIdentifyList",this::checkWechatWorkappIdentifyListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatMiniappIdentifyList",this::checkWechatMiniappIdentifyListOfSecUser);
		return this;

	}

	public DemodataObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectAccessList",this::checkObjectAccessListOfUserApp);
		return this;

	}

	public DemodataObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public DemodataObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public DemodataObjectChecker checkAndFixObjectAccess(BaseEntity objectAccessAsBaseEntity){

		if( isChecked(objectAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(objectAccessAsBaseEntity);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"id",this::checkIdOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"name",this::checkNameOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"objectType",this::checkObjectTypeOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list1",this::checkList1OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list2",this::checkList2OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list3",this::checkList3OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list4",this::checkList4OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list5",this::checkList5OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list6",this::checkList6OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list7",this::checkList7OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list8",this::checkList8OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list9",this::checkList9OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"app",this::checkAppOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"version",this::checkVersionOfObjectAccess);
		return this;

	}

	public DemodataObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public DemodataObjectChecker checkAndFixGenericForm(BaseEntity genericFormAsBaseEntity){

		if( isChecked(genericFormAsBaseEntity) ){
			return this;
		}
		markAsChecked(genericFormAsBaseEntity);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"id",this::checkIdOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"title",this::checkTitleOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"description",this::checkDescriptionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"version",this::checkVersionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formMessageList",this::checkFormMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldMessageList",this::checkFormFieldMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldList",this::checkFormFieldListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formActionList",this::checkFormActionListOfGenericForm);
		return this;

	}

	public DemodataObjectChecker checkAndFixFormMessage(BaseEntity formMessageAsBaseEntity){

		if( isChecked(formMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formMessageAsBaseEntity);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"id",this::checkIdOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"title",this::checkTitleOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"form",this::checkFormOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"level",this::checkLevelOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"version",this::checkVersionOfFormMessage);
		return this;

	}

	public DemodataObjectChecker checkAndFixFormFieldMessage(BaseEntity formFieldMessageAsBaseEntity){

		if( isChecked(formFieldMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldMessageAsBaseEntity);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"id",this::checkIdOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"title",this::checkTitleOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"parameterName",this::checkParameterNameOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"form",this::checkFormOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"level",this::checkLevelOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"version",this::checkVersionOfFormFieldMessage);
		return this;

	}

	public DemodataObjectChecker checkAndFixFormField(BaseEntity formFieldAsBaseEntity){

		if( isChecked(formFieldAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldAsBaseEntity);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"id",this::checkIdOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"label",this::checkLabelOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"parameterName",this::checkParameterNameOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"type",this::checkTypeOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"form",this::checkFormOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"placeholder",this::checkPlaceholderOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"defaultValue",this::checkDefaultValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"description",this::checkDescriptionOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"fieldGroup",this::checkFieldGroupOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"minimumValue",this::checkMinimumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"maximumValue",this::checkMaximumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"required",this::checkRequiredOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"disabled",this::checkDisabledOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"customRendering",this::checkCustomRenderingOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"candidateValues",this::checkCandidateValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"suggestValues",this::checkSuggestValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"version",this::checkVersionOfFormField);
		return this;

	}

	public DemodataObjectChecker checkAndFixFormAction(BaseEntity formActionAsBaseEntity){

		if( isChecked(formActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(formActionAsBaseEntity);
		commonObjectPropertyCheck(formActionAsBaseEntity,"id",this::checkIdOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"label",this::checkLabelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"actionKey",this::checkActionKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"level",this::checkLevelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"url",this::checkUrlOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"form",this::checkFormOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"version",this::checkVersionOfFormAction);
		return this;

	}

	public DemodataObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public DemodataObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}

	public DemodataObjectChecker checkAndFixWechatWorkappIdentify(BaseEntity wechatWorkappIdentifyAsBaseEntity){

		if( isChecked(wechatWorkappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatWorkappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"id",this::checkIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"corpId",this::checkCorpIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"userId",this::checkUserIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatWorkappIdentify);
		commonObjectPropertyAssign(wechatWorkappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatWorkappIdentify);
		return this;

	}

	public DemodataObjectChecker checkAndFixWechatMiniappIdentify(BaseEntity wechatMiniappIdentifyAsBaseEntity){

		if( isChecked(wechatMiniappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatMiniappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"id",this::checkIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"openId",this::checkOpenIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"appId",this::checkAppIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatMiniappIdentify);
		commonObjectPropertyAssign(wechatMiniappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatMiniappIdentify);
		return this;

	}

	public DemodataObjectChecker checkAndFixTreeNode(BaseEntity treeNodeAsBaseEntity){

		if( isChecked(treeNodeAsBaseEntity) ){
			return this;
		}
		markAsChecked(treeNodeAsBaseEntity);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"id",this::checkIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeId",this::checkNodeIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeType",this::checkNodeTypeOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"leftValue",this::checkLeftValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"rightValue",this::checkRightValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"version",this::checkVersionOfTreeNode);
		return this;

	}


	public DemodataObjectChecker checkImageListOfPlatform(List<BaseEntity> imageList){
		AtomicInteger index = new AtomicInteger();
		imageList.stream().forEach(image->
			commonObjectElementCheck(image,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixImage));
		return this;
	}

	public static final String PLATFORM_OF_IMAGE = "image.platform";


	public DemodataObjectChecker checkPlatformOfImage(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_IMAGE);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public DemodataObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public DemodataObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public DemodataObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public DemodataObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public DemodataObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public DemodataObjectChecker checkWechatWorkappIdentifyListOfSecUser(List<BaseEntity> wechatWorkappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatWorkappIdentifyList.stream().forEach(wechatWorkappIdentify->
			commonObjectElementCheck(wechatWorkappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatWorkappIdentify));
		return this;
	}

	public DemodataObjectChecker checkWechatMiniappIdentifyListOfSecUser(List<BaseEntity> wechatMiniappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatMiniappIdentifyList.stream().forEach(wechatMiniappIdentify->
			commonObjectElementCheck(wechatMiniappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatMiniappIdentify));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public DemodataObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public DemodataObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public DemodataObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public DemodataObjectChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		AtomicInteger index = new AtomicInteger();
		objectAccessList.stream().forEach(objectAccess->
			commonObjectElementCheck(objectAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixObjectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public DemodataObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public DemodataObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public DemodataObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public DemodataObjectChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public DemodataObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public DemodataObjectChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		AtomicInteger index = new AtomicInteger();
		formMessageList.stream().forEach(formMessage->
			commonObjectElementCheck(formMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormMessage));
		return this;
	}

	public DemodataObjectChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		AtomicInteger index = new AtomicInteger();
		formFieldMessageList.stream().forEach(formFieldMessage->
			commonObjectElementCheck(formFieldMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormFieldMessage));
		return this;
	}

	public DemodataObjectChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		AtomicInteger index = new AtomicInteger();
		formFieldList.stream().forEach(formField->
			commonObjectElementCheck(formField,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormField));
		return this;
	}

	public DemodataObjectChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		AtomicInteger index = new AtomicInteger();
		formActionList.stream().forEach(formAction->
			commonObjectElementCheck(formAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public DemodataObjectChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public DemodataObjectChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public DemodataObjectChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public DemodataObjectChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public DemodataObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public DemodataObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY = "wechat_workapp_identify.sec_user";


	public DemodataObjectChecker checkSecUserOfWechatWorkappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY = "wechat_miniapp_identify.sec_user";


	public DemodataObjectChecker checkSecUserOfWechatMiniappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}

	public DemodataObjectChecker assignCreateTimeOfImage(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public DemodataObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public DemodataObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}
	public DemodataObjectChecker assignCreateTimeOfWechatWorkappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public DemodataObjectChecker assignCreateTimeOfWechatMiniappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}

}

