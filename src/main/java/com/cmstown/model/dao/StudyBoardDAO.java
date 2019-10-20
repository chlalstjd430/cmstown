package com.cmstown.model.dao;

import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;

import java.util.List;
import java.util.Map;

public interface StudyBoardDAO {
    int insertStudyBoard(Map<String,Object> insertBoardInfo);
    List<CategoryVO> showCategoryList();
    List<BoardVO> selectBoardList(Map<String,Object> info);
    CategoryVO selectCategoryName(Integer categoryNum);
    BoardVO selectOneBoard(Integer boardID);
    int updateBoard(Map<String,Object> upadateInfo);
    int updateHit(Integer no);
    int deleteStudyBoard(Integer no);
}
