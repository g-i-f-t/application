package capstone.son.cut.fundingapp;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Login_API2 extends AppCompatActivity {
    private TextView tv_outPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__api2);
        // 위젯에 대한 참조.
         tv_outPut = (TextView) findViewById(R.id.tv_outPut);

         new HttpConnectionThread();

        // URL 설정.
       // String url = "http://192.168.0.20:8080";

        // AsyncTask를 통해 HttpURLConnection 수행.
//        NetworkTask networkTask = new NetworkTask(url, null);
//        networkTask.execute();

        Intent prevIntent = getIntent();
        final HashMap<String, String> extra = (HashMap<String, String>) prevIntent.getSerializableExtra("data");
        TextView code = findViewById(R.id.code);
        TextView scope = findViewById(R.id.scope);
        TextView clientInfo = findViewById(R.id.client_info);
        TextView id = findViewById(R.id.id);
        TextView password = findViewById(R.id.password);
        TextView name = findViewById(R.id.name);
        TextView birth = findViewById(R.id.birth);
        TextView sex = findViewById(R.id.sex);
        TextView email = findViewById(R.id.email);

        code.setText(extra.get("code"));
        scope.setText(extra.get("scope"));
        clientInfo.setText(extra.get("client_info"));
        id.setText(extra.get("id"));
        password.setText(extra.get("password"));
        name.setText(extra.get("name"));
        birth.setText(extra.get("birth"));
        sex.setText(extra.get("sex"));
        email.setText(extra.get("email"));

    }

    public class HttpConnectionThread  extends AsyncTask<String ,Void ,String>{

        @Override
        protected String doInBackground(String... strings) {
            URL url;
            String response = null;
            try {
                url = new URL("http://192.168.0.20:8080");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.connect();
                response = conn.getResponseMessage();
                Log.d("RESPONSE", "The response is: " + response);

                int resCode = conn.getResponseCode(); // connect, send http reuqest, receive htttp request
                System.out.println ("code = "+ resCode);
            }
            catch (IOException e) {
            }
            return response;
         }
        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();

        }

    }


//    public class NetworkTask extends AsyncTask<Void, Void, String> {
//        private String url;
//        private ContentValues values;
//
//        public NetworkTask(String url, ContentValues values) {
//
//            this.url = url;
//            this.values = values;
//        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//            String result; // 요청 결과를 저장할 변수.
//            RequestHttpURLConnection conn = new RequestHttpURLConnection();
//
//            result = conn.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//            tv_outPut.setText(s);
//        }
//    }
}
