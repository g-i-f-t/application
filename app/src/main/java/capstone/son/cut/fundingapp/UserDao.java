package capstone.son.cut.fundingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        // 쿼리만들고
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        // 실행
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        // 결과매핑
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        //자원을 해지한다.
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        //데이터는어디에?   Mysql
        //Driver Class Load
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection    접속정보는? localhost jeju id : jeju pw: jejupw
        return DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC", "root", "");
    }
}