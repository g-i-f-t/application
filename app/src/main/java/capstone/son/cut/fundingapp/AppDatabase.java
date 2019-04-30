package capstone.son.cut.fundingapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//DB테이블 생성을 해라!
//TODO User에서 entity 스키마를  해당 데이터베이스에 구축
@Database(entities = {RoomUser.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {
   public abstract RoomUserDao roomUserDao();

   private static AppDatabase instance;
   private static final Object info = new Object();

   public static AppDatabase getInstance(Context context){
       synchronized (info){
           if(instance == null){
               instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "Users.db").build();
           }
           return instance;
       }
   }
}
