package capstone.son.cut.fundingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import capstone.son.cut.fundingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackgroundFragment extends Fragment {


    public BackgroundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_background, container, false);
    }

}
