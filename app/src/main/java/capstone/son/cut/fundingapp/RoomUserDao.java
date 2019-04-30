package capstone.son.cut.fundingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RoomUserDao {
//    @Query("select * from roomuser")
//    List<RoomUser> getAll();
    //primary key가 중복되는 경우 덮어씌움
    @Query("SELECT * FROM roomuser")
    List<RoomUser> getAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long add(RoomUser u1);

    @Delete
    void delete(RoomUser roomUser);

    @Update
    void update(RoomUser roomUser);

    //동기
    @Query("SELECT * FROM ROOMUSER WHERE id=:id")
    RoomUser get(long id);


//    @Query("select * from roomuser where user_id in (user_id)")
//    List<RoomUser> loadAllByIds(int[] userIds);

//    @Query("select * from roomuser where user_id in (password)")
//    List<RoomUser> findByName(String first, String last);


}
//    public User get(Long id) throws ClassNotFoundException, SQLException {
//        Connection connection = getConnection();
//        // 쿼리만들고
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
//        preparedStatement.setLong(1, id);
//        // 실행
//        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        // 결과매핑
//        User user = new User();
//        user.setId(resultSet.getLong("id"));
//        user.setName(resultSet.getString("name"));
//        user.setPassword(resultSet.getString("password"));
//
//        //자원을 해지한다.
//        resultSet.close();
//        preparedStatement.close();
//        connection.close();
//
//        return user;
//    }
//
//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        //데이터는어디에?   Mysql
//        //Driver Class Load
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // Connection    접속정보는? localhost jeju id : jeju pw: jejupw
//        return DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC", "root", "");
//    }



