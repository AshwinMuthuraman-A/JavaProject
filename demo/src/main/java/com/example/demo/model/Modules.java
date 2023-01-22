package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modules")
public class Modules {
	
	@Id
	private ObjectId id;
	
	private String moduleId;
	private String name;
	private String desc;
	private String pdfContent;
	private String videoContent;
	
	public Modules() {
		super();
		this.moduleId = null;
	}
	
	public Modules(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPdfContent() {
		return pdfContent;
	}

	public void setPdfContent(String pdfContent) {
		this.pdfContent = pdfContent;
	}

	public String getVideoContent() {
		return videoContent;
	}

	public void setVideoContent(String videoContent) {
		this.videoContent = videoContent;
	}
	
}
