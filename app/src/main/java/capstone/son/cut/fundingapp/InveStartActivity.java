package capstone.son.cut.fundingapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class InveStartActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtn;
    Button Btn;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inve_start);
        getSupportActionBar().hide();
        initView();
    }
    public void initView(){

        imgBtn=findViewById(R.id.back);
        imgBtn.setOnClickListener(this);
        Btn=findViewById(R.id.agree);
        Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back){
            finish();
        }
        if(v.getId()==R.id.agree){
            initFragmentView();
        }
    }
    private void initFragmentView(){
        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        cl=(ConstraintLayout)inflater.inflate(R.layout.activity_inve_set,null);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        cl.findViewById(R.id.inveBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=cl.findViewById(R.id.editText);
                String gift=editText.getText().toString();
                //TO DO
                //gift 값 전달, 게임정보
            }
        });
        cl.findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewManager)cl.getParent()).removeView(cl);
            }
        });
        addContentView(cl,params);
    }

}
