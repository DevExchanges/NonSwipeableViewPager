package info.devexchanges.disabledviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import info.devexchanges.disabledviewpager.fragment.NameEmailFragment;
import info.devexchanges.disabledviewpager.fragment.OtherInfoFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 2) {
            return new OtherInfoFragment();
        } else {
            return NameEmailFragment.getInstance(position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


}
