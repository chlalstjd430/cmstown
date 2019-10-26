package com.cmstown.model.service.reply;

import com.cmstown.model.dao.StudyReplyDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class StudyReplyDeleteServiceImpl implements StudyReplyDeleteService {
    @Autowired
    private StudyReplyDAO studyReplyDAO;

    public boolean deleteReply(Integer replyID) {
        boolean result = studyReplyDAO.deleteReply(replyID);
        return result;
    }

    public boolean deleteBoardAllReply(Integer boardID) {
        boolean result = studyReplyDAO.deleteBoardReply(boardID);
        return result;
    }
}
