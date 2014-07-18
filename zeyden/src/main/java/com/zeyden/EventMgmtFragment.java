package com.zeyden;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zeyden.widgets.RobotoTextView;

/**
 * Created by itwenty on 7/18/14.
 */
public class EventMgmtFragment extends Fragment
{
    public static final String TAG = EventMgmtFragment.class.getSimpleName();

    private RobotoTextView eventMgmtDesc;

    public static EventMgmtFragment newInstance()
    {
        return new EventMgmtFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_event_mgmt, container, false );
        eventMgmtDesc = ( RobotoTextView ) v.findViewById( R.id.event_mgmt_desc );
        eventMgmtDesc.setText( Html.fromHtml( getResources().getString( R.string.event_mgmt_desc ) ) );
        return v;
    }
}
