package com.example.demo.input.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.input.entity.po.InputFile;
import com.example.demo.input.entity.vo.InputFileVo;
import com.example.demo.input.service.InputFileService;

@RestController
public class InputFileController {

	@Autowired
	private InputFileService service;

	@GetMapping
	public InputFile get(Integer id) {
		return service.getInputFile(id);
	}

	@PostMapping
	public void create(@RequestBody InputFileVo inputFileVo) {
		service.createInputFile(inputFileVo);
	}

}
