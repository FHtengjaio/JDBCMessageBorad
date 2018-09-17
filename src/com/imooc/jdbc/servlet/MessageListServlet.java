package com.imooc.jdbc.servlet;

import com.imooc.jdbc.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageListServlet extends HttpServlet {

    private MessageService messageService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageService();
    }
}
