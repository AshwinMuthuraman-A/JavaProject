package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.BinaryData;
import com.example.demo.services.BinaryDataServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class BinaryDataController {
	
	@Autowired
	private BinaryDataServiceImpl bds;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		return new ResponseEntity<>(bds.addFile(file), HttpStatus.OK);
	}
	
	@GetMapping(value="/download/{id}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
		System.out.println("Download file id: " + id);
		BinaryData bd = bds.downloadFile(id);
		System.out.println("Hello"+ bd.getType());
		if(bd.getType()!=null)
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(bd.getType())).
				header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + bd.getName() +"\"").
				body(new ByteArrayResource(bd.getFile()));
		return null;
	}
}
