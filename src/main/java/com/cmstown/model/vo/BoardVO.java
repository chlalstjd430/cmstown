package com.cmstown.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class BoardVO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Integer categoryID;
    private String categoryName;
    private String date;
    private Long hit;
}
