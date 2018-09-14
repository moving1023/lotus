package org.liyl.lotus.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 李毅霖.
 * @Date 2018/9/14.
 * @description:.
 * @modified by
 */
@Component
public class CorsFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(CorsFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("正在初始化 filter");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		logger.info("正在执行filter");
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		//对于跨域的第一次请求认证跨域权限，全部返回200
		if (CorsUtils.isPreFlightRequest(request)) {
			response.setStatus(HttpStatus.OK.value());
			response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
			return;
		}
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("正在销毁filter");
	}
}
