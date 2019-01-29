package com.zuul.demo.firstzuuldemo.entity;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		System.out.println("Request Method :"+request.getMethod()+"Request URL :"+request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
