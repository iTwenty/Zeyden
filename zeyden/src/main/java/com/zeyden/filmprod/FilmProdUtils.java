package com.zeyden.filmprod;

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
    public static final int IMAGE_COUNT = 20;

    public static String getUrlForPosition( int position )
    {
        return String.format( IMAGE_URL, position );
    }
}
