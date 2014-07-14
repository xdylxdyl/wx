package com.qding.app.decorate.model;

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
@Table(name = "decorate")
public class Decorate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4060952798279636992L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String serialId;
	
  	 
    private  String userId;
	
  	 
    private  String userName;
	
  	 
    private  String userMobile;
	
  	 
    private  String userWxId;
	
  	 
    private  String userWxName;
	
  	 
    private  Long roomId;
	
  	 
    private  String roomName;
	
  	 
    private  Long buildingId;
	
    
    private String buildingName;
    
  	 
    private  Long venderId;
	
  	 
    private  String venderName;
	
  	 
    private  Long chargerId;
	
  	 
    private  String chargerName;
	
  	 
    private  String chargerMobile;
	
  	 
    private  Long publicsId;
	
  	 
    private  String publicsName;
	
  	 
    private  String drawingCount;
	
  	 
    private  String status;
	
  	 
    private  String expectStartDate;
	
  	 
    private  String expectCheckDate;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createBy;
	


				@Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "serial_id")
	public String getSerialId() {
		return serialId;
	}
	
	
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
		 	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
		 	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
		 	@Column(name = "user_mobile")
	public String getUserMobile() {
		return userMobile;
	}
	
	
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
		 	@Column(name = "user_wx_id")
	public String getUserWxId() {
		return userWxId;
	}
	
	
	public void setUserWxId(String userWxId) {
		this.userWxId = userWxId;
	}
		 	@Column(name = "user_wx_name")
	public String getUserWxName() {
		return userWxName;
	}
	
	
	public void setUserWxName(String userWxName) {
		this.userWxName = userWxName;
	}
		 	@Column(name = "room_id")
	public Long getRoomId() {
		return roomId;
	}
	
	
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
		 	@Column(name = "room_name")
	public String getRoomName() {
		return roomName;
	}
	
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
		 	@Column(name = "building_id")
	public Long getBuildingId() {
		return buildingId;
	}
	
	
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	
    @Column(name = "building_name")
    public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
		 	@Column(name = "vender_id")
	public Long getVenderId() {
		return venderId;
	}
	
	
	public void setVenderId(Long venderId) {
		this.venderId = venderId;
	}
		 	@Column(name = "vender_name")
	public String getVenderName() {
		return venderName;
	}
	
	
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
		 	@Column(name = "chargerId")
	public Long getChargerId() {
		return chargerId;
	}
	
	
	public void setChargerId(Long chargerId) {
		this.chargerId = chargerId;
	}
		 	@Column(name = "charger_name")
	public String getChargerName() {
		return chargerName;
	}
	
	
	public void setChargerName(String chargerName) {
		this.chargerName = chargerName;
	}
		 	@Column(name = "charger_mobile")
	public String getChargerMobile() {
		return chargerMobile;
	}
	
	
	public void setChargerMobile(String chargerMobile) {
		this.chargerMobile = chargerMobile;
	}
		 	@Column(name = "publics_id")
	public Long getPublicsId() {
		return publicsId;
	}
	
	
	public void setPublicsId(Long publicsId) {
		this.publicsId = publicsId;
	}
		 	@Column(name = "publics_name")
	public String getPublicsName() {
		return publicsName;
	}
	
	
	public void setPublicsName(String publicsName) {
		this.publicsName = publicsName;
	}
		 	@Column(name = "drawing_count")
	public String getDrawingCount() {
		return drawingCount;
	}
	
	
	public void setDrawingCount(String drawingCount) {
		this.drawingCount = drawingCount;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
		 	@Column(name = "expect_start_date")
	public String getExpectStartDate() {
		return expectStartDate;
	}
	
	
	public void setExpectStartDate(String expectStartDate) {
		this.expectStartDate = expectStartDate;
	}
		 	@Column(name = "expect_check_date")
	public String getExpectCheckDate() {
		return expectCheckDate;
	}
	
	
	public void setExpectCheckDate(String expectCheckDate) {
		this.expectCheckDate = expectCheckDate;
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
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

