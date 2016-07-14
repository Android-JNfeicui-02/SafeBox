package edu.feicui.listtest;

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
public class MyAdapter extends BaseAdapter {

    List<Map<String, Object>> mList;
    private Context mContext;


    public MyAdapter(Context context, List<Map<String, Object>> list) {
        mContext = context;
        mList = list;
    }

    /**
     * 拿到数据源的数量
     *
     * @return
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * 拿到数据源具体的对象
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    /**
     * 拿到对象的id
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 返回对象具体的样式
     *
     * @param position    具体的item的对应的id
     * @param convertView 可复用的View对象， 指的是 对应 Item
     * @param parent      父布局 一般为null
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String, Object> map = mList.get(position);

        // 复用convertView  ListView --> item
        if (convertView == null) {
            // LayoutInflater 用来填充item的长相
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_show, null);
        }
        ImageView img_name = (ImageView) convertView.findViewById(R.id.img_name);
        TextView txt_name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView auther = (TextView) convertView.findViewById(R.id.author);
        TextView txt_context = (TextView) convertView.findViewById(R.id.txt_context);
// 给对象赋值
        img_name.setImageResource(R.mipmap.ic_launcher);
        txt_name.setText((String) map.get("name"));
        auther.setText((String) map.get("auther"));
        txt_context.setText((String) map.get("context"));

        return convertView;
    }
}
