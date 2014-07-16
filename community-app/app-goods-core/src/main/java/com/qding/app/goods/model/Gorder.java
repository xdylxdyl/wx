package com.qding.app.goods.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "gorder")
public class Gorder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7615362932181207040L;

	/**
	 * 线下交易
	 * 
	 */
	public static final String Type_Offline = "offline";

	/**
	 * 线上交易
	 * 
	 */
	public static final String Type_online = "online";
    /**
     * 银联支付
     *
     */
    public static final String Type_ll_pay = "llpay";
    /**
     * 支付宝
     *
     */
    public static final String Type_ali_pay = "alipay";
    /**
     * 支付宝
     *
     */
    public static final String Type_pos_pay = "pos";

	// 全部
	public static final int Status_All = 0;
	// 已下单待付款
	public static final int Status_Pending_Payment = 1;
	// 已退单
	public static final int Status_Req_Return = 2;
	// 过期已取消
	public static final int Status_Expire = 3;
	// 已付全款
	public static final int Status_Pay_All = 4;
	// 已全部签收
	public static final int Status_All_Received = 5;
	// 付款中
	public static final int Status_Paying = 6;// 付款后 可能不能及时返回商家修改订单状态
												// 需要任务扫描修改订单状态
	// 支付失败状态
	public static final int Status_Pay_Failure = 7;

	private Long id;

	private Long userID;

	private Long addressID;

	private Long paddressID;

	private Long publicsID;

	private String code;

	private String total;

	private String type;

	private int status;

	private Long createBy;

	private Long updateBy;

	private Long gorderAt;

	private Long payAt;

	private Long updateAt;

	private Long createAt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	@Column(name = "address_id")
	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	@Column(name = "paddress_id")
	public Long getPaddressID() {
		return paddressID;
	}

	public void setPaddressID(Long paddressID) {
		this.paddressID = paddressID;
	}

	@Column(name = "publics_id")
	public Long getPublicsID() {
		return publicsID;
	}

	public void setPublicsID(Long publicsID) {
		this.publicsID = publicsID;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "total")
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "gorder_at")
	public Long getGorderAt() {
		return gorderAt;
	}

	public void setGorderAt(Long gorderAt) {
		this.gorderAt = gorderAt;
	}

	@Column(name = "pay_at")
	public Long getPayAt() {
		return payAt;
	}

	public void setPayAt(Long payAt) {
		this.payAt = payAt;
	}

	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}

	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
