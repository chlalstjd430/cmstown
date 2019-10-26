package com.cmstown.mybatis;

import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import com.cmstown.model.vo.ReplyVO;

import java.util.List;
import java.util.Map;

public interface StudyReplyMapper {

    List<ReplyVO> selectReplyList(Integer boardID);
    boolean insertReply(Map<String,Object> info);
    boolean deleteReply(Integer replyID);
    boolean deleteBoardReply(Integer boardID);
    boolean updateReply(Map<String,Object> info);
}
