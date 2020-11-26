package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;

@Mapper
public interface FileMapper {

	
	@Select("Select * from FILES where userid = #{id}")
	List<File> getFiles(Integer id);
	
	@Select("Select * from FILES where fileId = #{id}")
	File getFile(Integer id);
	
	@Insert("Insert into FILES (filename,contenttype,filesize,userid,filedata) VALUES(#{filename}, #{contenttype}, #{filesize}, #{userid}, #{filedata})")
	Integer insert(File file);
	
	@Delete("Delete from FILES where fileId = #{id}")
	void delete(Integer id);
	
	@Update("UPDATE FILES SET filename=#{filename}, contenttype =#{contenttype}, filesize =#{filesize}, userid =#{userid}, filedata =#{filedata} WHERE  fileId=#{fileId}")
	void update(File file);
	
}
