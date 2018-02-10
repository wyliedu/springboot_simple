package com.wylie.springboot_simple.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Interceptor - 令牌
 * 
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

     Gson                     gson = new GsonBuilder().setVersion(1.1).setPrettyPrinting().create();
    /** "令牌"参数名称 */
	private static final String TOKEN_PARAMETER_NAME = "token";
	
	/** "App标示"参数名称 */
    private static final String APP_PARAMETER_NAME = "appKey";

	/** 错误消息 */
	private static final String ERROR_MESSAGE = "User authentication failed!";

	 Logger logger = Logger.getLogger(TokenInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    
	    //暂时将checkOutSucc接口不加入token校验，等app下个版本上线之后去掉此代码
        if(request.getRequestURI().indexOf("checkoutSucc") > -1){
            return true;
        }
	    if (request.getMethod().equalsIgnoreCase("POST")) {
		    String appKey = request.getHeader(APP_PARAMETER_NAME);
		    if(appKey != null){
		    	String token ="";
		        //String token = (String) MemcachedProxyUtil.get(appKey);
		        logger.info("======APPKEY:"+appKey);
		        logger.info("======缓存服务器获取token："+token+"==========客户端传值token:"+request.getHeader(TOKEN_PARAMETER_NAME)+"===========");
		        System.out.println("======APPKEY:"+appKey);
		        System.out.println("======缓存服务器获取token："+token+"==========客户端传值token:"+request.getHeader(TOKEN_PARAMETER_NAME)+"===========");
		        if (token != null && token.equals(request.getHeader(TOKEN_PARAMETER_NAME))) {
                  return true;
                  }else {
                      //ControllerUtil.toJsonMsg(response,gson, GoodsExceptionCode.USER_AUTHENTICATION_FAILED, ERROR_MESSAGE,Constants.APP_MESSAGE_SHOW_TYPE_TOAST);
                      return false;
                  }
		    }
		}
		//ControllerUtil.toJsonMsg(response,gson, GoodsExceptionCode.USER_AUTHENTICATION_FAILED, ERROR_MESSAGE,Constants.APP_MESSAGE_SHOW_TYPE_TOAST);
        return false;
	}

}