package com.ahmete._01_hibernateSatis.entity;

public class BaseEntity {
	
	private Integer state;
	private Long createAt;
	private Long updateAt;
	
	public BaseEntity() {
	}
	
	public BaseEntity(Integer state, Long createAt, Long updateAt) {
		this.state = state;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Long getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
	
	public Long getUpdateAt() {
		return updateAt;
	}
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
	public String toString() {
		return "BaseEntity{" + "state=" + getState() + ", createAt=" + getCreateAt() + ", updateAt=" + getUpdateAt() + '}';
	}
}