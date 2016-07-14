package edu.feicui.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/7/14.
 */
public class MyListAdapter extends BaseAdapter {

    List<Map<String, Object>> mList;

    private Context mContext;

    public MyListAdapter(Context context,List<Map<String, Object>> list) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String, Object> map = mList.get(position);

        // 使用inflater来填充item布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.acitivity_main_item, null);

        // 使用View对象里的findViewById 找到 item 里面的控件
        ImageView img_name = (ImageView) view.findViewById(R.id.img_name);
        TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
        TextView auther = (TextView) view.findViewById(R.id.author);
        TextView txt_context = (TextView) view.findViewById(R.id.txt_context);

        // 给对象赋值
        img_name.setImageResource(R.drawable.icon_rocket);
        txt_name.setText((String) map.get("name"));
        auther.setText((String) map.get("auther"));
        txt_context.setText((String) map.get("context"));
        return view;
    }
}
/**
    private BaseAdapter ba = new BaseAdapter() {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Map<String, Object> map = list.get(position);
            View view;
            view = mInflater.inflate(R.layout.acitivity_main_item, null);

            //LayoutInflater lf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //View view = lf.inflate(R.layout.acitivity_main_item,null);
            ImageView img_name = (ImageView) view.findViewById(R.id.img_name);
            TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
            TextView auther = (TextView) view.findViewById(R.id.author);
            TextView txt_context = (TextView) view.findViewById(R.id.txt_context);

            img_name.setImageResource(R.drawable.icon_rocket);
            txt_name.setText((String) map.get("name"));
            auther.setText((String) map.get("auther"));
            txt_context.setText((String) map.get("context"));

            return view;
        }
    };
**/