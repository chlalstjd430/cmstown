package com.cmstown.model.service;

import com.cmstown.model.dao.StudyBoardDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@NoArgsConstructor
public class StudyBoardPostServiceImpl implements  StudyBoardPostService{
    @Autowired
    private StudyBoardDAO studyBoardDAO;

    public boolean postArticle(Map<String, Object> articleInfo) {
        boolean result = false;
        if(studyBoardDAO.insertStudyBoard(articleInfo) > 0){
            result = true;
        }
        return result;
    }

    public boolean updateArticle(Map<String, Object> articleInfo) {
        boolean result = false;
        if(studyBoardDAO.updateBoard(articleInfo) > 0){
            result = true;
        }
        return result;
    }

    public boolean addHit(Integer boardID) {
        boolean result = false;
        if(studyBoardDAO.updateHit(boardID) > 0){
            result = true;
        }
        return result;
    }
}
