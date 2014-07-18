package com.zeyden;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zeyden.widgets.RobotoTextView;

/**
 * Created by itwenty on 7/16/14.
 */
public class PlacementServicesFragment extends Fragment
{
    public static final String TAG = PlacementServicesFragment.class.getSimpleName();

    private RobotoTextView placementServicesDesc;

    public static PlacementServicesFragment newInstance()
    {
        return new PlacementServicesFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_placement_services, container, false );
        placementServicesDesc = ( RobotoTextView ) v.findViewById( R.id.placement_services_desc );
        placementServicesDesc.setText( Html.fromHtml( getResources().getString( R.string.placement_services_desc ) ) );
        return v;
    }
}
