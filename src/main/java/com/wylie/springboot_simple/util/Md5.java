package com.wylie.springboot_simple.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5 {

	public static void main(String[] args) {
		String password_md5 = new Md5Hash("a").toString();
		System.out.println("md5加密，不加盐="+password_md5);
		
		//md5加密，加盐，一次散列
		String password_md5_sale_1 = new Md5Hash("a", "a", 1).toString();
		System.out.println("password_md5_sale_1="+password_md5_sale_1);
		String password_md5_sale_2 = new Md5Hash("a", "a", 2).toString();
		System.out.println("password_md5_sale_2="+password_md5_sale_2);
		//两次散列相当于md5(md5())
	}
}
