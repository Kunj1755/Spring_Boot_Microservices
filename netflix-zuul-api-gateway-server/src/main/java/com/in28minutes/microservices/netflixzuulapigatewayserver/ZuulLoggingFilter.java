package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component  // Wants spring to manage this class
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	/*Complete logic of interception goes here*/
	public Object run() throws ZuulException {
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} requesr uri -> {}", 
				request, request.getRequestURI());
		return null;
	}

	@Override
	/* Should this filter be executed or not.
	 * You can checkout the request using business logic and
	 * decide whether you want to execute the filter or not*/
	public boolean shouldFilter() {
		return true; // execute for every request
	}

	@Override
	/* If you have more than 1 filter, for ex, ZuulLoggingFilter,
	ZuulSecurityFilter etc you can set priority among them.
	 priority filter will be 1, 2, 3 and so on*/
	public int filterOrder() {
		return 1;
	}

	@Override  
	/*This tells about when the filter should be executed.
	 * 1) Before the request (return "pre")
	 * 2) After the request (return "post")
	 * 3) Only for error (return "error")*/
	public String filterType() {
		return null;
	}

}
