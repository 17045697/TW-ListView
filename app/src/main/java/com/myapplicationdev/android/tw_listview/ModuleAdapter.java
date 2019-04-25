package com.myapplicationdev.android.tw_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> module;
    private Context context;
    private TextView tvModuleCode;
    private ImageView ivProg;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);

        module = objects;

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvModuleCode =         rowView.findViewById(R.id.tvModuleCode);
        // Get the ImageView object
        ivProg =             rowView.findViewById(R.id.ivProg);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Module currentModule = module.get(position);
        // Set the TextView to show the food

        tvModuleCode.setText(currentModule.getModuleCode());
        // Set the image to star or nostar accordingly
        if(currentModule.isProg()) {
            ivProg.setImageResource(R.drawable.prog);
        }
        else {
            ivProg.setImageResource(R.drawable.nonprog);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }



}
