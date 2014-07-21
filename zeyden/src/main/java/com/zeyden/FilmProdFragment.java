package com.zeyden;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.zeyden.utils.FilmProdUtils;

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

    private GridView mModelsGrid;
    private ModelsGridAdapter mModelsGridAdapter;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        mModelsGridAdapter = new ModelsGridAdapter();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_film_prod, container, false );
        mModelsGrid = ( GridView ) v.findViewById( R.id.models_grid );
        mModelsGrid.setAdapter( mModelsGridAdapter );
        return v;
    }

    private class ModelsGridAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return FilmProdUtils.IMAGE_COUNT;
        }

        @Override
        public Object getItem( int position )
        {
            return FilmProdUtils.getUrlForPosition( position + 1 );
        }

        @Override
        public long getItemId( int position )
        {
            return position;
        }

        @Override
        public View getView( int position, View convertView, ViewGroup parent )
        {
            ImageView modelsGridCell;
            if ( null == convertView )
            {
                modelsGridCell = ( ImageView ) LayoutInflater.from( parent.getContext() )
                        .inflate( R.layout.models_grid_cell, parent, false );
            }
            else
            {
                modelsGridCell = ( ImageView ) convertView;
            }
            Picasso.with( parent.getContext() )
                    .load( ( String ) getItem( position ) )
                    .fit()
                    .centerCrop()
                    .into( modelsGridCell );
            return modelsGridCell;
        }
    }
}
