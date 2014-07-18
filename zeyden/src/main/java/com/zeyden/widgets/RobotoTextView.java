package com.zeyden.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by itwenty on 7/18/14.
 */
public class RobotoTextView extends TextView
{
    public RobotoTextView( Context context )
    {
        super( context );
    }

    public RobotoTextView( Context context, AttributeSet attrs )
    {
        super( context, attrs );
    }

    public RobotoTextView( Context context, AttributeSet attrs, int defStyle )
    {
        super( context, attrs, defStyle );
    }

    @Override
    public void setTypeface( Typeface tf, int style )
    {
        switch ( style )
        {
            case Typeface.BOLD:
                super.setTypeface( Typeface.createFromAsset( getContext().getAssets(), "fonts/Roboto-Bold.ttf" ) );
                break;
            case Typeface.ITALIC:
                super.setTypeface( Typeface.createFromAsset( getContext().getAssets(), "fonts/Roboto-Italic.ttf" ) );
                break;
            case Typeface.NORMAL:
            default:
                super.setTypeface( Typeface.createFromAsset( getContext().getAssets(), "fonts/Roboto-Regular.ttf" ) );
                break;
        }
    }
}
