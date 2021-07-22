package com.liv2train.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Column(nullable = false, updatable = false)
	protected Date createdOn;
	
	@Column(nullable = false)
	protected Date updatedOn;
	
	public BaseEntity() {
		super();
	    this.createdOn = new Date();
	    this.updatedOn = new Date();
	}

	public Date getDateCreated() {
		return createdOn;
	}

	public void setDateCreated(Date dateCreated) {
		this.createdOn = dateCreated;
	}

	public Date getDateUpdated() {
		return updatedOn;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.updatedOn = dateUpdated;
	}	

}
