package com.example.demo.input.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.input.entity.po.InputFile;

public interface InputFileRepository extends CrudRepository<InputFile, Integer> {

	@Query("from InputFile where id =:id ")
	public InputFile getInputFile(@Param("id") Integer id);

}
