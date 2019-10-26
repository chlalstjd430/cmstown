package com.cmstown.model.service.reply;

import com.cmstown.model.vo.ReplyVO;

import java.util.List;
import java.util.Map;

public interface StudyReplyPostService {
    boolean addReply(Map<String, Object> info);
    boolean updateReply(Map<String, Object> info);
}
