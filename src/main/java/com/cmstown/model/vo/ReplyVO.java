package com.cmstown.model.vo;

import lombok.Data;

@Data
public class ReplyVO {
    private Long boardID;
    private Long replyID;
    private String content;
    private String writer;
    private String password;
    private String date;
}
