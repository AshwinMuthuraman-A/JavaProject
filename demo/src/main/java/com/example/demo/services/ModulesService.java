package com.example.demo.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Modules;

import jakarta.validation.ConstraintViolationException;

public interface ModulesService {
	public Modules createModule(String moduleValues, MultipartFile pdfFile, MultipartFile videoFile) 
			throws ConstraintViolationException, IOException;
}
