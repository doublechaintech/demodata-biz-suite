package com.test.demodata;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class DemodataCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(DemodataUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}
	
	protected Object daoOf(DemodataUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}
	
	protected DemodataObjectChecker checkerOf(DemodataUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(DemodataUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = "verifyCode:"+mobile;
		ctx.putToCache(cacheKey, verifyCode, DemodataBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(DemodataUserContext ctx, String mobile) {
		String cacheKey = "verifyCode:"+mobile;
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(DemodataUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	
	public com.test.demodata.platform.PlatformManager platformManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getPlatformManager();
	}
	public com.test.demodata.platform.PlatformDAO platformDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getPlatformDAO();
	}
	public com.test.demodata.image.ImageManager imageManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getImageManager();
	}
	public com.test.demodata.image.ImageDAO imageDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getImageDAO();
	}
	public com.test.demodata.userdomain.UserDomainManager userDomainManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.test.demodata.userdomain.UserDomainDAO userDomainDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.test.demodata.userwhitelist.UserWhiteListManager userWhiteListManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.test.demodata.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.test.demodata.secuser.SecUserManager secUserManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.test.demodata.secuser.SecUserDAO secUserDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.test.demodata.userapp.UserAppManager userAppManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.test.demodata.userapp.UserAppDAO userAppDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.test.demodata.quicklink.QuickLinkManager quickLinkManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.test.demodata.quicklink.QuickLinkDAO quickLinkDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.test.demodata.listaccess.ListAccessManager listAccessManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.test.demodata.listaccess.ListAccessDAO listAccessDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.test.demodata.objectaccess.ObjectAccessManager objectAccessManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getObjectAccessManager();
	}
	public com.test.demodata.objectaccess.ObjectAccessDAO objectAccessDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getObjectAccessDAO();
	}
	public com.test.demodata.loginhistory.LoginHistoryManager loginHistoryManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.test.demodata.loginhistory.LoginHistoryDAO loginHistoryDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.test.demodata.genericform.GenericFormManager genericFormManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getGenericFormManager();
	}
	public com.test.demodata.genericform.GenericFormDAO genericFormDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getGenericFormDAO();
	}
	public com.test.demodata.formmessage.FormMessageManager formMessageManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getFormMessageManager();
	}
	public com.test.demodata.formmessage.FormMessageDAO formMessageDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getFormMessageDAO();
	}
	public com.test.demodata.formfieldmessage.FormFieldMessageManager formFieldMessageManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getFormFieldMessageManager();
	}
	public com.test.demodata.formfieldmessage.FormFieldMessageDAO formFieldMessageDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getFormFieldMessageDAO();
	}
	public com.test.demodata.formfield.FormFieldManager formFieldManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getFormFieldManager();
	}
	public com.test.demodata.formfield.FormFieldDAO formFieldDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getFormFieldDAO();
	}
	public com.test.demodata.formaction.FormActionManager formActionManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getFormActionManager();
	}
	public com.test.demodata.formaction.FormActionDAO formActionDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getFormActionDAO();
	}
	public com.test.demodata.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.test.demodata.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.test.demodata.candidateelement.CandidateElementManager candidateElementManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.test.demodata.candidateelement.CandidateElementDAO candidateElementDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.test.demodata.wechatworkappidentify.WechatWorkappIdentifyManager wechatWorkappIdentifyManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentifyManager();
	}
	public com.test.demodata.wechatworkappidentify.WechatWorkappIdentifyDAO wechatWorkappIdentifyDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentifyDAO();
	}
	public com.test.demodata.wechatminiappidentify.WechatMiniappIdentifyManager wechatMiniappIdentifyManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentifyManager();
	}
	public com.test.demodata.wechatminiappidentify.WechatMiniappIdentifyDAO wechatMiniappIdentifyDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentifyDAO();
	}
	public com.test.demodata.treenode.TreeNodeManager treeNodeManagerOf(DemodataUserContext userContext){
		return userContext.getManagerGroup().getTreeNodeManager();
	}
	public com.test.demodata.treenode.TreeNodeDAO treeNodeDaoOf(DemodataUserContext userContext){
		return userContext.getDAOGroup().getTreeNodeDAO();
	}
	
	
	
	

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









