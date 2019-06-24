package com.example.demo.input.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger logger = LoggerFactory.getLogger(InputFileController.class);

	@Autowired
	private InputFileService service;

	@GetMapping("/")
	public String home() {
		return "调用inputfile服务，端口是8084";
	}

	@GetMapping("/{id}")
	public InputFile get(Integer id) {
		return service.getInputFile(id);
	}

	@PostMapping
	public void create(@RequestBody InputFileVo inputFileVo) {
		logger.info("测试负载均衡：调用的服务端口是：8084");
		service.createInputFile(inputFileVo);
	}

}
