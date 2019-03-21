package com.local.ysf.Proxy.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		//the retunr value stands for the type of the filter---in this case, pre, or it could be route for a routing filter.
		return "pre";
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		//contains the logic that determines when to execute this filter (this particular filter will always be executed).
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		//gives the order in which this filter will be executed, relative to other filters.
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		//contains the functionality of the filter.
		 	RequestContext ctx = RequestContext.getCurrentContext();
		    HttpServletRequest request = ctx.getRequest();
		    System.out.println( "Pre filter ");
		    System.out.println("request.getMethod()  :"+request.getMethod()+"  |  request.getRequestURL().toString() : "+ request.getRequestURL().toString());
		    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return "ok";
	}

}
