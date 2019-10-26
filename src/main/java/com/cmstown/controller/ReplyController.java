package com.cmstown.controller;

import com.cmstown.Validation;
import com.cmstown.mail.EmailSender;
import com.cmstown.model.service.AuthService;
import com.cmstown.model.service.reply.StudyReplyDeleteService;
import com.cmstown.model.service.reply.StudyReplyPostService;
import com.cmstown.model.service.reply.StudyReplyPostServiceImpl;
import com.cmstown.model.service.reply.StudyReplyShowService;
import com.cmstown.model.vo.Email;
import com.cmstown.security.SHA256;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    private StudyReplyShowService replyShowService;
    @Autowired
    private StudyReplyPostService studyReplyPostService;
    @Autowired
    private StudyReplyDeleteService studyReplyDeleteService;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addReply(@RequestBody String jsonData){

        JSONObject jsonObject = new JSONObject(jsonData);

        Integer boardID = Integer.parseInt((String)jsonObject.get("boardID"));
        String content = (String)jsonObject.get("content");
        String email = (String)jsonObject.get("email");
        String pw = (String)jsonObject.get("pw");

        Map<String,Object> result = new HashMap<String, Object>();
//        validate
        if(!Validation.isPossibleEmail(email)){
            result.put("result",false);
            result.put("mention","작성자 이메일을 올바르게 입력해주세요");
            return result;
        }
        if(!Validation.isPossiblePW(pw)){
            result.put("result",false);
            result.put("mention","작성자 비밀번호를 올바르게 입력해주세요.\n비밀번호 양식 : 숫자 4자리");
            return result;
        }
        if(!Validation.checkStringIsNull(content)){
            result.put("result",false);
            result.put("mention","댓글 내용을 적어주세요.");
            return result;
        }



        Map<String, Object> info = new HashMap<String, Object>();
        info.put("boardID", boardID);
        info.put("content", content);
        info.put("writer", email);
        info.put("password", SHA256.encryptSHA256(pw));

        boolean isSuccess = studyReplyPostService.addReply(info);
        if(isSuccess){
            result.put("result",true);
            result.put("mention","성공적으로 댓글이 입력되었습니다.");
            Email e = new Email();

            e.setReciver("cms3136@gmail.com");
            e.setSubject("[www.cmstown.shop] 새로운 댓글이 작성되었습니다. 지금 바로 확인해보세요!");
            e.setContent("새로운 댓글이 작성되었습니다. 지금 바로 확인해보세요.\nwww.cmstown.shop/study/info?category=All&no="+boardID);
            try {
                emailSender.SendEmail(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            result.put("result",false);
            result.put("mention","일시적으로 댓글 입력이 완료되지 않았습니다.\n잠시후에 다시 시도해주시기 바랍니다.");
        }

        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteReply(@RequestBody String jsonInfo){
        Map<String,Object> result = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject(jsonInfo);

        System.out.println(jsonInfo);

        Integer replyID = Integer.parseInt((String)jsonObject.get("replyID"));
        String inputPW = (String)jsonObject.get("password");

        System.out.println(replyID+","+inputPW);

        if(authService.checkReplyAuth(replyID,inputPW)){
            if(studyReplyDeleteService.deleteReply(replyID)){
                result.put("result",true);
                result.put("comment","정상적으로 삭제처리 되었습니다.");
            }
            else{
                result.put("result",false);
                result.put("comment","존재하지 않는 댓글입니다.");
            }
        }
        else{
            result.put("result",false);
            result.put("comment","비밀번호가 맞지 않습니다.");
        }

        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateReply(@RequestBody String jsonInfo){
        Map<String,Object> result = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject(jsonInfo);

        Integer replyID = Integer.parseInt((String)jsonObject.get("replyID"));
        String inputPW = (String)jsonObject.get("password");
        String newContent = (String)jsonObject.get("content");


        if(authService.checkReplyAuth(replyID,inputPW)){
            Map<String,Object> info = new HashMap<String, Object>();
            info.put("replyID",replyID);
            info.put("content",newContent);

            if(studyReplyPostService.updateReply(info)){
                result.put("result",true);
                result.put("comment","정상적으로 수정 되었습니다.");
            }
            else{
                result.put("result",false);
                result.put("comment","존재하지 않는 댓글이거나 잘못된 수정입니다.");
            }
        }
        else{
            result.put("result",false);
            result.put("comment","비밀번호가 맞지 않습니다.");
        }


        return result;
    }
}
