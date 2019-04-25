package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvModules;
    TextView tvYear;
    ArrayAdapter aa;
    TextView tvCode;
    ArrayList<Module>module;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvModules = (ListView) this.findViewById(R.id.lvModule);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvCode = (TextView)  findViewById(R.id.tvModuleCode);

        Intent i = getIntent();
        String year = i.getStringExtra("year");
        tvYear.setText(year);
        String years = tvYear.getText().toString();

        module = new ArrayList<Module>();

        if (year.equalsIgnoreCase("Year 1")) {
            module.add(new Module("C111", true));
            module.add(new Module("C112", false));
            module.add(new Module("C113", true));

        } else if (year.equalsIgnoreCase("Year 2")) {
            module.add(new Module("C208", true));
            module.add(new Module("C200", false));
            module.add(new Module("C346", false));

        } else {
            module.add(new Module("C207", true));
            module.add(new Module("C206", true));
            module.add(new Module("C343", true));

        }




        aa = new ModuleAdapter(this, R.layout.row, module);
        lvModules.setAdapter(aa);




    }



}
