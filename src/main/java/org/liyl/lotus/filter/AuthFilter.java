package org.liyl.lotus.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 李毅霖.
 * @Date 2018/9/14.
 * @description:.
 * @modified by
 */

@Component
public class AuthFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		//通过这里来简单做权限控制
	}

	@Override
	public void destroy() {

	}
}
