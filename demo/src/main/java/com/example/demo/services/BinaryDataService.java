package com.example.demo.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.BinaryData;

public interface BinaryDataService {
	public String addFile(MultipartFile upload) throws IOException;
	public BinaryData downloadFile(String id) throws IOException;
}
