package com.cmstown.model.service;

import com.cmstown.model.dao.StudyBoardDAO;
import com.cmstown.model.vo.CategoryVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
