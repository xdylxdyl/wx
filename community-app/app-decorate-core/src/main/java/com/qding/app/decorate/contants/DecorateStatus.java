package com.qding.app.decorate.contants;

public class DecorateStatus {

	/**
	 * S10：[WEB]已提交待握手 [WX]待装修公司握手
	 */
	public static final String WAIT_DECORATEVENDER_RESPONSE = "S10";

	/**
	 * S20：[WEB]已握手待提交图纸 [WX]待提交图纸
	 */
	public static final String WAIT_SUBMIT_IMAGE = "S20";
	/**
	 * S30：[WEB]已提交图纸待通过 [WX]图纸审核中
	 */
	public static final String IMAGE_APPROVALING = "S30";

	/**
	 * S40：[WEB]审图通过待办许可 [WX]审图通过待办许可
	 */
	public static final String IMAGE_APPROVAL_PASS = "S40";
	/**
	 * S50：[WEB]已办许可待验收 [WX]装修中
	 */
	public static final String DECORATEING = "S50";

	/**
	 * S60：[WEB]已申请验收待响应 [WX]待验收响应
	 */
	public static final String WAIT_ACCEPTANCE_RESPONSE = "S60";

	/**
	 * S70：[WEB]验收已响应待通过 [WX]验收中
	 */
	public static final String ACCEPTANCEING = "S70";
	/**
	 * S80：[WEB]已验收待退款 [WX]验收通过
	 */
	public static final String ACCEPTANCE_PASS = "S80";
	
	/**
	 * S90：[WEB]已申请退款 [WX]待退款
	 */
	public static final String APPLY_DEPOSIT = "S90";
	/**
	 * S100：[WEB]已退款 [WX]已退押金/保证金
	 */
	public static final String DEPOSIT = "S100";
	/**
	 * S00：[WEB]申请取消 [WX]申请取消
	 */
	public static final String CANCEL = "S00";

}
