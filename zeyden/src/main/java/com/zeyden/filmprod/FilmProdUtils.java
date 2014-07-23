package com.zeyden.filmprod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itwenty on 7/18/14.
 */
public final class FilmProdUtils
{
    private FilmProdUtils()
    {
        throw new RuntimeException( "Class FilmProdUtils must not be instantiated" );
    }

    // Url to download model images from
    private static final String IMAGE_URL = "http://click4fame.com/web/images/e%d.jpg";

    // Current total number of images available.
    // Values from 1 upto this number will be replaced in IMAGE_URL
    // to obtain the images.
    private static final int IMAGE_COUNT = 20;

    private static String getUrlForPosition( int position )
    {
        return String.format( IMAGE_URL, position );
    }

    private static final List<Model> modelsList = new ArrayList<Model>();

    static
    {
        for ( int i = 0; i < IMAGE_COUNT; ++i )
        {
            modelsList.add( new Model( getUrlForPosition( i + 1 ), "Model " + ( i + 1 ), "description" ) );
        }
    }

    public static List<Model> getModelsList()
    {
        return modelsList;
    }
}
