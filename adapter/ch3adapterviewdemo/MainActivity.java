package net.onest.ch3adapterviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import net.onest.ch3adapterviewdemo.adapter.MyAdapter;
import net.onest.ch3adapterviewdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private List<Student> students;
//    private ListView lvStudent;
//    private MyAdapter myAdapter;
    private List<Student> studentList;
    private GridView gridView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gv_student);
        studentList = new ArrayList<>();
        Student zs = new Student(
                "张三",
                123456
        );
        Student ls = new Student(
                "李四",
                12345678
        );
        studentList.add(zs);
        studentList.add(ls);
        myAdapter = new MyAdapter(
                this,
                R.layout.activity_main_item,
                studentList
        );
        gridView.setAdapter(myAdapter);
    }
}









        //获取界面上的控件

//            lvStudent = findViewById(R.id.lv_student);
//
//        //准备数据源
//        initDate();
//        //实例化MyAdapter的对象
//         myAdapter = new MyAdapter(
//                this,
//                R.layout.activity_main_item,
//                students
//        );
//        //给显示学生数据的ListView绑定适配器
//        lvStudent.setAdapter(myAdapter);
//        //注册监听器
//        setListener();
//    }
//
//    private void initDate() {
//        //初始化学生数据源
//        students = new ArrayList<>();
//        Student zs = new Student(
//                R.mipmap.xx,
//                "张三",
//                "2021001001"
//        );
//        //添加到列表中
//        students.add(zs);
//        Student ls = new Student(
//                R.mipmap.li,
//                "李四",
//                "2021001002"
//        );
//        //添加到列表中
//        students.add(ls);
//        Student ww = new Student(
//                R.mipmap.cat,
//                "王五",
//                "2021001003"
//        );
//        //添加到列表中
//        students.add(ww);
//    }
//
//    private void setListener() {
//        //给显示学生信息的ListView注册Item点击事件监听器
//        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //日志记录当前点击的学生对象信息
//                Log.i("MainActivity", students.get(i).toString());
//            }
//        });
