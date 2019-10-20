package com.cmstown.model.dao;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml"
})
@WebAppConfiguration
public class TestStudyBoardDAO {
    @Autowired
    public StudyBoardDAO studyBoardDAO;

    @Test
    public void 게시판_추가(){
        Map<String,Object> testMap = new HashMap<String, Object>();
        testMap.put("title","title_test");
        testMap.put("content","content_test");
        testMap.put("writer","admin");
        testMap.put("category","etc");


        assertEquals(1,studyBoardDAO.insertStudyBoard(testMap));
    }

    @Test
    public void 게시판_리스트(){
        Map<String,Object> info = new HashMap<String, Object>();
        info.put("categoryID",null);
        info.put("startPage",10);
        System.out.println(studyBoardDAO.selectBoardList(info));
    }

    @Test
    public void 게시판_상세보기(){
        System.out.println(studyBoardDAO.selectOneBoard(3));
    }
    @Test
    public void 게시판_삭제(){
        System.out.println(studyBoardDAO.deleteStudyBoard(1));
    }
    @Test
    public void 게시판_카테고_리스트(){
        System.out.println(studyBoardDAO.showCategoryList());
    }

    @Test
    public void 게시판_카테고리_이름_null(){
        System.out.println(studyBoardDAO.selectCategoryName(null));
    }
    @Test
    public void 게시판_카테고리_이름_유효하지않는번호(){
        System.out.println(studyBoardDAO.selectCategoryName(9));
    }
    @Test
    public void 게시판_카테고리_이름_유효한번호(){
        System.out.println(studyBoardDAO.selectCategoryName(3));
    }


}
