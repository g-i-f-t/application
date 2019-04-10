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


    public void dummy(){
        listVOS=new ArrayList<>();
        for(int i=0;i<10;i++){
            ListVO listVO=new ListVO(R.drawable.image,"잡을테면 잡으시던가");
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
