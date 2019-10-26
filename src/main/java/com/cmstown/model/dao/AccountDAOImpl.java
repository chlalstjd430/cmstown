package com.cmstown.model.dao;

import com.cmstown.mybatis.AccountMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    private SqlSession sqlSession;

    public String showReplyPassword(Integer replyID) {
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        return mapper.selectReplyPassword(replyID);
    }
}
