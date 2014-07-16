package com.gemantic.analyse.dal.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "groups")
public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7987272970233999430L;
	   private Long id;
	    private Long userId;
	    private String name;
	    private Long createdAt;
	    private Long updatedAt;
	    private List<Long> memberList;//用户的成员列表
	 
	    @Transient
	    public List<Long> getMemberList() {
	        return memberList;
	    }
	    public void setMemberList(List<Long> memberList) {
	        this.memberList = memberList;
	    }
	    /**
	     * 全构造函数
	     * @param userId 
	     * @param updateAt
	     * @param createdAt
	     * @param name
	     */
	    public Group(Long userId, Long updatedAt, Long createdAt, String name) {    	
	    	this.setCreatedAt(createdAt);
	    	this.setName(name);
	    	this.setUpdatedAt(updatedAt);
	    	this.setUserId(userId);		
		}
	    /**
	     * 无参构造函数      
	     */
		public Group() {
			
		}
		 /**
	     * 最小构造函数
	     * @param userId   
	     * @param name
	     */
		public Group(Long userId, String groupName) {
			this.userId=userId;
			this.name=groupName;
			this.createdAt=System.currentTimeMillis();
			this.updatedAt=System.currentTimeMillis();
		}

		/**
	     * 获取更新时间
	     * @return 更新时间
	     */
		 @Column(name = "updated_at")
	    public Long getUpdatedAt() {
	        return updatedAt;
	    }

	    /**
	     * 设置更新时间
	     * @param updatedAt 更新时间
	     */
	    public void setUpdatedAt(Long updatedAt) {
	        this.updatedAt = updatedAt;
	    }

	    /**
	     * 获取创建时间
	     * @return 创建时间
	     */
	    @Column(name = "created_at")
	    public Long getCreatedAt() {
	        return createdAt;
	    }

	    /**
	     * 设置创建时间
	     * @param createdAt 创建时间
	     */
	    public void setCreatedAt(Long createdAt) {
	        this.createdAt = createdAt;
	    }
	  /*  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)*/
	    @Id
	    @GeneratedValue(generator = "groups_seq")
	    @GenericGenerator(name = "groups_seq", strategy = "com.gemantic.dal.id.util.IdGenerator",
	            parameters = { @Parameter(name = "sequence", value = "group_seq") })
	    @Column(name = "id")
	    /**
	     * 获取id
	     * @return id
	     */
	    public Long getId() {
	        return id;
	    }

	    /**
	     * 设置id
	     * @param id id
	     */
	    @Transient
	    public void setId(Long id) {
	        this.id = id;
	    }

	    /**
	     * 获取用户帐号id
	     * @return 用户帐号id
	     */
	    @Column(name = "user_id")
	    public Long getUserId() {
	        return userId;
	    }

	    /**
	     * 设置用户帐号id
	     * @param userId 帐号id
	     */
	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    /**
	     * 获取分组名称
	     * @return 分组名称
	     */
	    @Column(name = "name")
	    public String getName() {
	        return name;
	    }

	    /**
	     * 设置分组名称
	     * @param name 分组名称
	     */
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String toString(){
	    	return this.id+":"+this.name+":"+this.userId;
	    }

}
