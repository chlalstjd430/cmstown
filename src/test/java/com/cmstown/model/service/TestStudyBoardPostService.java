package com.cmstown.model.service;


import com.cmstown.model.service.board.StudyBoardPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml"
})
@WebAppConfiguration
public class TestStudyBoardPostService {
    @Autowired
    StudyBoardPostService studyBoardPostService;

    @Test
    public void TEST_StudyBoardPost_글작성(){
        Map<String,Object> testMap = new HashMap<String, Object>();
        testMap.put("title","title_test");
        testMap.put("content","content_test");
        testMap.put("writer","admin");
        testMap.put("category","etc");

        assertTrue("test",studyBoardPostService.postArticle(testMap));
    }
}
