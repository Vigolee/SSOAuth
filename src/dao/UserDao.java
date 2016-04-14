package dao;

import db.DataBaseConnection;
import po.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vigo on 16/3/30.
 */
public class UserDao {

    /**
     * 通过邮箱找到用户信息
     * @param email
     * @return
     */
    public User findUserByEmail(String email) {

        DataBaseConnection dbcon = new DataBaseConnection(); // 定义数据库变量

        Connection connect = dbcon.getConnection(); // 得到数据库的连接


        String sql_find = "SELECT * FROM user where email = '"
                + email + "'";

        User user = null;
        try {
            Statement stm = connect.createStatement();
            ResultSet res = stm.executeQuery(sql_find);// 得到数据库返回的结果定义
            while (res.next()) {
                String user_name = res.getString("user_name");
                int user_id = res.getInt("user_id");
                String password = res.getString("password");
                user = new User(user_name, user_id, email, password);
            }
            stm.close();// 关闭数据库
            dbcon.close();
            return user;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

}
