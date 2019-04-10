package capstone.son.cut.fundingapp.FundingList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import capstone.son.cut.fundingapp.Adapter.RecyclerAdapter;
import capstone.son.cut.fundingapp.ListVO;
import capstone.son.cut.fundingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreListFragment extends Fragment {


    private static ArrayList<ListVO> listVOS;
    private static int integer;
    public PreListFragment() {
        // Required empty public constructor
    }

    public static PreListFragment newInstance(ArrayList<ListVO> listVO) {
        Bundle args=new Bundle();
        PreListFragment fragment=new PreListFragment();
        fragment.setArguments(args);
        listVOS=listVO;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pre_list, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        RecyclerAdapter adapter=new RecyclerAdapter(listVOS,R.layout.item_view,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        return view;
    }

}
