package com.cmstown.controller;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmstown.model.service.board.StudyBoardCategoryService;
import com.cmstown.model.service.board.StudyBoardPostService;
import com.cmstown.model.service.board.StudyBoardShowService;
import com.cmstown.model.service.reply.StudyReplyShowService;
import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import com.cmstown.model.vo.ReplyVO;
import com.cmstown.paging.Pagination;
import com.nhncorp.lucy.security.xss.XssPreventer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/study")
public class StudyController {
    @Autowired
    private StudyBoardPostService studyBoardPostService;
    @Autowired
    private StudyBoardCategoryService studyBoardCategoryService;
    @Autowired
    private StudyBoardShowService studyBoardShowService;
    @Autowired
    private StudyReplyShowService studyReplyShowService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView study(Integer category, Integer page){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("study");

        List<CategoryVO> categoryList = studyBoardCategoryService.showList();

        Map<String,Object> info = new HashMap<String, Object>();
        info.put("categoryID",category);
        int startPage = 0;
        int curPage = 1;
        if(page != null){
            curPage = page;
            startPage = (page-1)*10;
        }
        info.put("startPage",startPage);

        Map<String,Object> boardListInfo = studyBoardShowService.showList(info);

        //--paging logic
        Pagination pagination = new Pagination(((CategoryVO)boardListInfo.get("category")).getCount().intValue(),curPage,1);

        mav.addObject("categoryList",categoryList);
        mav.addObject("category",boardListInfo.get("category"));
        mav.addObject("boardList",boardListInfo.get("boardList"));
        mav.addObject("pagination",pagination);
        return mav;
    }

    @RequestMapping(value = "/info")
    public ModelAndView boardInfo(HttpServletRequest request, HttpServletResponse result,
                                  String category,Integer no,Integer page){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studyInfo");

        category = XssPreventer.escape(category);
        //Cookie for calculate hit count
        Cookie[] cookies = request.getCookies();
        Cookie viewCookie = null;
        boolean cookieFlag = false;
        if (cookies != null && cookies.length > 0){
            for (int i = 0; i < cookies.length; i++){
                if (cookies[i].getName().equals("readNO"+no)){
                    cookieFlag = true;
                    break;
                }
            }
        }
        if(cookieFlag == false){
            boolean res = studyBoardPostService.addHit(no);
            if(res == false){
                mav.setViewName("errorData");
            }
            Cookie cookie = new Cookie("readNO"+no,no+"");
            cookie.setMaxAge(60*60*24);
            result.addCookie(cookie);
        }

        //boardInfo를 위한 처리
        List<CategoryVO> categoryList = studyBoardCategoryService.showList();
        mav.addObject("categoryList",categoryList);

        if(page == null){
            page = 1;
        }
        mav.addObject("curPage",page);

        int size = categoryList.size();
        for(int i = 0; i < size; i++){
            if(category.equals(categoryList.get(i).getName())){
                mav.addObject("category",categoryList.get(i));
            }
        }

        BoardVO boardVO = studyBoardShowService.showArticle(no);
        List<ReplyVO> replyList = studyReplyShowService.showReplyLIst(no);
        mav.addObject("info",boardVO);
        mav.addObject("reply",replyList);

        return mav;
    }

    @RequestMapping(value = "/coding.do")
    public String coding() {
        return "studyWrite";
    }

    @RequestMapping(value = "/postArticle.do", method = RequestMethod.POST)
    public String insertBoard(String title, String editor, Long category) {
        Map<String,Object> articleInfo = new HashMap<String, Object>();
        articleInfo.put("title", XssPreventer.escape(title));
        articleInfo.put("content",XssPreventer.escape(editor));
        articleInfo.put("category",category);

        boolean result = studyBoardPostService.postArticle(articleInfo);
        System.out.println(result);

        return "redirect:/study/coding.do";
    }

    // 다중파일업로드
    @RequestMapping(value = "/file_uploader_html5.do", method = RequestMethod.POST)
    @ResponseBody
    public String multiplePhotoUpload(HttpServletRequest request) {
        // 파일정보
        StringBuffer sb = new StringBuffer();
        try {
            // 파일명을 받는다 - 일반 원본파일명
            String oldName = request.getHeader("file-name");
            // 파일 기본경로 _ 상세경로
            String filePath = "C:/Users/chlal/IdeaProjects/comstown/web/smarteditor/photoUpload/";
//            배포 경로
//            String filePath = "/chlalstjd430/cmstown/photo/";
            String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss")
                    .format(System.currentTimeMillis()))
                    .append(UUID.randomUUID().toString())
                    .append(oldName.substring(oldName.lastIndexOf("."))).toString();
            InputStream is = request.getInputStream();
            OutputStream os = new FileOutputStream(filePath + saveName);
            int numRead;
            byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
            while ((numRead = is.read(b, 0, b.length)) != -1) {
                os.write(b, 0, numRead);
            }
            os.flush();
            os.close();

            // 정보 출력
            sb = new StringBuffer();
            sb.append("&bNewLine=true")
                    .append("&sFileName=").append(oldName)
                    .append("&sFileURL=").append("http://localhost:8080/smarteditor/photoUpload/")
                    .append(saveName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
