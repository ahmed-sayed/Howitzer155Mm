package com.example.android.howitzer155mm;

/**
 * Created by Ahmed Sayed on 2/13/2018.
 */

public class TextItemBlock {

    private int mHeaderResID ;
    private String mDescriptionTextFileName ;

    public TextItemBlock(int HeaderResID , String DescriptionTextFileName)
    {
        mHeaderResID=HeaderResID;
        mDescriptionTextFileName = DescriptionTextFileName ;
    }

    public int getmHeaderResID()
    {
        return  mHeaderResID ;
    }

    public  String getDescriptionTextFileName()
    {
        return mDescriptionTextFileName;
    }
}
