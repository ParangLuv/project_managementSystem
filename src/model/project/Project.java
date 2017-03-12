package model.project;

import java.util.Date;

public class Project {

	private int serialNo;
	private String name;
	private String content;
	private Date startDate;
	private Date endDate;
	private String process;
	
	
	public int getSerialNo() {
		return serialNo;
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getProcess() {
		return process;
	}
	
	public Project(String name, String content, Date startDate, Date endDate, String process) {
		this.name = name;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.process = process;
	}
	
	public Project(int serialNo, String name, String content, Date startDate, Date endDate, String process) {
		this.serialNo = serialNo;
		this.name = name;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.process = process;
	}

	
	
	
	
	
}
