package com.zeyden.eventmgmt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zeyden.R;
import com.zeyden.widgets.RobotoTextView;

/**
 * Created by itwenty on 7/22/14.
 */
public class EventDescFragment extends Fragment
{
    private static final String TAG = EventDescFragment.class.getSimpleName();

    public static final EventDescFragment newInstance( int event )
    {
        EventDescFragment fragment = new EventDescFragment();
        Bundle b = new Bundle();
        b.putInt( "event", event );
        fragment.setArguments( b );
        return fragment;
    }

    private RobotoTextView eventTitle;
    private RobotoTextView eventDesc;
    private int event;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        event = getArguments().getInt( "event" );
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_event_desc, container, false );
        eventTitle = ( RobotoTextView ) v.findViewById( R.id.event_title );
        eventDesc = ( RobotoTextView ) v.findViewById( R.id.event_desc );
        showEventDesc();
        return v;
    }

    private void showEventDesc()
    {
        switch ( event )
        {
            case 0:
                showCorporateEventDesc(); break;
            case 1:
                showLiveConcertsDesc(); break;
            case 2:
                showWeddingPlannningDesc(); break;
            case 3:
                showVarmalaThemesDesc(); break;
            case 4:
                showCelebMgmtDesc(); break;
            case 5:
                showPartiesDesc(); break;
            case 6:
                showHospitalityDesc(); break;
            case 7:
                showNgoEventMgmtDesc(); break;
        }
    }

    private void showCorporateEventDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.CORPORATE ) );
    }

    private void showLiveConcertsDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.LIVE_CONCERT ) );
    }

    private void showWeddingPlannningDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.WEDDING_PLANNING ) );
    }

    private void showVarmalaThemesDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.VARMALA_THEMES ) );
    }

    private void showCelebMgmtDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.CELEB_MGMT ) );
    }

    private void showPartiesDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.PARTIES ) );
    }

    private void showHospitalityDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.HOSPITALITY ) );
    }

    private void showNgoEventMgmtDesc()
    {
        eventTitle.setText( EventMgmtUtils.getEvents().get( EventMgmtUtils.NGO_EVENT_MGMT ) );
    }
}
