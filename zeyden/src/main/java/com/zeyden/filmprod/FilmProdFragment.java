package com.zeyden.filmprod;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.zeyden.R;
import com.zeyden.widgets.ModelsView;

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

    private ListView          mModelsList;
    private ModelsListAdapter mModelsListAdapter;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        mModelsListAdapter = new ModelsListAdapter();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_film_prod, container, false );
        mModelsList = ( ListView ) v.findViewById( R.id.models_list );
        mModelsList.setAdapter( mModelsListAdapter );
        return v;
    }

    private class ModelsListAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return FilmProdUtils.getModelsList().size();
        }

        @Override
        public Object getItem( int position )
        {
            return FilmProdUtils.getModelsList().get( position );
        }

        @Override
        public long getItemId( int position )
        {
            return position;
        }

        @Override
        public View getView( int position, View convertView, ViewGroup parent )
        {
            ModelsView modelsView;
            if ( null == convertView )
            {
                modelsView = ( ModelsView ) LayoutInflater.from( parent.getContext() )
                        .inflate( R.layout.models_list_row, parent, false );
            }
            else
            {
                modelsView = ( ModelsView ) convertView;
            }
            modelsView.updateView( ( Model ) getItem( position ) );
            return modelsView;
        }
    }
}
