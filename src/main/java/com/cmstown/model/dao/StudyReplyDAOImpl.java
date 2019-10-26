package com.cmstown.model.dao;

import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import com.cmstown.model.vo.ReplyVO;
import com.cmstown.mybatis.StudyBoardMapper;
import com.cmstown.mybatis.StudyReplyMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@NoArgsConstructor
public class StudyReplyDAOImpl implements StudyReplyDAO {
    @Autowired
    private SqlSession sqlSession;


    public List<ReplyVO> selectReplyLIst(Integer boardID) {
        StudyReplyMapper mapper = sqlSession.getMapper(StudyReplyMapper.class);
        return mapper.selectReplyList(boardID);
    }

    public boolean insertReply(Map<String,Object> info){
        StudyReplyMapper mapper = sqlSession.getMapper(StudyReplyMapper.class);
        return mapper.insertReply(info);
    }

    public boolean deleteReply(Integer replyID) {
        StudyReplyMapper mapper = sqlSession.getMapper(StudyReplyMapper.class);
        return mapper.deleteReply(replyID);
    }

    public boolean deleteBoardReply(Integer boardID) {
        StudyReplyMapper mapper = sqlSession.getMapper(StudyReplyMapper.class);
        return mapper.deleteBoardReply(boardID);
    }

    public boolean updateReply(Map<String, Object> info) {
        StudyReplyMapper mapper = sqlSession.getMapper(StudyReplyMapper.class);
        return mapper.updateReply(info);
    }
}
