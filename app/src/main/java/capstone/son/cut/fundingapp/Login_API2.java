package capstone.son.cut.fundingapp;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Login_API2 extends AppCompatActivity {
    private TextView tv_outPut;

    //TODO form에서 입력했던 사용자 정보들을 POST로 보내기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__api2);
        // 위젯에 대한 참조.
        tv_outPut = (TextView) findViewById(R.id.tv_outPut);
        findViewById(R.id.nextBtn).setOnClickListener(goMain);

        Intent prevIntent = getIntent();
        final HashMap<String, String> extra = (HashMap<String, String>) prevIntent.getSerializableExtra("data");

        DownLoadTask downLoadTask = new DownLoadTask();

        Integer[ ] arr = new Integer[3];
        downLoadTask.execute(arr);
        downLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arr);
//        try {
//            new HttpConnectionThread().execute(extra).get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // URL 설정.
        // String url = "http://192.168.0.20:8080";

        // AsyncTask를 통해 HttpURLConnection 수행.
//        NetworkTask networkTask = new NetworkTask(url, null);
//        networkTask.execute();

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

    private class DownLoadTask extends AsyncTask<Integer, Integer, String>{

        private String s;

        @Override //작업 실행전 메인쓰레드에서 호출(진행률 표지줄을 표시하는데 씀)
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            return null;
        }
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(s);
        }

        @Override
        protected  void onCancelled(String result){
            super.onCancelled(result);
        }

        @Override
        protected void onProgressUpdate(Integer ... values){
            super.onProgressUpdate();
        }


    }
}

//    public class HttpConnectionThread  extends AsyncTask<Object ,String ,String>{
//
//        @Override
//        protected String doInBackground(Object... strings) {
//            Log.i("test", "시작");
//            HashMap<String , String> extra = (HashMap<String, String>) strings[0];
//            JSONObject BODY = new JSONObject(extra);
//
//            URL url;
//            String response = null;
//            try {
//                url = new URL("http://117.17.102.139:8080/addAccount");
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setReadTimeout(10000 /* milliseconds */);
//                conn.setConnectTimeout(15000 /* milliseconds */);
//
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset ����. //character set을 utf-8로 선언
//                conn.setRequestProperty("Content-Type", "application/json");
//                conn.setDoInput(true);
//                conn.setDoOutput(true);
//                conn.connect();
//                response = conn.getResponseMessage();
//                Log.d("RESPONSE", "The response is: " + response);
//
//                OutputStream OutStream = conn.getOutputStream();
//                OutStream.write(BODY.toString().getBytes("utf-8"));//Body는 서버로보낼 스트링값등을 설정하는 것
//
//                int resCode = conn.getResponseCode(); // connect, send http reuqest, receive htttp request
//                System.out.println ("code = "+ resCode);
//
//                InputStreamReader InputStream = new InputStreamReader(conn.getInputStream(), "UTF-8");//InputStreamReader는 서버로부터 안드로이드로 받아오는 데이터 흐름을 읽어주는 클래스
//                BufferedReader Reader = new BufferedReader(InputStream);
//                StringBuilder Builder = new StringBuilder();//스트링을 만들어주는데 유용하게쓰이는 클래스
//                String ResultStr; //저장할 공간
//
//                while ((ResultStr = Reader.readLine()) != null) {//(중요)서버로부터 한줄씩 읽어서 문자가 없을때까지 넣어줌
//                    System.out.println(ResultStr);
//                    Builder.append(ResultStr + "\n"); //읽어준 스트링값을 더해준다.
//                }
//
//                Log.i("gg", Builder.toString());
//                response = Builder.toString();
//            }
//            catch (IOException e) {
//            }
//            return response;
//         }
//        @Override
//        protected void onPostExecute(String result){
//            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
//
//        }
//
//    }


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

