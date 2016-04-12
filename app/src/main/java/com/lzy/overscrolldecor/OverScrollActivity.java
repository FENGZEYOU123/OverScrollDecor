package com.lzy.overscrolldecor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.utils.ColorUtils;
import com.lzy.widget.OverScrollDecor;
import com.lzy.widget.tab.PagerSlidingTabStrip;
import com.lzy.widget.vertical.VerticalGridView;
import com.lzy.widget.vertical.VerticalListView;
import com.lzy.widget.vertical.VerticalRecyclerView;
import com.lzy.widget.vertical.VerticalWebView;

import java.util.ArrayList;

public class OverScrollActivity extends AppCompatActivity {

    private OverScrollDecor overScrollDecor;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_scroll);

        strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add("条目：" + i);
        }

        overScrollDecor = (OverScrollDecor) findViewById(R.id.overScrollDecor);
        initView();
    }

    private void initView() {
        String text = getIntent().getStringExtra("text");
        switch (text) {
            case "ScrollView":
                overScrollDecor.addView(View.inflate(this, R.layout.scrollview_layout, null));
                break;
            case "ListView":
                VerticalListView listView = new VerticalListView(this);
                listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings));
                overScrollDecor.addView(listView);
                break;
            case "GridView":
                VerticalGridView gridView = new VerticalGridView(this);
                gridView.setNumColumns(2);
                gridView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings));
                overScrollDecor.addView(gridView);
                break;
            case "RecyclerView":
                VerticalRecyclerView recyclerView = new VerticalRecyclerView(this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new MyAdapter());
                overScrollDecor.addView(recyclerView);
                break;
            case "ViewPager":
                View viewpagerRoot = View.inflate(this, R.layout.include_viewpager, null);
                ViewPager viewPager = (ViewPager) viewpagerRoot.findViewById(R.id.viewPager);
                PagerSlidingTabStrip tab = (PagerSlidingTabStrip) viewpagerRoot.findViewById(R.id.tab);
                viewPager.setAdapter(new MyPagerAdapter());
                tab.setViewPager(viewPager);
                overScrollDecor.addView(viewpagerRoot);
                break;
            case "WebView":
                VerticalWebView webView = new VerticalWebView(this);
                webView.loadUrl("https://github.com/jeasonlzy0216");
                overScrollDecor.addView(webView);
                break;
            case "TextView":
                TextView textView = new TextView(this);
                textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
                textView.setTextColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);
                textView.setText("textView");
                textView.setBackgroundColor(ColorUtils.randomColor());
                overScrollDecor.addView(textView);
                break;
            case "ImageView":
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
                imageView.setImageResource(R.mipmap.ic_launcher);
                imageView.setBackgroundColor(ColorUtils.randomColor());
                overScrollDecor.addView(imageView);
                break;
            case "FrameLayout":
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setBackgroundColor(ColorUtils.randomColor());
                overScrollDecor.addView(frameLayout);
                break;
            case "LinearLayout":
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setBackgroundColor(ColorUtils.randomColor());
                overScrollDecor.addView(linearLayout);
                break;
            default:
                TextView other = new TextView(this);
                other.setGravity(Gravity.CENTER);
                other.setText("任意View和ViewGroup都可以");
                overScrollDecor.addView(other);
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        private ArrayList<String> titles;

        public MyPagerAdapter() {
            titles = new ArrayList<>();
            titles.add("第一页");
            titles.add("第二页");
            titles.add("第三页");
            titles.add("第四页");
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(getApplicationContext());
            textView.setText(titles.get(position));
            textView.setTextSize(20);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(ColorUtils.randomColor());
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.SimpleViewHolder> {

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SimpleViewHolder(View.inflate(OverScrollActivity.this, android.R.layout.simple_list_item_1, null));
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        protected class SimpleViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public SimpleViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }

            public void bindData(int position) {
                textView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
                textView.setText(strings.get(position));
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(ColorUtils.randomColor());
            }
        }
    }
}
