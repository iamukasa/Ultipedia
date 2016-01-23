package com.amusoft.ultipedia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:

                return new Fun();
            case 1:

                return new Mathematics();
            case 2:

                return new English();
            case 3:

                return new Kiswahili();
            case 4:

                return new Science();
            case 5:

                return new SocialStudies();
            case 6:

                return new ChristianReligious();




        }
        return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 7; //No of Tabs
    }
}
