package com.zeyden.eventmgmt;

import com.zeyden.R;
import com.zeyden.ZeydenApp;

import java.util.Arrays;
import java.util.List;

/**
 * Created by itwenty on 7/22/14.
 */
public final class EventMgmtUtils
{
    // The numbering here should match the numbering
    // of string-array "event_types" in strings.xml
    // or else death and destruction will ensue.

    public static final int CORPORATE        = 0;
    public static final int LIVE_CONCERT     = 1;
    public static final int WEDDING_PLANNING = 2;
    public static final int VARMALA_THEMES   = 3;
    public static final int CELEB_MGMT       = 4;
    public static final int PARTIES          = 5;
    public static final int HOSPITALITY      = 6;
    public static final int NGO_EVENT_MGMT   = 7;

    private EventMgmtUtils()
    {
        throw new RuntimeException( "Class EventMgmtUtils must not be instantiated!" );
    }

    private static final List<String> events = Arrays.asList( ZeydenApp.getApp().getResources().getStringArray( R.array.event_types ) );

    public static List<String> getEvents()
    {
        return events;
    }
}
