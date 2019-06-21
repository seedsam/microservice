package com.example.demo.input.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.input.dao.InputFileRepository;
import com.example.demo.input.entity.po.InputFile;
import com.example.demo.input.entity.vo.InputFileVo;
import com.example.demo.input.service.InputFileService;

@Service
public class InputFileServiceImpl implements InputFileService {

	@Autowired
	private InputFileRepository repository;

	@Override
	public InputFile getInputFile(Integer id) {
		return repository.getInputFile(id);
	}

	@Override
	public void createInputFile(InputFileVo inputFileVo) {
		InputFile inputFile = convert(inputFileVo);
		repository.save(inputFile);
	}

	private InputFile convert(InputFileVo vo) {
		InputFile inputFile = new InputFile();
		inputFile.setName(vo.getName());
		inputFile.setPath(vo.getPath());
		return inputFile;
	}

}
