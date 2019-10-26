package com.cmstown.model.dao;

import com.cmstown.model.service.AuthService;
import com.cmstown.security.SHA256;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml",
        "file:web/WEB-INF/applicationContext.xml"
})
@WebAppConfiguration
public class TestAccountDAO {
    @Autowired
    AccountDAO accountDAO;

    @Test
    public void 댓글_비밀번호(){
        assertEquals(SHA256.encryptSHA256("1234"), accountDAO.showReplyPassword(40));
    }
}
