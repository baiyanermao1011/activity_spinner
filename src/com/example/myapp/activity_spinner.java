package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2014/12/25.
 */
public class activity_spinner extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private String[] jobs=new String[]{
            "老师","程序员","司机","CEO","城管","AA"
    };
    //一组单选框
    private RadioGroup radios;
    //自动补全输入框
    private AutoCompleteTextView qqcontextinput;
    private ArrayAdapter<String> autoCompleteAdapter;
    private List<String> list;

    @Override
    public void onCreate(Bundle savdInstanceStare){
        super.onCreate(savdInstanceStare);
        setContentView(R.layout.activity_spinner);

        spinner=(Spinner)findViewById(R.id.spinner);
        //自定义layout,以及自定义TextView id的时候使用4个参数
        spinner.setAdapter(new ArrayAdapter<String>(
                this,R.layout.item_job,R.id.txt_job_title,jobs));
        //设置Spinner 的选中事件处理程序
        spinner.setOnItemSelectedListener(this);
        Button btn=(Button)findViewById(R.id.btn_login);
        if(btn!=null){
            btn.setOnClickListener(this);
        }
        radios=(RadioGroup)findViewById(R.id.rg_it_languages);
        qqcontextinput=(AutoCompleteTextView)findViewById(R.id.qq_content_input);
        //使用Arraydapter设置数据
        list = new LinkedList<String>();
        list.add("18610206593");
        list.add("18610206594");
        list.add("18610206595");
        list.add("18610206596");
        list.add("18610206597");
        list.add("18610206598");
        //arrayadapter默认的来年各种添加数据的构造方法
        //ArrayAdapter（context，int,int）或者（context，int,int，list）
        autoCompleteAdapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        qqcontextinput.setAdapter(autoCompleteAdapter);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btn_login){
            //处理登陆请求
            int pos=spinner.getSelectedItemPosition();
            String str=jobs[pos];
            Log.d("SpinnerActivity","Selected pos content:"+str);

        }
    }
        public void baiduSearch(){
            //添加搜索记录
            //所有的TextView和EditText的标准获取字符串的方法
            String str=qqcontextinput.getText().toString();
            if(str.length()>0){
                if(list.contains(str)){

                }else {
                    autoCompleteAdapter.add(str);
                }
                autoCompleteAdapter.notifyDataSetChanged();
            }
        }
    /**
     *   Spinner的一项选中之后，调用这个方法
     *   @param adapterView 对应Spinner而言就是Spinner
     *   @view Spinner的一个条目
     *   @i 选中项目的ID
     *   @l 选中项目对象的数据id，通常是数据库中的记录ID，如果不是数据库的那么值是0
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String str=jobs[i];
        Log.d("SpinnerActivity","Selected pos content:"+str);
        if("程序员".equals(str)){
            radios.setVisibility(View.VISIBLE);
        }else{
            radios.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
