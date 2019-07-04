package com.revature.pojo;

import java.sql.Date;
//import java.util.Date;
//import java.time.LocalDateTime;

public class ReimburseForm {
	
	private Integer reimbursementId;
	
	private Integer employeeID;
	
	private Date startdate;
	
	private Date enddate;
	
	private String form_time;
	
	private String address;
	
	private String description;
	
	private Double course_cost;
	
	private String status;
	
	private String grading_format;
	
	private String events;
	
	private String work_justify;
	
	private String event_attachment;
	
	private String proof;

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public Integer getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(Integer reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getForm_time() {
		return form_time;
	}

	public void setForm_time(String form_time) {
		this.form_time = form_time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCourse_cost() {
		return course_cost;
	}

	public void setCourse_cost(Double course_cost) {
		this.course_cost = course_cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrading_format() {
		return grading_format;
	}

	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getWork_justify() {
		return work_justify;
	}

	public void setWork_justify(String work_justify) {
		this.work_justify = work_justify;
	}

	public String getEvent_attachment() {
		return event_attachment;
	}

	public void setEvent_attachment(String event_attachment) {
		this.event_attachment = event_attachment;
	}



	@Override
	public String toString() {
		return "ReimburseForm [reimbursementId=" + reimbursementId + ", employeeID=" + employeeID + ", startdate="
				+ startdate + ", enddate=" + enddate + ", form_time=" + form_time + ", address=" + address
				+ ", description=" + description + ", course_cost=" + course_cost + ", status=" + status
				+ ", grading_format=" + grading_format + ", events=" + events + ", work_justify=" + work_justify
				+ ", event_attachment=" + event_attachment + ", proof=" + proof + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((course_cost == null) ? 0 : course_cost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + ((event_attachment == null) ? 0 : event_attachment.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((form_time == null) ? 0 : form_time.hashCode());
		result = prime * result + ((grading_format == null) ? 0 : grading_format.hashCode());
		result = prime * result + ((reimbursementId == null) ? 0 : reimbursementId.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((work_justify == null) ? 0 : work_justify.hashCode());
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
		ReimburseForm other = (ReimburseForm) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (course_cost == null) {
			if (other.course_cost != null)
				return false;
		} else if (!course_cost.equals(other.course_cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (enddate == null) {
			if (other.enddate != null)
				return false;
		} else if (!enddate.equals(other.enddate))
			return false;
		if (event_attachment == null) {
			if (other.event_attachment != null)
				return false;
		} else if (!event_attachment.equals(other.event_attachment))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (form_time == null) {
			if (other.form_time != null)
				return false;
		} else if (!form_time.equals(other.form_time))
			return false;
		if (grading_format == null) {
			if (other.grading_format != null)
				return false;
		} else if (!grading_format.equals(other.grading_format))
			return false;
		if (reimbursementId == null) {
			if (other.reimbursementId != null)
				return false;
		} else if (!reimbursementId.equals(other.reimbursementId))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (work_justify == null) {
			if (other.work_justify != null)
				return false;
		} else if (!work_justify.equals(other.work_justify))
			return false;
		return true;
	}

	public ReimburseForm(Integer employeeID, Date startdate, Date enddate, String form_time, String address,
			String description, Double course_cost, String status, String grading_format, String events,
			String work_justify, String event_attachment) {
		super();
		this.employeeID = employeeID;
		this.startdate = startdate;
		this.enddate = enddate;
		this.form_time = form_time;
		this.address = address;
		this.description = description;
		this.course_cost = course_cost;
		this.status = status;
		this.grading_format = grading_format;
		this.events = events;
		this.work_justify = work_justify;
		this.event_attachment = event_attachment;
	}

	public ReimburseForm(Integer employeeID, Date startdate, Date enddate, String time, String address,
			String description, Double cost, String proof, String events) {
		super();
		this.employeeID = employeeID;
		this.startdate = startdate;
		this.enddate = enddate;
		//this.form_time = form_time;
		this.address = address;
		this.description = description;
		this.course_cost = cost;
		//this.status = status;
		//this.grading_format = grading_format;
		this.proof = proof;
		this.events = events;
		//this.work_justify = work_justify;
		//this.event_attachment = event_attachment;
	}
	
	public ReimburseForm(Integer employeeID, Date startdate, Date enddate, String address,
			String description, Double cost, String grading_format, String events) {
		super();
		this.employeeID = employeeID;
		this.startdate = startdate;
		this.enddate = enddate;
		//this.form_time = form_time;
		this.address = address;
		this.description = description;
		this.course_cost = cost;
		//this.status = status;
		this.grading_format = grading_format;
		this.events = events;
		//this.work_justify = work_justify;
		//this.event_attachment = event_attachment;
	}
	
	public ReimburseForm(Integer reimburseId, Integer employeeID, Date startdate, Date enddate, String form_time, String address,
			String description, Double course_cost, String status, String grading_format, String events,
			String work_justify) {
		super();
		this.reimbursementId = reimburseId;
		this.employeeID = employeeID;
		this.startdate = startdate;
		this.enddate = enddate;
		this.form_time = form_time;
		this.address = address;
		this.description = description;
		this.course_cost = course_cost;
		this.status = status;
		this.grading_format = grading_format;
		this.events = events;
		this.work_justify = work_justify;
		//this.event_attachment = event_attachment;
	}

	
	public ReimburseForm(Integer reimburseId, Integer employeeID, Date startdate, Date enddate, String form_time, String address,
			String description, Double course_cost, String status, String grading_format, String events,
			String work_justify, String proof) {
		super();
		this.reimbursementId = reimburseId;
		this.employeeID = employeeID;
		this.startdate = startdate;
		this.enddate = enddate;
		this.form_time = form_time;
		this.address = address;
		this.description = description;
		this.course_cost = course_cost;
		this.status = status;
		this.grading_format = grading_format;
		this.events = events;
		this.work_justify = work_justify;
		this.proof = proof;
		//this.event_attachment = event_attachment;
	}
	
	
	
	public ReimburseForm() {
		// TODO Auto-generated constructor stub
	}
	
	

}