package com.wylie.springboot_simple.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MenuController extends BasePageController{
	
    @RequestMapping("/blank.html")
    @RequiresPermissions("sys:blank")
	public String blank(Model model){
		return "blank";
	}

    @RequestMapping("/buttons.html")
    @RequiresPermissions("sys:buttons")
	public String buttons(Model model){
		return "buttons";
	}
    
    @RequestMapping("/component.html")
	public String component(Model model){
		return "blank";
	}
    
    @RequestMapping("/form-advance.html")
	public String formAdvance(Model model){
		return "form-advance";
	}
    
    @RequestMapping("/form.html")
	public String form(Model model){
		return "form";
	}
    
    @RequestMapping("/gallery.html")
	public String gallery(Model model){
		return "gallery";
	}
    
    @RequestMapping("/grid.html")
	public String grid(Model model){
		return "grid";
	}
    
    @RequestMapping("/icons.html")
	public String icons(Model model){
		return "icons";
	}
    @RequestMapping("/invoice.html")
	public String invoice(Model model){
		return "invoice";
	}
    @RequestMapping("/message-task.html")
	public String messagetask(Model model){
		return "message-task";
	}
    @RequestMapping("/notification.html")
	public String notification(Model model){
		return "notification";
	}
    @RequestMapping("/panel-tabs.html")
	public String paneltabs(Model model){
		return "panel-tabs";
	}
    @RequestMapping("/pricing.html")
	public String pricing(Model model){
		return "pricing";
	}
    @RequestMapping("/progress.html")
	public String progress(Model model){
		return "progress";
	}
    @RequestMapping("/social.html")
	public String social(Model model){
		return "social";
	}
    @RequestMapping("/table.html")
	public String table(Model model){
		return "table";
	}
    @RequestMapping("/typography.html")
	public String typography(Model model){
		return "typography";
	}
    @RequestMapping("/wizard.html")
	public String wizard(Model model){
		return "wizard";
	}
}