package capstone.son.cut.fundingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import capstone.son.cut.fundingapp.Adapter.CircleAnimIndicator;
import capstone.son.cut.fundingapp.Adapter.Game_info_RecyclerAdapter;
import capstone.son.cut.fundingapp.Adapter.PagerAdapter;

public class GameInfoActivity extends AppCompatActivity {
    private ArrayList<ListVO> vos;
    ViewPager viewPager;
    CircleAnimIndicator circleAnimIndicator;
    ArrayList<Integer> imageList;
    ImageView imageView;
    TextView[] textViews;
    ImageButton imageButton;
    RecyclerView recyclerView;
    Button btn;

    //public ListVO(int image,String name,long game_id,String developer,
    // String category, String game_info, String inve_cond, String com_info,
    // boolean success, long current_price, long goal_price){

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        initindicator();
        initView();
    }
    //view
    private void initView(){
        getSupportActionBar().hide();
        initImageView();
        initTextView();
        initBtn();
        initRecycler();
        initFragmentView();
    }
    private void initImageView(){
        imageView=findViewById(R.id.game_image);
        Glide.with(this)
                .load(TempGameVO.getImage())
                .into(imageView);
    }
    private void initTextView(){
        //게임이름, 개발자,목표금,현재금액,게임소개,투자설명서,회사소개
        textViews=new TextView[7];
        textViews[0]=findViewById(R.id.game_name);
        textViews[0].setText(TempGameVO.getName());
        textViews[1]=findViewById(R.id.developer);
        textViews[1].setText(TempGameVO.getDeveloper());
        textViews[2]=findViewById(R.id.goal_price);
        textViews[2].setText(TempGameVO.getGoal_price()+"");
        textViews[3]=findViewById(R.id.current_price);
        textViews[3].setText(TempGameVO.getCurrent_price()+"");
    }
    private void initBtn(){
        imageButton=findViewById(R.id.back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initFragmentView(){
        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        ConstraintLayout cl=(ConstraintLayout)inflater.inflate(R.layout.invebutton,null);
        cl.setBackgroundColor(Color.parseColor("#00000000"));
        cl.findViewById(R.id.inveBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameInfoActivity.this, InveStartActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        addContentView(cl,params);
    }
    private void initRecycler(){
        recyclerView=findViewById(R.id.recyclerview);
        Game_info_RecyclerAdapter adapter=new Game_info_RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

    }


    //indicator,viewpager,imagelist
    private void initindicator(){
        initLayout();
        init();
    }
    private void initLayout(){
        viewPager=findViewById(R.id.image_viewpager);
        circleAnimIndicator=findViewById(R.id.circleindicator);
    }
    private void init(){
        initData();
        initViewPager();
    }
    private void initData(){
        imageList=new ArrayList<>();
        for(int i=0;i<6;i++){
            imageList.add(R.drawable.ic_back);
        }

    }
    private void initViewPager(){
        ViewPageAdapter viewPagerAdapter=new ViewPageAdapter(getLayoutInflater(),imageList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);
        initIndicator();
    }
    private void initIndicator(){
        //원사이의 간격
        circleAnimIndicator.setItemMargin(15);
        //애니메이션 속도
        circleAnimIndicator.setAnimDuration(300);
        //indecator 생성
        circleAnimIndicator.createDotPanel(imageList.size(), R.drawable.indicator_non , R.drawable.indicator_on);

    }
    private ViewPager.OnPageChangeListener mOnPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            circleAnimIndicator.selectDot(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
class ViewPageAdapter extends android.support.v4.view.PagerAdapter {

    LayoutInflater inflater;
    ArrayList<Integer> imageList;
    public ViewPageAdapter(LayoutInflater inflater, ArrayList<Integer> imageList){
        this.inflater=inflater;
        this.imageList=imageList;
    }
    @Override
    public int getCount() {
        return imageList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=null;
        view=inflater.inflate(R.layout.viewpager_childview,null);
        ImageView imageView=view.findViewById(R.id.img_viewpager_childimage);
        imageView.setImageResource(imageList.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
}
