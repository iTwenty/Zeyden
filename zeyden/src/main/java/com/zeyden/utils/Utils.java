package com.zeyden.utils;

import android.util.DisplayMetrics;
import com.zeyden.ZeydenApp;

/**
 * Created by itwenty on 7/18/14.
 */
public class Utils
{
    private Utils()
    {
        throw new RuntimeException( "Class Utils must not be instantiated!" );
    }

    public static int convertPxToDp( int px )
    {
        DisplayMetrics displayMetrics = ZeydenApp.getApp().getResources().getDisplayMetrics();
        return ( int ) ( ( px / displayMetrics.density ) + 0.5 );
    }

    public static int convertDpToPx( int dp )
    {
        DisplayMetrics displayMetrics = ZeydenApp.getApp().getResources().getDisplayMetrics();
        return ( int ) ( ( dp * displayMetrics.density ) + 0.5 );
    }
}
