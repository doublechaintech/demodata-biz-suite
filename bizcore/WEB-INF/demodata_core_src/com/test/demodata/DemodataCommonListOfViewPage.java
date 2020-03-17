package com.test.demodata;

import com.terapico.caf.viewpage.SerializeScope;

public class DemodataCommonListOfViewPage extends BaseViewPage{

	private static final long serialVersionUID = 3815181812398958602L;

	protected Class<? extends BaseEntity> classOfList;
	protected BaseEntity containerObject;
	protected String requestName;
	protected int requestLimit;
	protected int requestOffset;
	protected String requestBeanName;
	protected SmartList<BaseEntity> dataList;
	protected SerializeScope scope;
	protected String displayMode;
	
	public String getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(String displayMode) {
		this.displayMode = displayMode;
	}

	public SerializeScope getScope() {
		return scope;
	}

	public void setScope(SerializeScope scope) {
		this.scope = scope;
	}
	
	public String getRequestBeanName() {
		return requestBeanName;
	}

	public void setRequestBeanName(String requestBeanName) {
		this.requestBeanName = requestBeanName;
	}

	public Class<? extends BaseEntity> getClassOfList() {
		return classOfList;
	}

	public void setClassOfList(Class<? extends BaseEntity> classOfList) {
		this.classOfList = classOfList;
	}

	public BaseEntity getContainerObject() {
		return containerObject;
	}

	public void setContainerObject(BaseEntity containerObject) {
		this.containerObject = containerObject;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public int getRequestLimit() {
		return requestLimit;
	}

	public void setRequestLimit(int requestLimit) {
		this.requestLimit = requestLimit;
	}

	public int getRequestOffset() {
		return requestOffset;
	}

	public void setRequestOffset(int requestOffset) {
		this.requestOffset = requestOffset;
	}

	public SmartList<BaseEntity> getDataList() {
		return dataList;
	}

	public void setDataList(SmartList<BaseEntity> dataList) {
		this.dataList = dataList;
	}

	@Override
	protected SerializeScope getSerializeScope() {
		SerializeScope itemScope = this.getScope();
		if (itemScope == null) {
			itemScope = DemodataListOfViewScope.getInstance()
					.getListOfViewScope(getClassOfList().getName(), getContainerObject().getClass().getName());
		}
		return SerializeScope.INCLUDE()
				.field(BaseViewPage.X_EMPTY_MESSAGE)
				.field(BaseViewPage.X_NEXT_PAGE_URL)
				.field("list", itemScope).in_data_container()
				.field("toast")
				.field("actionList")
				.field("popup")
			;
	}

	
	@Override
	protected void afterDoRendering() {
		super.afterDoRendering();
		forceResponseAsListOfPage();
	}

	@Override
	public void assemblerContent(DemodataUserContext userContext, String requestName) throws Exception {
		this.set("emptyMessage", "目前没有数据");
		int nextOffset = this.getRequestOffset() + Math.min(this.getRequestLimit(), this.getDataList().size());
		if (nextOffset < this.getDataList().getTotalCount()) {
			// has more
			this.getDataList().add(this.getDataList().last());
		}
		this.getDataList().addItemToValueMap(BaseViewPage.X_NEXT_PAGE_URL, makeNextPageUrl(nextOffset));
		this.getDataList().forEach(it->{
			it.addItemToValueMap("linkToUrl", String.format("%s/view/%s/", this.getRequestBeanName(), it.getId()));
		});
		this.set("list", this.getDataList());
		this.set("display-mode", getDisplayMode());

	}

	private Object makeNextPageUrl(int nextOffset) {
		return String.format("%s/listPageBy%s/%s/%d/%d/", requestBeanName,this.getContainerObject().getClass().getSimpleName(),
				this.getContainerObject().getId(), nextOffset, this.getRequestLimit());
	}
	
	

}









