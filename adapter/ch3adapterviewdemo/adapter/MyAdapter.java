package net.onest.ch3adapterviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.onest.ch3adapterviewdemo.R;
import net.onest.ch3adapterviewdemo.entity.Student;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private List<Student> studentList;

    public MyAdapter(Context context, int layoutId, List<Student> studentList) {
        this.context = context;
        this.layoutId = layoutId;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(layoutId, null);
        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_num = v.findViewById(R.id.tv_num);
        tv_name.setText(studentList.get(position).getName());
        tv_num.setText(studentList.get(position).getNum()+"");
        return v;
    }
}

    //上下文环境
//    private Context context;
//    //item布局
//    private int layoutId;
//    //数据源
//    private List<Student> students;
//
//    public MyAdapter(Context context, int layoutId, List<Student> students) {
//        this.context = context;
//        this.layoutId = layoutId;
//        this.students = students;
//    }
//
//
//    /**
//     * 返回数据源中元素的数量
//     * @return
//     */
//    @Override
//    public int getCount() {
//        return students.size();
//    }
//
//    /**
//     * 返回数据源中指定位置的元素
//     * @param i
//     * @return
//     */
//    @Override
//    public Object getItem(int i) {
//        return students.get(i);
//    }
//
//    //返回item的位置
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        //1. 获取到一个Item的对象
//        View v = LayoutInflater.from(context).inflate(layoutId, null);
//        //2. 把某个元素的数据对应显示在Item布局文件中的控件中
//        //2.1 获取Item布局上的控件对象
//        ImageView ivHeader = v.findViewById(R.id.iv_header);
//        TextView tvName = v.findViewById(R.id.tv_name);
//        TextView tvNo = v.findViewById(R.id.tv_no);
//        //2.2 获取当前要显示的元素对象
//        Student stu = students.get(i);
//        //2.3 把数据元素显示在对应的控件中
//        ivHeader.setImageResource(stu.getHeader());
//        tvName.setText(stu.getName());
//        tvNo.setText(stu.getNo());
//        return v;
//    }

