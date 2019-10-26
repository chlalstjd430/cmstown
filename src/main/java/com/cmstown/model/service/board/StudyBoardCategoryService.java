package com.cmstown.model.service.board;

import com.cmstown.model.vo.CategoryVO;

import java.util.List;
import java.util.Map;

public interface StudyBoardCategoryService {
    List<CategoryVO> showList();
    CategoryVO categoryName(int categoryNum);
}
