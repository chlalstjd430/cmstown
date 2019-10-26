package com.cmstown.mybatis;

import com.cmstown.model.vo.ReplyVO;

import java.util.List;
import java.util.Map;

public interface AccountMapper {

    String selectReplyPassword(Integer replyID);
}
