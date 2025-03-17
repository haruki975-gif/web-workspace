package com.kh.mfw.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mfw.board.model.dto.BoardDTO;

public class BoardDAO {
	
	// 게시글 작성
	public void insertBoard(SqlSession sqlSession, BoardDTO board) {
		sqlSession.insert("boardMapper.insertBoard", board);
	}
	
	
	// 게시글 조회
	public List<BoardDTO> selectBoards(SqlSession sqlSession, RowBounds rowBounds) {
		return sqlSession.selectList("boardMapper.selectBoards", null, rowBounds);
	}
	
	// 페이징 처리를 위한 게시글 총 개수 조회
	public int selectBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectBoardCount");
	}
	
	// 게시글 조회수 업데이트
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	// 게시글(1개) 정보 조회
	public BoardDTO findByBoardNo(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.findByBoardNo", boardNo);
	}
	
}
