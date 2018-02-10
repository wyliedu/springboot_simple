package com.wylie.springboot_simple.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wylie.springboot_simple.services.UserService;

@Controller
public class IndexController extends BasePageController{
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)  
    public String logout(RedirectAttributes redirectAttributes ){ 
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();  
        redirectAttributes.addFlashAttribute("message", "您已安全退出");  
        return "redirect:/login";
    } 
	
    @RequestMapping("/login")
	public String login(Model model) throws InterruptedException {
    	model.addAttribute("greeting", "login");
		return "login";
	}
	
    @RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,Map<String, Object> map, Model model) throws InterruptedException {
    	String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
               System.out.println("UnknownAccountException -- > 账号不存在：");
               msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
               System.out.println("IncorrectCredentialsException -- > 密码不正确：");
               msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
               System.out.println("kaptchaValidateFailed -- > 验证码错误");
               msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
               msg = "else >> "+exception;
               System.out.println("else -- >" + exception);
            }
        }
        map.put("greeting", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
	}
    
    @RequestMapping("/")
	public String hel(Locale locale, Model model) throws InterruptedException {
		return "index";
	}
    
    @RequestMapping("/index")
	public String hello(Locale locale, Model model) throws InterruptedException {
		return "index";
	}

    @RequestMapping("/changelanguage/{lang}")
    public String changeSessionLanauage(HttpServletRequest request,HttpServletResponse response,@PathVariable String lang){
              System.out.println(lang);
       LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
       if("zh".equals(lang)){
           localeResolver.setLocale(request, response, new Locale("zh", "CN"));
       }else if("en".equals(lang)){
           localeResolver.setLocale(request, response, new Locale("en", "US"));
       }
       return "redirect:/hi";
    }
}