package com.smhrd.todowedding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.json.simple.JSONObject;

import com.smhrd.todowedding.model.PartnerDTO;
import com.smhrd.todowedding.model.PartnerResponseDto;



/*
 * 기업회원 매퍼
 * 작성 : 서유광
 * 일자 : 2023.09.08
 */

@Mapper
public interface PartnerMapper {
	
	// 로그인
    @Select("SELECT partner_seq, admin_yn, partner_name FROM tw_partner WHERE partner_id = #{partnerId} AND partner_pw = #{partnerPw}")
    public PartnerDTO partnerLogin(String partnerId,String partnerPw);
    
    // 회원가입
    @Insert("INSERT INTO tw_partner ( partner_id, partner_pw, partner_name, partner_registration, partner_tel, partner_link, partner_manager, partner_manager_tel, partner_address, partner_code ) VALUES( #{partner_id}, #{partner_pw}, #{partner_name}, #{partner_registration}, #{partner_tel}, #{partner_link}, #{partner_manager}, #{partner_manager_tel}, #{partner_address}, #{partner_code})")
    public void join(PartnerDTO partnerDTO);
    
    // 아이디 중복체크
    @Select("SELECT partner_id FROM tw_partner WHERE partner_id = #{partner_id}")
    public String uniqueId(String partner_id);
  
    //partner 정보 조회
    @Select("select partner_seq, partner_name, partner_address, partner_tel, partner_link from tw_partner where partner_seq=#{partnerSeq}")
    public PartnerResponseDto findPartnerInfo(Long partnerSeq);
    
    //업체 유형(parter_code)별 리스트 조회 
    @Select("select partner_seq, partner_name, partner_address, partner_tel, partner_link from tw_partner where partner_code=#{parnterCode}")
    public List<PartnerResponseDto> findPatnerByCode(String partnerCode);
    
    //중보 아이디 조회 
    @Select("select * from tw_partner where partner_id=#{partnerId}")
    public JSONObject checkedSameId(String partnerId);
}