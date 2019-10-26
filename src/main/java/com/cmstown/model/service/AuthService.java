package com.cmstown.model.service;

public interface AuthService {
    boolean checkReplyAuth(Integer replyID, String userPW);
}
