package capstone.son.cut.fundingapp;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Login_API2 extends AppCompatActivity {
    private TextView tv_outPut;

    //TODO form에서 입력했던 사용자 정보들을 Room에 저장하고 서버에 POST로   보내기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__api2);
        // 위젯에 대한 참조.
        tv_outPut = (TextView) findViewById(R.id.tv_outPut);

        findViewById(R.id.nextBtn).setOnClickListener(goMain);
        //URL 설정
        String url = "http://cybertec.jejunu.ac.kr";

        NetWorkTask netWorkTask = new NetWorkTask(url, null);
        netWorkTask.execute();

        Intent prevIntent = getIntent();
        final HashMap<String, String> extra = (HashMap<String, String>) prevIntent.getSerializableExtra("data");

        TextView authCode = findViewById(R.id.code);
        TextView scope = findViewById(R.id.scope);
        TextView clientInfo = findViewById(R.id.client_info);
        TextView id = findViewById(R.id.id);
        TextView password = findViewById(R.id.password);
        TextView name = findViewById(R.id.name);
        TextView birthgender = findViewById(R.id.birth);
        TextView sex = findViewById(R.id.sex);
        TextView email = findViewById(R.id.email);

        authCode.setText(extra.get("code"));
        scope.setText(extra.get("scope"));
        clientInfo.setText(extra.get("client_info"));
        id.setText(extra.get("id"));
        password.setText(extra.get("password"));
        name.setText(extra.get("name"));
        birthgender.setText(extra.get("birthgender"));
        sex.setText(extra.get("sex"));
        email.setText(extra.get("email"));

    }

    Button.OnClickListener goMain = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Login_API2.this, MainActivity.class);
            startActivity(intent);
        }
    };

     public class NetWorkTask extends AsyncTask<Void, Void, String> {
         private String url;
         private ContentValues values;

        public NetWorkTask(String url, ContentValues values) {
             this.url = url;
             this.values = values;
         }

         @Override
         protected void onPreExecute(){
            super.onPreExecute();
         }

         //execute한 후에 백그라운드 쓰레드에서 호출됨
         @Override
         protected String doInBackground(Void... params) {
             String result;
             RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
             result = requestHttpURLConnection.request(url, values);

             return result;
         }

         @Override
         protected void onPostExecute(String s){
            super.onPostExecute(s);

            tv_outPut.setText(s);
         }

         @Override
         protected void onCancelled(String result){
            super.onCancelled();
         }

         @Override
         protected void onProgressUpdate(Void... params){
            super.onProgressUpdate(params);
         }
    }
}


