package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

@Mapper
public interface CredentialMapper {
	
	@Select("Select * from CREDENTIALS where userid = #{id}")
	List<Credential> getCredentials(Integer id);

	@Insert("Insert into CREDENTIALS (url,username,key,password,userid) VALUES(#{url}, #{username}, #{key}, #{password}, #{userid})")
	@Options(keyProperty="credentialid")
	Integer insert(Credential credential);
	
	@Delete("Delete from CREDENTIALS where credentialid = #{id}")
	void delete(Integer id);
	
	@Update("UPDATE CREDENTIALS SET url=#{url}, username =#{username}, key =#{key}, password =#{password}, userid =#{userid} WHERE credentialid =#{credentialid}")
	void update(Credential credential);
}
