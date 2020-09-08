package com.revature.models;

import java.sql.Timestamp;

public class ReimbDTO {
	
	public int reimbId;
	public double amount;
	public Timestamp submitted;
	public Timestamp resolved;
	public String description;
	public String author_name;
	public String resolver_name;
	public String statusString;
	public String typeString;
	
	public ReimbDTO() {
		super();
	}

	public ReimbDTO(int reimbId, double amount, Timestamp submitted, Timestamp resolved, String description,
			String author_name, String resolver_name, String statusString, String typeString) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author_name = author_name;
		this.resolver_name = resolver_name;
		this.statusString = statusString;
		this.typeString = typeString;
	}

	public ReimbDTO(double amount, Timestamp submitted, Timestamp resolved, String description, String author_name,
			String resolver_name, String statusString, String typeString) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author_name = author_name;
		this.resolver_name = resolver_name;
		this.statusString = statusString;
		this.typeString = typeString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author_name == null) ? 0 : author_name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimbId;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver_name == null) ? 0 : resolver_name.hashCode());
		result = prime * result + ((statusString == null) ? 0 : statusString.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ((typeString == null) ? 0 : typeString.hashCode());
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
		ReimbDTO other = (ReimbDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author_name == null) {
			if (other.author_name != null)
				return false;
		} else if (!author_name.equals(other.author_name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver_name == null) {
			if (other.resolver_name != null)
				return false;
		} else if (!resolver_name.equals(other.resolver_name))
			return false;
		if (statusString == null) {
			if (other.statusString != null)
				return false;
		} else if (!statusString.equals(other.statusString))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (typeString == null) {
			if (other.typeString != null)
				return false;
		} else if (!typeString.equals(other.typeString))
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

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
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

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getResolver_name() {
		return resolver_name;
	}

	public void setResolver_name(String resolver_name) {
		this.resolver_name = resolver_name;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	@Override
	public String toString() {
		return "ReimbDTO [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author_name=" + author_name + ", resolver_name="
				+ resolver_name + ", statusString=" + statusString + ", typeString=" + typeString + "]";
	}

}