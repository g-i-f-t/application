package capstone.son.cut.fundingapp;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "roomuser")
public class RoomUser implements Serializable {
    @PrimaryKey
    private long id;
    @ColumnInfo(name = "user_id")
    private String userId;
    @ColumnInfo(name = "password")
    private String passWord;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }


}