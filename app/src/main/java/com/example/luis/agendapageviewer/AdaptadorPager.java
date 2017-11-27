package com.example.luis.agendapageviewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by luis on 23/11/2017.
 */

public class AdaptadorPager extends FragmentPagerAdapter {
    public AdaptadorPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new FragmentoInsertar();
        }
        else
        {

            return new FragmentoListar();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
