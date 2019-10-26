package com.cmstown.model.service.reply;

import com.cmstown.model.vo.ReplyVO;

import java.util.List;
import java.util.Map;

public interface StudyReplyDeleteService {
    boolean deleteReply(Integer replyID);
    boolean deleteBoardAllReply(Integer boardID);
}
