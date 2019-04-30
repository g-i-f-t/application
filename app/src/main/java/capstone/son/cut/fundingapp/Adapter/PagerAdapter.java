package capstone.son.cut.fundingapp.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import capstone.son.cut.fundingapp.FundingList.PostListFragment;
import capstone.son.cut.fundingapp.FundingList.PreListFragment;
import capstone.son.cut.fundingapp.ListVO;

public class PagerAdapter extends FragmentPagerAdapter {
    private static int PAGE_NUMBER=2;
    private static ArrayList<ListVO> listVOS;
    private static int integer;
    public PagerAdapter(FragmentManager fm, ArrayList<ListVO> listVO) {
        super(fm);
        listVOS=listVO;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return PreListFragment.newInstance(listVOS);
            case 1:
                return PostListFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "진행중";
            case 1:
                return "진행완료";
            default:
                return null;
        }
    }
}
