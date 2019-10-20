package com.cmstown.model.service;

import com.cmstown.model.vo.BoardVO;

import java.util.List;
import java.util.Map;

public interface StudyBoardShowService {
    Map<String,Object> showList(Map<String,Object> info);
    BoardVO showArticle(Integer boardID);
}
