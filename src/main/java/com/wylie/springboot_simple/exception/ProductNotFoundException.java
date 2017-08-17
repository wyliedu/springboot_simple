/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot_simple.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Just for product
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends NotFoundException {

	/**
	 * @param msgCode
	 * @param msg
	 */
	public ProductNotFoundException(final String msgCode, final String msg) {
		super(msgCode, msg);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 4458222907120754409L;


}
