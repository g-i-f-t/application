package capstone.son.cut.fundingapp;

import android.content.Context;
import android.os.strictmode.InstanceCountViolation;
import android.util.Log;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import java.sql.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private Context context = InstrumentationRegistry.getInstrumentation().getContext();

//    @Test
//    public void get() throws ClassNotFoundException, SQLException {
//        Long id = 1l;
//        String name = "이말년";
//        String password = "1234";
//        UserDao userDao = new UserDao();
//        User user = userDao.get(id);
//        //db를 연결해서 저장한 데이터가 일치하는지 확인 (assertEquals(id user.getId())도 가능)
//        assertThat(user.getId(), is(id));
//        assertThat(user.getName(), is(name));
//        assertThat(user.getPassword(), is(password));
//    }
        @Test
        public void getRoom() {
            long id = 1L;
            String userId = "ohg429";
            String passWord = "1234";
            RoomUser u1;
            RoomUserDao roomUserDao = AppDatabase.getInstance(context).roomUserDao();

            u1 = roomUserDao.get(id);
            assertThat(u1.getId(), is(id));
            assertThat(u1.getUserId(), is(userId));
            assertThat(u1.getPassWord(), is(passWord));
//            //        AppDatabase.getInstance(context).roomUserDao().add(1);
        }
    @Test
    public void addRoom() {
        String userId = "ohg429!!";
        String passWord = "1234";
        RoomUser u1, u2;
        RoomUserDao roomUserDao = AppDatabase.getInstance(context).roomUserDao();
        u1 =  new RoomUser();
        u1.setUserId(userId);
        u1.setPassWord(passWord);
        long id = roomUserDao.add(u1);

        u2 = roomUserDao.get(id);
        assertThat(u2.getId(), is(id));
        assertThat(u2.getUserId(), is(userId));
        assertThat(u2.getPassWord(), is(passWord));
//
//        u2= roomUserDao.getId(id);
//        assertThat(u1.getId(), is(id));
//        assertThat(u1.getUserId(), is(userId));
//        assertThat(u1.getPassWord(), is(passWord));


//        AppDatabase.getInstance(context).roomUserDao().add(1);
    }

}

