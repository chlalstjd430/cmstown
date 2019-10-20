package com.cmstown.model.service;

import java.util.Map;

public interface StudyBoardPostService {
    boolean postArticle(Map<String,Object> articleInfo);
    boolean updateArticle(Map<String,Object> articleInfo);
    boolean addHit(Integer boardID);
}
