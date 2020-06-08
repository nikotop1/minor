package com.jiuyv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jiuyv.enums.StatusEnum;
import javax.persistence.Entity;

@Entity
@Table(name="tb_template")
public class Template {
	/**主键ID**/
    @Id
    @Column(length=60)
    private String id;

    /**模板名字**/
    @Column(length=60)
    private String name;

    /**路径**/
    @Column
    private String path;

    /**创建日期**/
    @Column
    private Date createTime;

    /**创建人**/
    @Column(length=60)
    private String crdeateBy;

    /**状态 默认是0表示可以使用，1表示冻结状态**/
    @Column
    private Integer status= StatusEnum.UNLOCK.getValue();

    /**模板类型  1,表示word, 2表示pdf**/
    @Column
    private Integer type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCrdeateBy() {
		return crdeateBy;
	}

	public void setCrdeateBy(String crdeateBy) {
		this.crdeateBy = crdeateBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
    
}
