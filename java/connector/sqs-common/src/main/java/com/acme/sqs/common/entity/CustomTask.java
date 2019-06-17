package com.acme.sqs.common.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.acme.architecture.common.entity.AbstractEntity;
import com.acme.sqs.common.constant.CustomTaskConstant;
import com.acme.sqs.common.enumerate.CustomTaskTypeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomTask extends AbstractEntity{

	private static final long serialVersionUID = -8107363318111497055L;

	private Long id;
	
	private String data;
	
	private CustomTaskTypeEnum type;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public CustomTaskTypeEnum getType() {
		return type;
	}

	public void setType(CustomTaskTypeEnum type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomTask)) {
			return false;
		}
		
		final CustomTask other = (CustomTask)object;

		return new EqualsBuilder().append(getId(), other.getId())
				.append(getData(), other.getData())
				.append(getType(), other.getType())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getData()).append(getType()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append(CustomTaskConstant.FIELD_ID, getId())
				.append(CustomTaskConstant.FIELD_DATA, getData())
				.append(CustomTaskConstant.FIELD_TYPE, getType())
				.toString();	
	}
	
	
	public String toJSON(){
		try {
	        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public String toJSONBasic() {
	    return "{" + "\""+CustomTaskConstant.FIELD_ID+"\": " + id + ", \"data\": " + data + ", \"type\": " + type + '\"' + '}';
	  }
	
}
