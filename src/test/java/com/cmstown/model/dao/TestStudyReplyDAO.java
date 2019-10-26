package com.cmstown.model.dao;


import com.cmstown.security.SHA256;
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
        "file:web/WEB-INF/mybatis-config.xml",
        "file:web/WEB-INF/applicationContext.xml"
})
@WebAppConfiguration
public class TestStudyReplyDAO {
    @Autowired
    public StudyReplyDAO studyReplyDAO;

    @Test
    public void 댓글_리스트(){
        System.out.println(studyReplyDAO.selectReplyLIst(3));
    }

    @Test
    public void 댓글_추가(){
        Map<String,Object> info = new HashMap<String,Object >();
        info.put("boardID",6);
        info.put("content","댓글 추가 테스트입니다.2");
        info.put("writer","test_user2");
        info.put("password", SHA256.encryptSHA256("1234"));
        assertTrue(studyReplyDAO.insertReply(info));
    }

    @Test
    public void 댓글_삭제(){
        assertTrue(studyReplyDAO.deleteReply(39));
    }

    @Test
    public void 댓글_전체삭제(){
        assertTrue(studyReplyDAO.deleteBoardReply(7));
    }

    @Test
    public void 댓글_업데이트(){
        Map<String,Object> testMap = new HashMap<String, Object>();
        testMap.put("replyID",41);
        testMap.put("content","댓글 업데이트 테스트");

        assertTrue(studyReplyDAO.updateReply(testMap));
    }



}
