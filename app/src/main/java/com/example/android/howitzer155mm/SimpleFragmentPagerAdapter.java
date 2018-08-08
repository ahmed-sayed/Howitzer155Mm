package com.example.android.howitzer155mm;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ahmed Sayed on 3/14/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.introduction_And_properties);
        } else if (position == 1) {
            return mContext.getString(R.string.Tanseq_Elmadfaa3);
        } else if (position == 2)

        {
            return mContext.getString(R.string.Tawgieh_Eldirector);
        } else if (position == 3) {


            return mContext.getString(R.string.Tawgieh_Elmadfaa3);
        } else if (position == 4) {
            return mContext.getString(R.string.Rabt_Qeta3);
        }
        return mContext.getString(R.string.Tawleef_Elmadfaa3);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {


        /*
         * 0 - intro
         * 1 - Tanseq_Elmadfaa3
         * 2 - Tawgieh_Eldirector
         * 3 - Tawgieh_Elmadfaa3
         * 4 - Rabt_Qeta3
         * 5 - Tawleef
         */
        if (position == 0) {
            return new introduction_And_propertiesFragment();
        }
        if (position == 1) {
            return new Tanseq_Elmadfaa3_Fragment();
        } else if (position == 2) {
            return new Tawgieh_Eldirector_Fragment();
        } else if (position == 3) {
            return new Tawgieh_Elmadfaa3_Fragment();
        } else if (position == 4) {
            return new Rabt_Qeta3_Fragment();
        } else
            return new Tawleef_Elmadfaa3_Fragment();
    }
}
