package com.example.demo.services;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.model.BinaryData;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class BinaryDataServiceImpl implements BinaryDataService{
	
	@Autowired
	private GridFsTemplate gfsTemplate;
	
	@Autowired
	private GridFsOperations gfsOperations;
	
	public String addFile(MultipartFile upload) throws IOException {
		DBObject metadata = new BasicDBObject();
		metadata.put("filesize", upload.getSize());
		Object fileID = gfsTemplate.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
		return fileID.toString();
	}
	
	public BinaryData downloadFile(String id) throws IOException {
		System.out.println("File id"+ id);
		GridFSFile gfsFile = gfsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		//System.out.println("MetaData"+ gfsFile.getMetadata().toString());
		BinaryData bd = new BinaryData();
		if(gfsFile!=null && gfsFile.getMetadata()!=null) {
			bd.setName(gfsFile.getFilename());
			bd.setType(gfsFile.getMetadata().getString("_contentType").toString());
			bd.setFilesize(gfsFile.getMetadata().getLong("filesize").toString());
			bd.setFile(IOUtils.toByteArray(gfsOperations.getResource(gfsFile).getInputStream()));
		}
		return bd;
	}
		
}
