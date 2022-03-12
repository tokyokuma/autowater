package com.homeapp.autowater.controller;

import com.homeapp.autowater.application.service.UserApplicationService;
import com.homeapp.autowater.domain.user.model.MUser;
import com.homeapp.autowater.domain.user.service.UserService;
import com.homeapp.autowater.form.GroupOrder;
import com.homeapp.autowater.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form){

        Map<String, Integer>genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap",genderMap);

        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale,
                             @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
                             BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            //NG:return to signup
            return getSignup(model,locale,form);
        }

        log.info(form.toString());

        // formをMUserクラスに変換
        MUser user = modelMapper.map(form, MUser.class);

        //　ユーザ登録
        userService.signup(user);
        return "redirect:/login";
    }

    /** データベース関連の例外処理 */
    @ExceptionHandler(DataAccessException.class)
    public String dataAccessExceptionHandler(DataAccessException e, Model model){

        //空文字をセット
        model.addAttribute("error", "");

        //メッセージをmodelに登録
        model.addAttribute("message", "SignupControlllerで例外が発生しました");

        //HTTPのエラーコード（500）をModelに登録
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

        return "error";
    }
    
    /** その他の例外処理 */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, Model model){

        //空文字をセット
        model.addAttribute("error", "");
    
        //メッセージをmodelに登録
        model.addAttribute("message", "SignupControlllerで例外が発生しました");
    
        //HTTPのエラーコード（500）をModelに登録
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
    
        return "error";        
    }
}
