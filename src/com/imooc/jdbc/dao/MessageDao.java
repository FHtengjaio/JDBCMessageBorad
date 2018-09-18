package com.imooc.jdbc.dao;

import com.imooc.jdbc.bean.Message;
import com.imooc.jdbc.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {

    public List<Message> getMessage(int page, int size) {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messagelist LIMIT ?,?";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, (page - 1) * size);
            pstmt.setInt(2, size);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                messages.add(new Message(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("username"),
                        resultSet.getTimestamp("create_time")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

}
