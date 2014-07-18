package com.zeyden;

import android.app.Application;

/**
 * Created by itwenty on 7/18/14.
 */
public class ZeydenApp extends Application
{
    private static ZeydenApp app;

    @Override
    public void onCreate()
    {
        super.onCreate();
        app = this;
    }

    public static ZeydenApp getApp()
    {
        return app;
    }
}
