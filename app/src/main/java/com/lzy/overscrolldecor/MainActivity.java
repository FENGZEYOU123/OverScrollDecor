package com.lzy.overscrolldecor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strings = new ArrayList<>();
        strings.add("ScrollView");
        strings.add("ListView");
        strings.add("GridView");
        strings.add("RecyclerView");
        strings.add("WebView");
        strings.add("TextView");
        strings.add("ImageView");
        strings.add("FrameLayout");
        strings.add("LinearLayout");
        strings.add(".......等等");

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, OverScrollActivity.class);
        intent.putExtra("text", strings.get(position));
        startActivity(intent);
    }
}
