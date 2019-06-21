package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "inputfile", fallback = InputFileError.class)
public interface InputFileService {

	@PostMapping("/")
	public void create(InputFileVo inputFileVo);

}
