package com.cmstown.mybatis;

import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import com.cmstown.model.vo.ReplyVO;

import java.util.List;
import java.util.Map;

public interface StudyBoardMapper {
    //게시판
    int insertStudyBoard(Map<String,Object> insertBoardInfo);
    List<BoardVO> selectBoardList(Map<String,Object> info);
    //카테고리
    List<CategoryVO> selectCategoryList();
    CategoryVO selectCategoryName(Integer categoryID);
    BoardVO selectOneBoard(Integer boardID);
    int updateBoard(Map<String,Object> updateInfo);
    int updateHit(Integer no);
    int deleteStudyBoard(Integer no);
    List<ReplyVO> selectReplyList(Integer boardID);
}
