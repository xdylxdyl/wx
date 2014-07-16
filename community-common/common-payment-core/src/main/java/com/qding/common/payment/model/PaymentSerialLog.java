package com.qding.common.payment.model;

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
@Table(name = "payment_serial_log")
public class PaymentSerialLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5617565353187282944L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String gorderCode;
	
  	 
    private  Long paymentTypeId;
	
  	 
    private  String mernum;
	
  	 
    private  String termid;
	
  	 
    private  String trandate;
	
  	 
    private  String trantime;
	
  	 
    private  String referno;
	
  	 
    private  String batchno;
	
  	 
    private  String serialno;
	
  	 
    private  String pan;
	
  	 
    private  String amt;
	
  	 
    private  String trantype;
	
  	 
    private  String paytype;
	
  	 
    private  String orderId;
	
  	 
    private  String ext1;
	
  	 
    private  String ext2;
	
  	 
    private  String sign;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "gorder_code")
	public String getGorderCode() {
		return gorderCode;
	}
	
	
	public void setGorderCode(String gorderCode) {
		this.gorderCode = gorderCode;
	}
		 	@Column(name = "payment_type_id")
	public Long getPaymentTypeId() {
		return paymentTypeId;
	}
	
	
	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
		 	@Column(name = "mernum")
	public String getMernum() {
		return mernum;
	}
	
	
	public void setMernum(String mernum) {
		this.mernum = mernum;
	}
		 	@Column(name = "termid")
	public String getTermid() {
		return termid;
	}
	
	
	public void setTermid(String termid) {
		this.termid = termid;
	}
		 	@Column(name = "trandate")
	public String getTrandate() {
		return trandate;
	}
	
	
	public void setTrandate(String trandate) {
		this.trandate = trandate;
	}
		 	@Column(name = "trantime")
	public String getTrantime() {
		return trantime;
	}
	
	
	public void setTrantime(String trantime) {
		this.trantime = trantime;
	}
		 	@Column(name = "referno")
	public String getReferno() {
		return referno;
	}
	
	
	public void setReferno(String referno) {
		this.referno = referno;
	}
		 	@Column(name = "batchno")
	public String getBatchno() {
		return batchno;
	}
	
	
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
		 	@Column(name = "serialno")
	public String getSerialno() {
		return serialno;
	}
	
	
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
		 	@Column(name = "pan")
	public String getPan() {
		return pan;
	}
	
	
	public void setPan(String pan) {
		this.pan = pan;
	}
		 	@Column(name = "amt")
	public String getAmt() {
		return amt;
	}
	
	
	public void setAmt(String amt) {
		this.amt = amt;
	}
		 	@Column(name = "trantype")
	public String getTrantype() {
		return trantype;
	}
	
	
	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}
		 	@Column(name = "paytype")
	public String getPaytype() {
		return paytype;
	}
	
	
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
		 	@Column(name = "orderId")
	public String getOrderId() {
		return orderId;
	}
	
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
		 	@Column(name = "ext1")
	public String getExt1() {
		return ext1;
	}
	
	
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
		 	@Column(name = "ext2")
	public String getExt2() {
		return ext2;
	}
	
	
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
		 	@Column(name = "sign")
	public String getSign() {
		return sign;
	}
	
	
	public void setSign(String sign) {
		this.sign = sign;
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
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

