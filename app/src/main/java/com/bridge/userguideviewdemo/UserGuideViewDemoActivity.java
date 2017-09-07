package com.bridge.userguideviewdemo;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhl.cbpullrefresh.CBPullRefreshListView;
import com.zhl.userguideview.UserGuideView;

public class UserGuideViewDemoActivity extends AppCompatActivity {

    private static String[] data = new String[]{"收藏","字体大小","软件设置","换肤"};

    private GridView mGridView;
    private UserGuideView userGuideView;
    private ImageView icon;
    private CBPullRefreshListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide_view_demo);

        /*初始化组件*/
        mGridView = (GridView) findViewById(R.id.girdView);
        userGuideView = (UserGuideView) findViewById(R.id.viewGuide);
        icon = (ImageView) findViewById(R.id.icon);
        mGridView.setAdapter(new MyAdapter());


        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userGuideView.setHighLightView(icon);
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        //private static String[] data = new String[]{"收藏","字体大小","软件设置","换肤"};
        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if(convertView==null){
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(UserGuideViewDemoActivity.this).inflate(R.layout.grid_item,parent,false);
                viewHolder.textView = convertView.findViewById(R.id.tx);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(data[position]);
            if(position==3){
                userGuideView.setHighLightView(convertView);
            }
            return convertView;
        }

        private class ViewHolder{
            public TextView textView;
        }
    }
}
