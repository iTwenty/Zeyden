package com.zeyden;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.zeyden.eventmgmt.EventMgmtFragment;
import com.zeyden.filmprod.FilmProdFragment;
import com.zeyden.itsolutions.ItSolutionsFragment;
import com.zeyden.placementsvcs.PlacementSvcsFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener
{
    private DrawerLayout          navDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private FrameLayout           fragmentContainer;
    private Button                btnPlacement;
    private Button                btnItSolutions;
    private Button                btnEventMgmt;
    private Button                btnFilmProd;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );
        navDrawer = ( DrawerLayout ) findViewById( R.id.nav_drawer );
        fragmentContainer = ( FrameLayout ) findViewById( R.id.fragment_container );
        drawerToggle = new ActionBarDrawerToggle(
                this,
                navDrawer,
                R.drawable.ic_drawer,
                R.string.open_drawer,
                R.string.close_drawer );
        navDrawer.setDrawerListener( drawerToggle );
        getActionBar().setDisplayHomeAsUpEnabled( true );
        getActionBar().setHomeButtonEnabled( true );

        getSupportFragmentManager().beginTransaction()
                .add( fragmentContainer.getId(), MainFragment.newInstance(), MainFragment.TAG )
                .commit();

        btnPlacement = ( Button ) findViewById( R.id.btn_placement );
        btnItSolutions = ( Button ) findViewById( R.id.btn_it_solutions );
        btnEventMgmt = ( Button ) findViewById( R.id.btn_event_mgmt );
        btnFilmProd = ( Button ) findViewById( R.id.btn_film_prod );
        btnPlacement.setOnClickListener( this );
        btnItSolutions.setOnClickListener( this );
        btnEventMgmt.setOnClickListener( this );
        btnFilmProd.setOnClickListener( this );
    }

    @Override
    protected void onPostCreate( Bundle savedInstanceState )
    {
        super.onPostCreate( savedInstanceState );
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged( Configuration newConfig )
    {
        super.onConfigurationChanged( newConfig );
        drawerToggle.onConfigurationChanged( newConfig );
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        if ( drawerToggle.onOptionsItemSelected( item ) )
            return true;
        return super.onOptionsItemSelected( item );
    }

    @Override
    public void onClick( View v )
    {
        Fragment inFragment;
        String tag;

        if ( v.equals( btnPlacement ) )
        {
            inFragment = PlacementSvcsFragment.newInstance();
            tag = PlacementSvcsFragment.TAG;
        }
        else if ( v.equals( btnItSolutions ) )
        {
            inFragment = ItSolutionsFragment.newInstance();
            tag = ItSolutionsFragment.TAG;
        }
        else if ( v.equals( btnEventMgmt ) )
        {
            inFragment = EventMgmtFragment.newInstance();
            tag = EventMgmtFragment.TAG;
        }
        else if ( v.equals( btnFilmProd ) )
        {
            inFragment = FilmProdFragment.newInstance();
            tag = FilmProdFragment.TAG;
        }
        else
        {
            return;
        }
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations( android.R.anim.slide_in_left, android.R.anim.slide_out_right )
                .replace( fragmentContainer.getId(), inFragment, tag )
                .commit();
        navDrawer.closeDrawers();
    }
}
