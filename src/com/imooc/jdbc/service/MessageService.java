package com.imooc.jdbc.service;

import com.imooc.jdbc.bean.Message;
import com.imooc.jdbc.dao.MessageDao;

import java.util.List;

public class MessageService {

    private MessageDao messageDao;

    public MessageService() {
        messageDao = new MessageDao();
    }

    public List<Message> getMessage(int page, int size) {

        return messageDao.getMessage(page, size);
    }

    public int getCount() {
        return messageDao.getCount();
    }
}
