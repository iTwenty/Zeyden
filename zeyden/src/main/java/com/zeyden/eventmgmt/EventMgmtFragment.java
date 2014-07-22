package com.zeyden.eventmgmt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zeyden.R;
import com.zeyden.widgets.RobotoTextView;

/**
 * Created by itwenty on 7/18/14.
 */
public class EventMgmtFragment extends Fragment
{
    public static final String TAG = EventMgmtFragment.class.getSimpleName();

    public static EventMgmtFragment newInstance()
    {
        return new EventMgmtFragment();
    }

    private EventMgmtPagerAdapter eventMgmtPagerAdapter;
    private ViewPager eventMgmtPager;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        eventMgmtPagerAdapter = new EventMgmtPagerAdapter( getChildFragmentManager() );
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_event_mgmt, container, false );
        eventMgmtPager = ( ViewPager ) v.findViewById( R.id.event_mgmt_pager );
        eventMgmtPager.setAdapter( eventMgmtPagerAdapter );
        return v;
    }

    private class EventMgmtPagerAdapter extends FragmentPagerAdapter
    {
        public EventMgmtPagerAdapter( FragmentManager fm )
        {
            super( fm );
        }

        @Override
        public Fragment getItem( int position )
        {
            return EventDescFragment.newInstance( position );
        }

        @Override
        public int getCount()
        {
            return EventMgmtUtils.getEvents().size();
        }

        @Override
        public CharSequence getPageTitle( int position )
        {
            return EventMgmtUtils.getEvents().get( position );
        }
    }
}
