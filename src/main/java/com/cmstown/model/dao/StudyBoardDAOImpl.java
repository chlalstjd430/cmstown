package com.cmstown.model.dao;

import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import com.cmstown.mybatis.StudyBoardMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@NoArgsConstructor
public class StudyBoardDAOImpl implements StudyBoardDAO {
    @Autowired
    private SqlSession sqlSession;

    public int insertStudyBoard(Map<String, Object> insertBoardInfo) {
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.insertStudyBoard(insertBoardInfo);
    }
    public List<CategoryVO> showCategoryList(){
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.selectCategoryList();
    }

    public List<BoardVO> selectBoardList(Map<String,Object> info) {
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.selectBoardList(info);
    }
    public CategoryVO selectCategoryName(Integer categoryNum){
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.selectCategoryName(categoryNum);
    }

    public BoardVO selectOneBoard(Integer boardID) {
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.selectOneBoard(boardID);
    }

    public int updateBoard(Map<String, Object> upadateInfo) {
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.updateBoard(upadateInfo);
    }

    public int updateHit(Integer no) {
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.updateHit(no);
    }
    public int deleteStudyBoard(Integer no){
        StudyBoardMapper mapper = sqlSession.getMapper(StudyBoardMapper.class);
        return mapper.deleteStudyBoard(no);
    }
}
