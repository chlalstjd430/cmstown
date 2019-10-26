package com.cmstown.model.service.board;

import com.cmstown.model.dao.StudyBoardDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class StudyBoardDeleteServiceImpl implements StudyBoardDeleteService{
    @Autowired
    private StudyBoardDAO studyBoardDAO;

    public boolean deleteArticle(Integer no) {
        boolean result = false;
        if(studyBoardDAO.deleteStudyBoard(no) > 0){
            result = true;
        }
        return result;
    }
}
