package com.smhrd.todowedding.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 * 금액 총합, 예상 비용 관련 매퍼
 *  - tw_budget 테이블에 budget_cost(예상 지출액) 총합 , budget_expense_cost(지출액) 총합
 *  - tw_income 테이블에 income_cost(수입액)
 *  - tw_marrydate 테이블에 total_budget(결혼 예상금액)
 *  작성자 : 서유광
 *  작성일 : 2023.09.13
 */

@Mapper
public interface TotalMapper {
	
	@Select("SELECT SUM(budget_cost) AS budget_total_expense_cost FROM tw_budget WHERE member_seq = #{memberSeq}")
	public Long find_budget_sum_cost(long memberSeq);
		
	@Select("SELECT SUM(budget_expense_cost) AS budget_total_cost FROM tw_budget WHERE member_seq = #{memberSeq}")
	public Long find_budget_sum_expense_cost(long memberSeq);
	
	@Select("SELECT SUM(income_cost) AS income_total_cost FROM tw_income WHERE member_seq = #{memberSeq}")
	public Long find_income_sum_cost(long memberSeq);
	
	@Select("SELECT total_budget FROM tw_marrydate  WHERE member_seq = #{memberSeq}")
	public Long find_total_budget(long memberSeq);
	
}