package com.example.aldrin.mycustomrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvAndroidVersions;
    int[] logo;
    String [] codename, version, api, date;
    ArrayList<AndroidVersion> list;
    CustomAdapter adapter;
    //StaggeredGridLayoutManager layoutManager;
    //GridLayoutManager layoutManager;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroidVersions = (RecyclerView) findViewById(R.id.rv_AndroidVersions);
        logo = new int[] {R.drawable.cupcake,
                R.drawable.donut,
                R.drawable.eclair,
                R.drawable.froyo,
                R.drawable.gingerbread,
                R.drawable.honeycomb,
                R.drawable.icecream, R.drawable.jellybean,
                R.drawable.kitkat,
                R.drawable.lollipop,
                R.drawable.marshmallow,
                R.drawable.nougat,
                R.drawable.oreo};

        codename = getResources().getStringArray(R.array.codename);
        version = getResources().getStringArray(R.array.version);
        api = getResources().getStringArray(R.array.api);
        date = getResources().getStringArray(R.array.date);
        list = new ArrayList<AndroidVersion>();

        //layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //layoutManager = new GridLayoutManager(this, 2);
        layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //layoutManager.setOrientation(StaggeredGridLayoutManager.HORIZONTAL);
        rvAndroidVersions.setLayoutManager(layoutManager);
        rvAndroidVersions.setHasFixedSize(true);

        for (int i = 0; i < codename.length; i++) {
            list.add(new AndroidVersion(logo[i], codename[i], version[i], api[i], date [i]));
        }

        adapter = new CustomAdapter(list);
        rvAndroidVersions.setAdapter(adapter);
    }
}
