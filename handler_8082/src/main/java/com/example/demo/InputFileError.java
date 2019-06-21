package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InputFileError implements InputFileService {

	private Logger logger = LoggerFactory.getLogger(InputFileError.class);

	@Override
	public void create(InputFileVo inputFileVo) {
		logger.info("inputfile create failure: sorry,error!");
	}

}
