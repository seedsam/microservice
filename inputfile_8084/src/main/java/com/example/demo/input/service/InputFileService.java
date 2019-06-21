package com.example.demo.input.service;

import com.example.demo.input.entity.po.InputFile;
import com.example.demo.input.entity.vo.InputFileVo;

public interface InputFileService {

	public InputFile getInputFile(Integer id);

	void createInputFile(InputFileVo inputFileVo);

}
