package com.cmstown.model.etc;

import com.cmstown.model.dao.AccountDAO;
import com.cmstown.security.SHA256;
import com.nhncorp.lucy.security.xss.XssPreventer;
import com.nhncorp.lucy.security.xss.XssSaxFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml",
        "file:web/WEB-INF/applicationContext.xml"
})
@WebAppConfiguration
public class TestXSS {

    @Test
    public void XSS_doFilter(){
        XssSaxFilter filter = XssSaxFilter.getInstance("lucy-xss-superset-sax.xml");
        String dirty = "\"><script>alert('xss');</script>";
        String clean = XssPreventer.escape(dirty);

        System.out.println(clean);
    }
}
