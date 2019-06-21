/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		// 扫文件
		File file = new File("D:\\scannerTest\\scannerTest.txt");
		if (file.isFile() && file.exists()) {
			log.info("获取文件，准备处理文件");
			try {
				InputStreamReader insr = new InputStreamReader(new FileInputStream(file), "utf-8");
				@SuppressWarnings("resource")
				BufferedReader bufReader = new BufferedReader(insr);
				String fst = bufReader.readLine();
				if (fst.startsWith("A")) {
					log.info("文件格式正常");
					// 创建文件对象
					create(file);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			log.info("当前没有文件");
		}
	}

	private void create(File file) {
		FileVo fileVo = convert(file);
		restTemplate.postForObject("http://localhost:8083/input", fileVo, String.class);
	}

	private FileVo convert(File file) {
		FileVo fileVo = new FileVo();
		fileVo.setName(file.getName());
		fileVo.setPath(file.getAbsolutePath());
		return fileVo;

	}

	class FileVo {

//		private static final long serialVersionUID = 1L;

		private String name;
		private String path;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

	}

}
