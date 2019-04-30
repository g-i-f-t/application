package capstone.son.cut.fundingapp.FundingList;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import capstone.son.cut.fundingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends Fragment {


    public PostListFragment() {
        // Required empty public constructor
    }

    public static PostListFragment newInstance() {
        Bundle args=new Bundle();
        PostListFragment fragment=new PostListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false);
    }

}
