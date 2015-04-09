package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/26.
 */
public class Simple_Activity extends Activity implements View.OnClickListener {

    private List<Map<String, Object>> data;
    private Map<String, Object> map;
    private SimpleAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleactivity);

        data = new LinkedList<Map<String, Object>>();

        map =new HashMap<String, Object>();
        map.put("icon", R.drawable.ic_launcher);//指定图片
        map.put("jobName", "程序员");
        map.put("description", "高端大气上档次");
        map.put("rank", "第一名");
        map.put("isvip",true);

        data.add(map);
        ///////////////////////////////
        map =new HashMap<String, Object>();
        map.put("icon", R.drawable.ic_launcher);//指定图片
        map.put("jobName", "挖掘机司机");
        map.put("description", "挖掘机技术哪家强");
        map.put("rank", "第二名");
        map.put("isvip",true);
        data.add(map);
        //获取Spinner
        Spinner spinner=(Spinner)findViewById(R.id.job_new_spinner);

        adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item_super_job,
                new String[]{"icon","jobName","description","rank","isvip"},
                new int[]{R.id.job_icon,R.id.job_name,R.id.job_description,R.id.job_rank,R.id.chb_vip});
        spinner.setAdapter(adapter);

        //添加→刷新数据
        Button btn_update=(Button)findViewById(R.id.btn_update);
        if(btn_update!=null){
            btn_update.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btn_update){
            map =new HashMap<String, Object>();
            map.put("icon", R.drawable.ic_launcher);//指定图片
            map.put("jobName", "清洁工");
            map.put("description", "最美丽的天使");
            map.put("rank","第"+data.size()+1+"名" );
            map.put("isvip",true);
            data.add(map);
            //对于SimpleAdapter内部已经讲数据的变化进行了检测检查，每次点击选的的时候会自动检查数据的更新
            //因此不需要adapter.notifyDataSetChanged（）不要更新
            adapter.notifyDataSetChanged();

        }
    }
}