package com.zeyden.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.squareup.picasso.Picasso;
import com.zeyden.R;
import com.zeyden.filmprod.Model;

/**
 * Created by itwenty on 7/23/14.
 */
public class ModelsView extends RelativeLayout
{
    private ImageView modelImage;
    private RobotoTextView modelName;
    private RobotoTextView modelDesc;

    public ModelsView( Context context )
    {
        this( context, null, R.attr.modelsViewStyle );
    }

    public ModelsView( Context context, AttributeSet attrs )
    {
        this( context, attrs, R.attr.modelsViewStyle );
    }

    public ModelsView( Context context, AttributeSet attrs, int defStyle )
    {
        super( context, attrs, defStyle );
        inflate( context, R.layout.models_view, this );
        modelImage = ( ImageView ) findViewById( R.id.model_image );
        modelName = ( RobotoTextView ) findViewById( R.id.model_name );
        modelDesc = ( RobotoTextView ) findViewById( R.id.model_desc );
    }

    public void updateView( Model model )
    {
        Picasso.with( getContext() )
                .load( model.getImageUrl() )
                .fit()
                .centerInside()
                .into( modelImage );
        modelName.setText( model.getName() );
        modelDesc.setText( model.getDesc() );
    }
}
