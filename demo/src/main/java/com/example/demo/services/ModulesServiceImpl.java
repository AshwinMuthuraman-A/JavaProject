package com.example.demo.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Modules;
import com.example.demo.repo.ModulesRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.ConstraintViolationException;

@Service
public class ModulesServiceImpl implements ModulesService {

	@Autowired 
	private ModulesRepo modulesRepos;
	
	@Autowired
	private BinaryDataService bds;

	@Override
	public Modules createModule(String moduleValues, MultipartFile pdfFile, MultipartFile videoFile)
			throws ConstraintViolationException, IOException {
		Modules module = new Modules();
		ObjectMapper objectMapper = new ObjectMapper();
		module = objectMapper.readValue(moduleValues, Modules.class);
		module.setPdfContent(bds.addFile(pdfFile));
		module.setVideoContent(bds.addFile(videoFile));
		modulesRepos.insert(module);
		return module;
	}
	
}
