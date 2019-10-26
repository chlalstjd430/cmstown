package com.cmstown.model.service;

import com.cmstown.model.dao.AccountDAO;
import com.cmstown.security.SHA256;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AccountDAO accountDAO;

    public boolean checkReplyAuth(Integer replyID, String userPW){
        boolean result = false;
        String dbPW = accountDAO.showReplyPassword(replyID);
        userPW = SHA256.encryptSHA256(userPW);

        if(userPW.equals(dbPW)){
            result = true;
        }

        return result;
    }
}
