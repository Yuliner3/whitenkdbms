package com.wn.dbms.controller;

import com.wn.dbms.entity.User;
import com.wn.dbms.service.AccountService;
import com.wn.dbms.service.DQLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    DQLService dqlService;

    /**
     * 用户登录
     * @param request
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/userLogin")
    public String login (HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {

        User user =  accountService.accountLogin(username, password);
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "iteratorResult";
        } else {
            session.setAttribute("msg", "账号密码有误！");
            return "userLogin";
        }

    }

    /**
     * 用户注册
     * @param request
     * @param username
     * @param password
     * @param tel
     * @param email
     * @return
     */
    @GetMapping("/userRegister")
    public String register(HttpServletRequest request,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("telephone") String tel,
                           @RequestParam("email") String email,
                           @RequestParam("host") String host){
        HttpSession session = request.getSession();
        User user = new User(username,password,tel,email,host);
        // log.warn("========>{}",user.toString());
        Integer insertResult =  accountService.register(user);

        if(!insertResult.equals(0)){
            session.setAttribute("userRegister",user);
            return "iteratorResult";
        }else{
            session.setAttribute("msg","注册失败");
            return "userRegister";
        }

    }

    /**
     * 根据用户ID更新用户密码
     * @param request
     * @param id
     * @param password
     * @return
     */
    @GetMapping("/updatePwdById")
    public String update(HttpServletRequest request,
                         @RequestParam("id") String id,
                         @RequestParam("password") String password){
        HttpSession session = request.getSession();
        Integer integer = Integer.parseInt(id);
        User updateUserResult;
        Integer updateResult = accountService.updatePwdById(password,integer);
        if(!updateResult.equals(0)){
            session.setAttribute("updateMsg","更新成功");
            updateUserResult = dqlService.selectUserById(integer);
            session.setAttribute("afterUpdateUser",updateUserResult);
        }else{
            session.setAttribute("updateMsg","更新失败");
        }
        return "iteratorResult";

    }

    /**
     * 删除用户，根据用户id
     * @param request
     * @param id
     * @return
     */
    @GetMapping("/userDeleteById")
    public String delete(HttpServletRequest request,
                         @RequestParam("id") String id){
        HttpSession session = request.getSession();
        Integer integer = Integer.parseInt(id);
        Integer delResult = accountService.deleteUserById(integer);
        User deleteUserResult = dqlService.selectUserById(integer);
        if(delResult.equals(1)){
            if(deleteUserResult == null){
                session.setAttribute("deleteMsg","删除成功！");
            }else{
                session.setAttribute("deleteMsg","删除失败！");
            }
        }else{
            session.setAttribute("deleteMsg","删除失败！");
        }
        return "iteratorResult";
    }

}
