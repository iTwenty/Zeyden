package com.zeyden;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zeyden.widgets.RobotoTextView;

/**
 * Created by itwenty on 7/18/14.
 */
public class FilmProdFragment extends Fragment
{
    public static final String TAG = FilmProdFragment.class.getSimpleName();

    public static FilmProdFragment newInstance()
    {
        return new FilmProdFragment();
    }

    private RobotoTextView filmProdDesc;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_film_prod, container, false );
        filmProdDesc = ( RobotoTextView ) v.findViewById( R.id.film_prod_desc );
        filmProdDesc.setText( R.string.film_prod_desc );
        return v;
    }
}
