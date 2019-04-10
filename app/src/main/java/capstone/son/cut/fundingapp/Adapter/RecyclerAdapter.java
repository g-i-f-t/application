package capstone.son.cut.fundingapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

import capstone.son.cut.fundingapp.ListVO;
import capstone.son.cut.fundingapp.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<ListVO> listVOS;
    private int itemlayout;
    private Context context;
    private int position;
    public RecyclerAdapter(ArrayList<ListVO> listVOS, int itemlayout, Context context){
        this.listVOS=listVOS;
        this.itemlayout=itemlayout;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(itemlayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListVO listVO=listVOS.get(i);
        Glide.with(context)
                .load(listVO.getImage())
                .into(viewHolder.image);
        viewHolder.title.setText(listVO.getName());
        if(i==0){
            viewHolder.linearLayout.getLayoutParams().height=500;
            viewHolder.linearLayout.requestLayout();
        }


    }


    @Override
    public int getItemCount() {
        return listVOS.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.title);
            linearLayout=itemView.findViewById(R.id.container);
        }

    }

}