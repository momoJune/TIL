package kr.sga.gkmarket.qna.dao;


import org.apache.ibatis.annotations.Mapper;

import kr.sga.gkmarket.qna.vo.BackQnaReplyVO;

@Mapper
public interface BackQnaReplyDAO {
	// 게시글 하나의 댓글수 가져오기
	int selectCommCount(int ref);
	// 저장 (1:1 문의 답변등록)
	void insert(BackQnaReplyVO backQnaReplyVO) ;
	// 수정 (1:1 문의 답변수정) 
	void update(BackQnaReplyVO backQnaReplyVO) ;
	// 삭제 (1:1 문의 답변삭제)
	void delete(int idx) ;
}
