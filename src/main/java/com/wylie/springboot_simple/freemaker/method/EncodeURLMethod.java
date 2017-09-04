package com.wylie.springboot_simple.freemaker.method;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;


/**
 * Convert long to date according to the given timezone
 */
@Component("encodeURL")
public class EncodeURLMethod implements TemplateMethodModelEx {

	@Override
	public Object exec(@SuppressWarnings("rawtypes") final List arguments) throws TemplateModelException {
		if (arguments.size() != 1) {
			throw new TemplateModelException("Wrong arguments");
		}

		final String code = arguments.get(0) == null ? "" : arguments.get(0).toString();
		String encodeStr = "";
		try {
			encodeStr = URLEncoder.encode(code, "UTF-8");
		}
		catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new SimpleScalar(encodeStr);
	}

}
