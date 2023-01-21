package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modules")
public class Modules {
	
	@Id
	private ObjectId id;
	
	private String name;
	private String pdfContent;
	private String videoContent;
	
	public Modules() {
		super();
	}
	
	public Modules(String name) {
		super();
		this.name = name;
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
