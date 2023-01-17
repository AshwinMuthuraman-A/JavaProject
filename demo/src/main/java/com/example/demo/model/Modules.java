package com.example.demo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modules")
public class Modules {
	
	@Id
	private ObjectId id;
	
	private String name;
	private List<ObjectId> contentList;
	public Modules(String name, List<ObjectId> contentList) {
		super();
		this.name = name;
		this.contentList = contentList;
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
	public List<ObjectId> getContentList() {
		return contentList;
	}
	public void setContentList(List<ObjectId> contentList) {
		this.contentList = contentList;
	}	
	
}
