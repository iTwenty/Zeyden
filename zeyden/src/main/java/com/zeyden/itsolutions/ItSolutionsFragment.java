package com.zeyden.itsolutions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zeyden.R;
import com.zeyden.widgets.RobotoTextView;

/**
 * Created by itwenty on 7/16/14.
 */
public class ItSolutionsFragment extends Fragment
{
    public static final String TAG = ItSolutionsFragment.class.getSimpleName();

    public static ItSolutionsFragment newInstance()
    {
        return new ItSolutionsFragment();
    }

    private RobotoTextView itSolutionsDesc;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_it_solutions, container, false );
        itSolutionsDesc = ( RobotoTextView ) v.findViewById( R.id.it_solutions_desc );
        itSolutionsDesc.setText( Html.fromHtml( getResources().getString( R.string.it_solutions_desc ) ) );
        return v;
    }
}
