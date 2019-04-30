package capstone.son.cut.fundingapp.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import capstone.son.cut.fundingapp.GameInfoVO;
import capstone.son.cut.fundingapp.R;
import capstone.son.cut.fundingapp.TempGameVO;

public class Game_info_RecyclerAdapter extends RecyclerView.Adapter<Game_info_RecyclerAdapter.ViewHolder> {

    private ArrayList<GameInfoVO> vos;
    @NonNull
    @Override
    public Game_info_RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_info_recycleritem,viewGroup,false);
        GameInfoVO vo= new GameInfoVO("게임소개",TempGameVO.getGame_info());
        vos=new ArrayList<>();
        vos.add(vo);
        vo=new GameInfoVO("투자설명서",TempGameVO.getInve_info());
        vos.add(vo);
        vo=new GameInfoVO("회사소개",TempGameVO.getCom_info());
        vos.add(vo);
        vo=new GameInfoVO(" "," ");
        vos.add(vo);
        return new Game_info_RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Game_info_RecyclerAdapter.ViewHolder viewHolder, int i) {
        GameInfoVO vo=vos.get(i);
        viewHolder.tit.setText(vo.getTitle());
        viewHolder.desc.setText(vo.getDesc());
        Log.e("뭔데",vo.getDesc());
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tit;
        public TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tit=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);

        }
    }

}