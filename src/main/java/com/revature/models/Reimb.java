package com.revature.models;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement")
public class Reimb {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int reimbId;
	
	@Column(name="reimb_amount",nullable=false)
	private double amount;
	
	@Column(name="reimb_submitted",nullable=false)
	private Timestamp submmited;
	
	@Column(name="reimb_resolved")
	private Timestamp resolved;
	
	@Column(name="reimb_description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_author",nullable=false)
	private User author;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_resolver")
	private User resolver;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_status_id",nullable=false)
	private ReimbStatus rStatus;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_type_id",nullable=false)
	private ReimbType rType;

	public Reimb() {
		super();
	}

	
	
	
	public Reimb(double amount, Timestamp submmited, Timestamp resolved, String description, User author, User resolver,
			ReimbStatus rStatus, ReimbType rType) {
		super();
		this.amount = amount;
		this.submmited = submmited;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.rStatus = rStatus;
		this.rType = rType;
	}



	public Reimb(int reimbId, double amount, Timestamp submmited, Timestamp resolved, String description, User author,
			User resolver, ReimbStatus rStatus, ReimbType rType) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submmited = submmited;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.rStatus = rStatus;
		this.rType = rType;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((rStatus == null) ? 0 : rStatus.hashCode());
		result = prime * result + ((rType == null) ? 0 : rType.hashCode());
		result = prime * result + reimbId;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((submmited == null) ? 0 : submmited.hashCode());
		return result;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimb other = (Reimb) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (rStatus == null) {
			if (other.rStatus != null)
				return false;
		} else if (!rStatus.equals(other.rStatus))
			return false;
		if (rType == null) {
			if (other.rType != null)
				return false;
		} else if (!rType.equals(other.rType))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (submmited == null) {
			if (other.submmited != null)
				return false;
		} else if (!submmited.equals(other.submmited))
			return false;
		return true;
	}

	

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	public Timestamp getSubmmited() {
		return submmited;
	}



	public void setSubmmited(Timestamp submmited) {
		this.submmited = submmited;
	}



	public Timestamp getResolved() {
		return resolved;
	}



	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public ReimbStatus getrStatus() {
		return rStatus;
	}

	public void setrStatus(ReimbStatus rStatus) {
		this.rStatus = rStatus;
	}

	public ReimbType getrType() {
		return rType;
	}

	public void setrType(ReimbType rType) {
		this.rType = rType;
	}






	@Override
	public String toString() {
		return "Reimb [reimbId=" + reimbId + ", amount=" + amount + ", submmited=" + submmited + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", rStatus=" + rStatus + ", rType=" + rType + "]";
	}

}