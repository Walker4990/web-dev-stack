package com.kh.ajax.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.ajax.mapper.MemberMapper;
import com.kh.ajax.model.vo.Member;

@Mapper
public interface MemberMapper {

	Member idCheck(String id);
	
	boolean idBoolCheck(String id);
	
	void register(Member vo);
}
