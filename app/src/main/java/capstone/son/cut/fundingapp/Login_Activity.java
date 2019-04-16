package capstone.son.cut.fundingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {

    EditText et_id, et_pw, et_pw_chk, et_name, et_birth, et_sex, et_email ;
    String Id, Pw, Pw_chk,name, birth, sex, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = (EditText) findViewById(R.id.etId);
        et_pw = (EditText) findViewById(R.id.etPassword);
        et_pw_chk = (EditText) findViewById(R.id.etPasswordchk);
        et_name = (EditText) findViewById(R.id.etName);
        et_birth = (EditText) findViewById(R.id.etBirth);
        et_sex = (EditText) findViewById(R.id.etSex);
        et_email = (EditText) findViewById(R.id.etEmail);
    }

    /* onClick에서 정의한 이름과 똑같은 이름으로 생성 */
    public void bt_Join(View view) {
        /* 버튼을 눌렀을 때 동작하는 소스 */
        name = et_name.getText().toString();
        birth = et_birth.getText().toString();
        sex = et_sex.getText().toString();
        email = et_email.getText().toString();

        Id = et_id.getText().toString();
        Pw = et_pw.getText().toString();
        Pw_chk = et_pw_chk.getText().toString();

        if(Pw.equals(Pw_chk))
        {
            /* 패스워드 확인이 정상적으로 됨 */
            HashMap<String, String> extra = new HashMap<>();
            extra.put("name", name);
            extra.put("birth", birth);
            extra.put("sex", sex);
            extra.put("email",email);
            extra.put("id",Id);
            extra.put("password", Pw);

            Intent intent=new Intent(Login_Activity.this,Login_API2.class);
            intent.putExtra("data", extra);
            startActivity(intent);

        }
        else
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(Login_Activity.this);
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();     //닫기
                }
            });
            alert.setMessage("비번확인좀");
            alert.show();

        }
    }




}
