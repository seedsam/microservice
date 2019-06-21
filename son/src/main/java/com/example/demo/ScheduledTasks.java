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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 30000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		// 扫文件
		File file = new File("D:\\scannerTest.txt");
		if (file.isFile()) {
			log.info("获取文件，准备处理文件");
			// 挪文件
			try {
				FileUtils.moveFileToDirectory(file, new File("D:\\scannerTest"), false);
				log.info("文件转移成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			log.info("当前没有文件");
		}
		// 创建文件对象
		
	}
}
