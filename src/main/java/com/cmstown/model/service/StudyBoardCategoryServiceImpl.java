package com.cmstown.model.service;

import com.cmstown.model.dao.StudyBoardDAO;
import com.cmstown.model.vo.CategoryVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class StudyBoardCategoryServiceImpl implements  StudyBoardCategoryService{
    @Autowired
    private StudyBoardDAO studyBoardDAO;

    public List<CategoryVO> showList() {
        return studyBoardDAO.showCategoryList();
    }

    public CategoryVO categoryName(int categoryNum) {
        return studyBoardDAO.selectCategoryName(categoryNum);
    }
}
