package com.souyidai.oa;

public class RiskForm  {


	/**
	 * 
	 */
	private Long id;
	private boolean isForceUpdateId = false;
	/**
	 * 流程定义ID
	 */
	private String processDefinitionId;
	private boolean isForceUpdateProcessDefinitionId = false;
	/**
	 * key
	 */
	private String formKey;
	private boolean isForceUpdateFormKey = false;
	/**
	 * 类型
	 */
	private String type;
	private boolean isForceUpdateType = false;
	/**
	 * 显示类型
	 */
	private String tableStyle;
	private boolean isForceUpdateTableStyle = false;
	public void copy(RiskForm riskform) {
		this.id = riskform.id;
		this.processDefinitionId = riskform.processDefinitionId;
		this.formKey = riskform.formKey;
		this.type = riskform.type;
		this.tableStyle = riskform.tableStyle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getIsForceUpdateId() {
		return isForceUpdateId;
	}

	public RiskForm setIsForceUpdateId(boolean forceUpdateId) {
		this.isForceUpdateId = forceUpdateId;
		return this;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public boolean getIsForceUpdateProcessDefinitionId() {
		return isForceUpdateProcessDefinitionId;
	}

	public RiskForm setIsForceUpdateProcessDefinitionId(
			boolean forceUpdateProcessDefinitionId) {
		this.isForceUpdateProcessDefinitionId = forceUpdateProcessDefinitionId;
		return this;
	}

	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

	public boolean getIsForceUpdateFormKey() {
		return isForceUpdateFormKey;
	}

	public RiskForm setIsForceUpdateFormKey(boolean forceUpdateFormKey) {
		this.isForceUpdateFormKey = forceUpdateFormKey;
		return this;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getIsForceUpdateType() {
		return isForceUpdateType;
	}

	public RiskForm setIsForceUpdateType(boolean forceUpdateType) {
		this.isForceUpdateType = forceUpdateType;
		return this;
	}

	public String getTableStyle() {
		return tableStyle;
	}

	public void setTableStyle(String tableStyle) {
		this.tableStyle = tableStyle;
	}

	public boolean getIsForceUpdateTableStyle() {
		return isForceUpdateTableStyle;
	}

	public RiskForm setIsForceUpdateTableStyle(boolean forceUpdateTableStyle) {
		this.isForceUpdateTableStyle = forceUpdateTableStyle;
		return this;
	}

	public static RiskForm getInstance(Long id, String processDefinitionId,
			String formKey, String type, String tableStyle) {
		RiskForm riskform = new RiskForm();
		riskform.setId(id);
		riskform.setProcessDefinitionId(processDefinitionId);
		riskform.setFormKey(formKey);
		riskform.setType(type);
		riskform.setTableStyle(tableStyle);
		return riskform;
	}

}