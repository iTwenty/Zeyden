package com.zeyden.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
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
    private ImageView      modelImage;
    private RobotoTextView modelName;
    private RobotoTextView modelDesc;

    private int mGravity;

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
        mGravity = Gravity.LEFT;
    }

    public void updateView( Model model )
    {
        Picasso.with( getContext() )
                .load( model.getImageUrl() )
                .fit()
                .centerCrop()
                .into( modelImage );
        modelName.setText( model.getName() );
        modelDesc.setText( model.getDesc() );
    }

    public void setImageGravity( int gravity )
    {
        if ( gravity != Gravity.LEFT && gravity != Gravity.RIGHT )
        {
            throw new IllegalArgumentException( "setImageGravity only accepts values left and right." );
        }
        if ( this.mGravity == gravity )
        {
            return;
        }
        this.mGravity = gravity;
        RelativeLayout.LayoutParams modelImageParams = ( LayoutParams ) modelImage.getLayoutParams();
        RelativeLayout.LayoutParams modelNameParams = ( LayoutParams ) modelName.getLayoutParams();
        RelativeLayout.LayoutParams modelDescParams = ( LayoutParams ) modelDesc.getLayoutParams();
        if ( gravity == Gravity.RIGHT )
        {
            modelImageParams.addRule( RelativeLayout.ALIGN_PARENT_LEFT, 0 );
            modelImageParams.addRule( RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE );

            modelNameParams.addRule( RelativeLayout.RIGHT_OF, 0 );
            modelNameParams.addRule( RelativeLayout.LEFT_OF, modelImage.getId() );
            modelName.setGravity( Gravity.RIGHT );

            modelDescParams.addRule( RelativeLayout.RIGHT_OF, 0 );
            modelDescParams.addRule( RelativeLayout.LEFT_OF, modelImage.getId() );
            modelDesc.setGravity( Gravity.RIGHT );
        }
        else
        {
            modelImageParams.addRule( RelativeLayout.ALIGN_PARENT_RIGHT, 0 );
            modelImageParams.addRule( RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE );

            modelNameParams.addRule( RelativeLayout.LEFT_OF, 0 );
            modelNameParams.addRule( RelativeLayout.RIGHT_OF, modelImage.getId() );
            modelName.setGravity( Gravity.LEFT );

            modelDescParams.addRule( RelativeLayout.LEFT_OF, 0 );
            modelDescParams.addRule( RelativeLayout.RIGHT_OF, modelImage.getId() );
            modelDesc.setGravity( Gravity.LEFT );
        }
        modelImage.setLayoutParams( modelImageParams );
        modelName.setLayoutParams( modelNameParams );
        modelDesc.setLayoutParams( modelDescParams );
        requestLayout();
    }
}
