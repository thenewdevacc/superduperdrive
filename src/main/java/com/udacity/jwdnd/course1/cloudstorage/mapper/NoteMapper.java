package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;

@Mapper
public interface NoteMapper {

	@Select("Select * from NOTES where userid = #{id}")
	List<Note> getNotes(Integer id);
	
	@Insert("Insert into NOTES (notetitle,notedescription,userid) VALUES(#{notetitle}, #{notedescription}, #{userid})")
	@Options(keyProperty="noteid")
	Integer insert(Note note);
	
	@Delete("Delete from NOTES where noteid = #{id}")
	void delete(Integer id);
	
	@Update("UPDATE NOTES SET notetitle=#{notetitle}, notedescription =#{notedescription} WHERE noteid =#{noteid}")
	void update(Note note);
}
