package com.acme.sqs.common.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.acme.architecture.common.entity.AbstractEntity;
import com.acme.sqs.common.constant.CustomEventConstant;
import com.acme.sqs.common.enumerate.CustomEventStatusEnum;
import com.acme.sqs.common.enumerate.CustomEventTypeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomEvent extends AbstractEntity{

	private static final long serialVersionUID = -8107363318111497055L;

	private Long taskId;
	
	private CustomEventTypeEnum type;
	
	private CustomEventStatusEnum status;
	
	private Date creationDate;
	
	public Long getTaskId() {
		return taskId;
	}
	
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public CustomEventTypeEnum getType() {
		return type;
	}

	public void setType(CustomEventTypeEnum type) {
		this.type = type;
	}

	public CustomEventStatusEnum getStatus() {
		return status;
	}

	public void setStatus(CustomEventStatusEnum status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomEvent)) {
			return false;
		}
		
		final CustomEvent other = (CustomEvent)object;

		return new EqualsBuilder().append(getTaskId(), other.getTaskId())
				.append(getType(), other.getType())
				.append(getStatus(), other.getStatus())
				.append(getCreationDate(), other.getCreationDate())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTaskId()).append(getCreationDate()).append(getType()).append(getStatus()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append(CustomEventConstant.FIELD_TASK_ID, getTaskId())
				.append(CustomEventConstant.FIELD_TYPE, getType())
				.append(CustomEventConstant.FIELD_STATUS, getStatus())
				.append(CustomEventConstant.FIELD_CREATIONDATE, getCreationDate())
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
	    return "{" + "\""+CustomEventConstant.FIELD_TASK_ID+"\": " + taskId + ", \"type\": " + type + ", \"status\": " + status + ", \"creationDate\": \"" + creationDate + '\"' + '}';
	  }
	
}
