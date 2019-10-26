package com.cmstown.controller;

import com.cmstown.model.service.board.StudyBoardCategoryService;
import com.cmstown.model.service.board.StudyBoardDeleteService;
import com.cmstown.model.service.board.StudyBoardPostService;
import com.cmstown.model.service.board.StudyBoardShowService;
import com.cmstown.model.vo.BoardVO;
import com.cmstown.model.vo.CategoryVO;
import com.cmstown.paging.Pagination;
import com.cmstown.security.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final String adminPW ="0f486fad530a777550e1d09115a8e02da8040d91e7e27760590433e0ec4a5d03";
    @Autowired
    private StudyBoardPostService studyBoardPostService;
    @Autowired
    private StudyBoardCategoryService studyBoardCategoryService;
    @Autowired
    private StudyBoardShowService studyBoardShowService;
    @Autowired
    private StudyBoardDeleteService studyBoardDeleteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin(HttpServletRequest request){
        HttpSession session = request.getSession();

        if(session.getAttribute("login") != null){
            return "admin";
        }

        return "adminLogin";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, String pw){
        String hashPW = SHA256.encryptSHA256(pw);

        if(hashPW.equals(adminPW)){
            HttpSession session = request.getSession();
            session.setAttribute("login","y");
            return "redirect:/admin";
        }

        return "adminError";
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/admin";
    }

//========= 게시판 관리
    @RequestMapping(value = "/write")
    public ModelAndView write(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studyWrite");
        List<CategoryVO> categoryList = studyBoardCategoryService.showList();
        mav.addObject("categoryList",categoryList);

        HttpSession session = request.getSession();

        if(session.getAttribute("login") == null){
            mav.setViewName("adminLogin");
        }
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    public boolean delete(HttpServletRequest request, @RequestBody Integer no){
        System.out.println(no);
        boolean result = false;
        //로그인 체크
        HttpSession session = request.getSession();
        if(session.getAttribute("login") == null){
            return result;
        }
        //삭제
        result = studyBoardDeleteService.deleteArticle(no);
        return result;
    }

    @RequestMapping(value = "/modify")
    public ModelAndView modify(HttpServletRequest request, Integer no){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studyModify");
        //로그인 체크
        HttpSession session = request.getSession();
        if(session.getAttribute("login") == null){
            mav.setViewName("admin");
        }

        List<CategoryVO> categoryList = studyBoardCategoryService.showList();
        mav.addObject("categoryList",categoryList);

        BoardVO boardVO = studyBoardShowService.showArticle(no);
        mav.addObject("info",boardVO);

        return mav;
    }

    @RequestMapping(value = "/modifyArticle.do", method = RequestMethod.POST)
    public String modifyBoard(HttpServletRequest request,
                              String title, String editor, Long category, Integer id) {
        //로그인 체크
        HttpSession session = request.getSession();
        if(session.getAttribute("login") == null){
            return "admin";
        }

        Map<String,Object> articleInfo = new HashMap<String, Object>();
        articleInfo.put("title", title);
        articleInfo.put("content",editor);
        articleInfo.put("category",category);
        articleInfo.put("id",id);

        boolean result = studyBoardPostService.updateArticle(articleInfo);
        if(result == false){
            return "redirect:/error/data";
        }

        return "redirect:/admin/board?category="+category+"&no="+id+"&page=1";
    }


    @RequestMapping(value = "/board")
    public ModelAndView board(HttpServletRequest request,Integer category, Integer page){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("adminStudy");

        //로그인 체크
        HttpSession session = request.getSession();
        if(session.getAttribute("login") == null){
            mav.setViewName("adminLogin");
        }

        //로그인 정보가 있을 시
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
}
