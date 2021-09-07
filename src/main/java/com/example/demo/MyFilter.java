package com.example.demo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse  myResponse= (HttpServletResponse) servletResponse;
        MyRequest myReq = new MyRequest(httpRequest);
        myReq.addHeader("my-data", "oracle");
        filterChain.doFilter(myReq, myResponse);
    }
}
