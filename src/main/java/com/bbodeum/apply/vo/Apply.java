package com.bbodeum.apply.vo;

import java.util.Date;

import com.bbodeum.dog.vo.Dog;
import com.bbodeum.program.vo.Program;
import com.bbodeum.record.vo.Record;

public class Apply {
//	private int applyDogId;
	private Dog dog;
	
//	private int applyProgId;
	private Program program;
	private int applyStatus;
	private Date applyDate;
	private Record record;
	
	
	/**
	 * select * from( select rownum rn, p.prog_title, t.tr_name, 
p.prog_start_date, p.prog_location, p.prog_status, a.* 
from program p
join trainer t on p.prog_tr_id=t.tr_id
join apply a on p.prog_id=a.apply_prog_id
join dog d on a.apply_dog_id=d.dog_id 
where d.dog_mem_id='lewis' 
order by p.prog_start_date)
where rn between 1 and 5;
	 */
	
}
