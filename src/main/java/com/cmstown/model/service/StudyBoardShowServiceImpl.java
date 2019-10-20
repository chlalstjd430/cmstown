package com.cmstown.model.service;

import com.cmstown.model.dao.StudyBoardDAO;
import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class StudyBoardShowServiceImpl implements  StudyBoardShowService{
    @Autowired
    private StudyBoardDAO studyBoardDAO;

    public Map<String,Object> showList(Map<String,Object> info) {
        List<BoardVO> boardList = studyBoardDAO.selectBoardList(info);

        Map<String,Object> listInfo = new HashMap<String, Object>();
        listInfo.put("boardList",boardList);
        CategoryVO categoryVO = studyBoardDAO.selectCategoryName((Integer)info.get("categoryID"));
        if(info.get("categoryID") == null){
            categoryVO.setName("All");
        }
        listInfo.put("category",categoryVO);

        return listInfo;
    }

    public BoardVO showArticle(Integer boardID) {

        return studyBoardDAO.selectOneBoard(boardID);
    }
}
