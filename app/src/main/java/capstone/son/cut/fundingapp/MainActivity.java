package capstone.son.cut.fundingapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import capstone.son.cut.fundingapp.Adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    PagerAdapter pagerAdapter;
    ArrayList<ListVO> listVOS;
    LinearLayout linearLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.search);
        getSupportActionBar().setElevation(0f);
        dummy();
        View view=getSupportActionBar().getCustomView();
        view.findViewById(R.id.menu).setOnClickListener(this);
        view.findViewById(R.id.search).setOnClickListener(this);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),listVOS);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnClickListener(this);
        linearLayout=findViewById(R.id.fragment);

        linearLayout.setVisibility(View.GONE);
        l=findViewById(R.id.lll);
        l.bringToFront();
        l.setVisibility(View.GONE);
        linearLayout.bringToFront();

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    //public ListVO(int image,String name,long game_id,String developer, String category, String game_info, String inve_cond, String com_info, boolean success, long current_price, long goal_price){


    public void dummy(){
        listVOS=new ArrayList<>();
        for(long i=0;i<10;i++){
            ListVO listVO=new ListVO(R.drawable.image,"잡을테면 잡으시던가",i,"갓길","레이싱","잡아보시던가","투자 위험 주지 및 고지\n" +
                    "\n" +
                    "본 “위험고지서”는 자본시장과 금융투자에 관한 법률(이하 \"자본시장법\" ) 제 117조의7 제4항(온라인소액투자중개업자는 투자자가 청약의 내용, 투자에 따르는 위험, 증권의 매도 제한, 증권의 발행조건과 온라인소액증권발행인의 재무상태가 기재된 서류 및 사업계획서의 내용을 충분히 확인하였는지의 여부를 투자자의 서명 등 대통령령으로 정하는 방법으로 확인하기 전에는 그 청약의 의사 표시를 받아서는 아니 된다.)에 의하여 귀하가 \"기프트(G_I_F_T)\"에 청약의 주문을 하기 전에 투자의 위험을 사전에 충분히 인지할 수 있도록 교부하는 \"위험고지서\"입니다.\n" +
                    "1. 투자대상인 게임투자상품은 “자본시장법”에 따른 “증권”에 해당하므로 원본손실의 위험성이 있으며 투자한 자금의 원본을 회수할 수 없음에 따른 손실의 위험이 있습니다. 또한 예상하거나 기대하는 수익의 일부 또는 전부를 얻지 못할 수 있습니다.\n" +
                    "2. 귀하는 “기프트(G_I_F_T)\" 투자화면에 게재된 게임투자상…","저희회사 유령회사에요",false,0l, 10000l);
            listVOS.add(listVO);
        }

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.menu){
            Log.e("왜 안돼","왜안돼");
            getSupportActionBar().hide();
            linearLayout.setVisibility(View.VISIBLE);
            l.setVisibility(View.VISIBLE);
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment,new DrawerFragment());
            fragmentTransaction.replace(R.id.lll,new BackgroundFragment());
            fragmentTransaction.commit();
            linearLayout.setOnClickListener(this);
            l.setOnClickListener(this);


        }else{
            getSupportActionBar().setCustomView(R.layout.search);
            getSupportActionBar().show();
            getSupportActionBar().setElevation(0f);
            linearLayout.setVisibility(View.GONE);
            l.setVisibility(View.GONE );
            ImageButton menu=findViewById(R.id.menu);
            menu.setOnClickListener(this);
        }
    }
}
