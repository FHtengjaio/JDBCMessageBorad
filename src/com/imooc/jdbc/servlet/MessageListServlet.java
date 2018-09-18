package com.imooc.jdbc.servlet;

import com.imooc.jdbc.bean.Message;
import com.imooc.jdbc.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageListServlet extends HttpServlet {

    private MessageService messageService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        int page = 1;
        String pageNo = request.getParameter("page");
        if (pageNo != null && "".equals(pageNo)) {
            try{
                page = Integer.parseInt(pageNo);
            } catch (Exception e){

            }
        }
        List<Message> messages = messageService.getMessage(page, 5);
        int count = messageService.getCount();
        int last = count % 5 == 0 ? count / 5 : count / 5 + 1;
        request.setAttribute("messages", messages);
        request.setAttribute("count", count);
        request.setAttribute("last", last);
        request.getRequestDispatcher("/WEB-INF/views/biz/message_list.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageService();
    }
}
