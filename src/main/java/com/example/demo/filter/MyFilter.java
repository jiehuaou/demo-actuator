package com.example.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * custom filter : inject custom header,
 * define custom request to process header,
 */
//@Component

@WebFilter("/api/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse  myResponse= (HttpServletResponse) servletResponse;
        System.out.println("************** uri : " + httpRequest.getRequestURI());
        MyRequest myRequest = new MyRequest(httpRequest);
        myRequest.addHeader("my-data", "filter-defined");
        filterChain.doFilter(myRequest, myResponse);
    }
}
