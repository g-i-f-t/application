package capstone.son.cut.fundingapp;

import android.app.AlertDialog;
import android.content.ContentValues;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RequestHttpURLConnection {
    public String request(String _url, JSONObject _params) {

        //URLConnection 참조 변수
        HttpURLConnection urlConnection = null;
        //URL 뒤에 붙여서 보낼 파라미터
//        StringBuffer sbParams = new StringBuffer();

        /**
         * 2. HttpURLConnection을 통해 web의 데이터를 가져온다.
         * */
        try{
            URL url = new URL(_url);
            urlConnection = (HttpURLConnection) url.openConnection();

            //urlConnection 설정
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json; UTF-8");
            urlConnection.setRequestProperty("Accept-Charset","application/json");

            //파라미터 전달 및 데이터 읽어오기
            String strParams = _params.toString();
            OutputStream os = urlConnection.getOutputStream();
            os.write(strParams.getBytes("UTF-8"));
            os.flush();
            os.close();

            //연결 요청 확인
            //커넥션코드가 200이 아닐때(연결이 안되면 null 리턴 메서드 종료)
            if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK)
              return "fdsfddsadas";
            //읽어온 결과물 리턴
            //요청한 URL의 출력물을 BufferReader로 받음
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String line;
            String page = "";

            while((line = reader.readLine()) != null){
                page += line;
            }
            return page;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
