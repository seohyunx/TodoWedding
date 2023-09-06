package com.smhrd.todowedding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 채팅방 entity
 * 작성자 : 신지영
 * 작성일 : 2023.09.05
 */

@NoArgsConstructor
@Getter
public class Chatroom {

	private Long chatRoomSeq;
	private Long memberSeq;
	private String chatRoomCreateDt;
	private Long partnerSeq;
	
	@Builder
	public Chatroom(Long memberSeq, Long partnerSeq) {
		this.memberSeq = memberSeq;
		this.partnerSeq = partnerSeq;
	}
	
	@Builder
	public Chatroom(Long memberSeq, String chatRoomCreateDt, Long partnerSeq) {
		this.memberSeq = memberSeq;
		this.chatRoomCreateDt = chatRoomCreateDt;
		this.partnerSeq = partnerSeq;
	}
}
