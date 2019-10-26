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
public class StudyReplyShowServiceImpl implements StudyReplyShowService {
    @Autowired
    private StudyReplyDAO studyReplyDAO;

    public List<ReplyVO> showReplyLIst(Integer boardID) {
        List<ReplyVO> list = studyReplyDAO.selectReplyLIst(boardID);
        return list;
    }
}
