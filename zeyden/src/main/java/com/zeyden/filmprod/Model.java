package com.zeyden.filmprod;

/**
 * Created by itwenty on 7/23/14.
 */
public class Model
{
    String imageUrl;
    String name;
    String desc;

    public Model( String imageUrl, String name, String desc )
    {
        this.imageUrl = imageUrl;
        this.name = name;
        this.desc = desc;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl( String imageUrl )
    {
        this.imageUrl = imageUrl;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc( String desc )
    {
        this.desc = desc;
    }
}
