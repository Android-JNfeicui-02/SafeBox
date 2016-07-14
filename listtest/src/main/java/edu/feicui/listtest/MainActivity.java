package edu.feicui.listtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private List<Map<String, Object>> mList;

    private MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = getData();

        mListView = (ListView) findViewById(R.id.lv_show);
        mAdapter = new MyAdapter(getApplicationContext(),mList);

        mListView.setAdapter(mAdapter);


    }

    private List<Map<String, Object>> getData() {

        mList = new ArrayList<Map<String, Object>>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("name", "三国演义");
        dataMap.put("auther", "罗贯中");
        dataMap.put("context", "三国群雄争霸的故事。。。。。");
        mList.add(dataMap);

        dataMap = new HashMap<String, Object>();
        dataMap.put("name", "水浒传");
        dataMap.put("auther", "施耐庵");
        dataMap.put("context", "105个男人和3个女的爱情动作片");
        mList.add(dataMap);

        dataMap = new HashMap<String, Object>();
        dataMap.put("name", "西游记");
        dataMap.put("auther", "吴承恩");
        dataMap.put("context", "二个人族和三个兽族打副本升级的故事");
        mList.add(dataMap);

        dataMap = new HashMap<String, Object>();
        dataMap.put("name", "红楼梦");
        dataMap.put("auther", "曹雪芹+高鹗");
        dataMap.put("context", "四大家族衰亡史");
        mList.add(dataMap);

        return mList;
    }
}
