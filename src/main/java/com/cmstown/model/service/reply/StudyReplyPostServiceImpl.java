package com.cmstown.model.service.reply;

import com.cmstown.model.dao.StudyReplyDAO;
import com.cmstown.model.vo.ReplyVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class StudyReplyPostServiceImpl implements StudyReplyPostService {
    @Autowired
    private StudyReplyDAO studyReplyDAO;

    public boolean updateReply(Map<String, Object> info) {
        boolean result = studyReplyDAO.updateReply(info);
        return result;
    }

    public boolean addReply(Map<String, Object> info) {
        boolean result = studyReplyDAO.insertReply(info);
        return result;
    }
}
