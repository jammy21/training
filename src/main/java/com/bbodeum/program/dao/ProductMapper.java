package com.bbodeum.program.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bbodeum.program.vo.Program;
//@Mapper
public interface ProductMapper {
	@Select("SELECT "
			+ "prog_id, "
			+ "prog_title, "
			+ "prog_location, "
			+ "prog_Price, "
			+ "prog_recruit_num, "
			+ "prog_content, "
			+ "prog_rsv_status, "
			+ "prog_status, "
			+ "prog_due, "
			+ "prog_start_date, "
			+ "prog_end_date, "
			+ "tr_id AS \"trainer.trId\", "
			+ "tr_pwd AS \"trainer.trPwd\" "
			+ "\r\n"
			+ "FROM (SELECT a.*, ROWNUM as rnum\r\n"
			+ "FROM (SELECT c.* ,  b.* , d.*, ap.*\r\n"
			+ "FROM program b join trainer c\r\n"
			+ "ON tr_id=prog_tr_id\r\n"
			+ "join keyword d\r\n"
			+ "on prog_key_id=key_id\r\n"
			+ "JOIN apply ap ON ap.apply_prog_id = b.prog_id\r\n"
			+ "WHERE  prog_key_id=#{keyId} \r\n"
			+ "AND to_char(prog_start_date, 'dy')=#{dy} \r\n"
			+ "AND prog_tr_id=#{trId}\r\n"
			+ "ORDER BY prog_due)\r\n"
			+ "a) WHERE rnum BETWEEN #{start} AND #{end}")
	public List<Program> selectByTrAndKeyAndDy( @Param("trId") String trId, @Param("keyId") int keyId, @Param("dy")String dy, @Param("start")int start, @Param("end")int end);
	
}
