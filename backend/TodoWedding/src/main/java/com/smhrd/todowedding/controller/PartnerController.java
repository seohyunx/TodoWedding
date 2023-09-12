package com.smhrd.todowedding.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.todowedding.model.PartnerDTO;
import com.smhrd.todowedding.service.PartnerService;


/* 업체 및 관리자 관련 컨트롤러 
 * 작성 : 서유광
 * 일자 : 2023.09.08
 * 수정 
 * 	- 기업 전체 조회 기능 추가 (신지영, 2023.09.12)
 */

@CrossOrigin("http://localhost:3000")
@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;

	// 기업회원 로그인
	@GetMapping("/partner/login")
	public ResponseEntity<?> partnerLogin(@RequestBody PartnerDTO partner) {

		Map<String, Object> loginResult = partnerService.partnerlogin(partner);

		if (loginResult.containsKey("message")) {
			return new ResponseEntity<>(loginResult.get("message"), HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(loginResult, HttpStatus.OK);
		}
	}
	
	
	
	// 기업회원 회원가입
	@PostMapping("/partner/join")
	public ResponseEntity<String> partnerJoin(@RequestBody PartnerDTO partner) {
		
		String result = partnerService.partnerJoin(partner);
		
		if ("SUCCESS".equals(result)) {
		      return ResponseEntity.ok("회원가입 완료");
		    } else if ("DUPLICATE_ID".equals(result)) {
		      return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디가 중복");
		    } else {
		      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
		   }	
	}

	//전체 기업 조회 
	@GetMapping("/partner")
	public List<JSONObject> findAllPartner(){
		return partnerService.findAllPartner();
	}
}
