package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Sanuja on 7/12/2016.
 */
public class WordAdapter extends ArrayAdapter<com.example.android.miwok.Word>{
/** Resource ID for the background color of this list of words*/
    private int mColorResourceId;



    /**
     * Create a new {@link WordAdapter} object
     *
     * @param context is the current context (i.e. Activity) that the adapater is being cread in respect of
     * @param words is the list of (@link Word)s to be displayed.
     * @param colorResourceId is the Resource ID for the background of the object
     */
    public WordAdapter(Activity context, ArrayList<com.example.android.miwok.Word> words,int colorResourceId){
        //  Here, we initialize the Array Adapter's internal storage for the context and the list.
        //  the second argument is used when the ArrayAdapter is populating a single TextView
        //  Because this is a custom adapter for two TextViews (Incomplete)
        // goint to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,words);

        mColorResourceId = colorResourceId;
    }

    /** Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position  The AdapterView position that is requesting a view
     * @param convertView   The recycled view to populate
     *                      (search online for android view recycling for more info)
     * @param parent    The parent ViewGroup that is used for inflation
     * @return          The View for the position in the AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        com.example.android.miwok.Word currentWord = getItem(position);

        //  Find the TextView in the list_item.xml layout with the ID miwokTranslation
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //  Get the Miwok Translation from the current Word object and set this text on the new ListView
        miwokTextView.setText(currentWord.getMiwokTranslation());


        //  Find the TextView in the list_item.xml layout with the ID defaultTranslation
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //  Get the Default Translation from the current Word object and set this text on the new ListView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml with the ID imageResource
        ImageView imageView = (ImageView)   listItemView.findViewById((R.id.image));
        if (currentWord.hasImage()){
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResource());

            //Make sure the View is visible, because if recycled View was previously hidden it will still be hidden
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            // Otherwise hide the ImageView (set Visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme colors for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be displayed
        return listItemView;

    }
}
