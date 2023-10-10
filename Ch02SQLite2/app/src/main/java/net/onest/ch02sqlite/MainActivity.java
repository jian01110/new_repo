package net.onest.ch02sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtWord, edtTrans,edtDelete,edtfind;
    private Button btnInsert, btnQuery,btnDelete,btnFind;
    private ListView listView;
    private MyListener listener;
    //声明数据库属性
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    private ArrayList arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件对象
        findViews();
        //注册监听器
        setListeners();

        //通过自定义的数据库管理类来管理数据库的创建以及版本更新
        initDataBaseByHelper();
    }

    private void initDataBaseByHelper() {
        //实例化数据库管理类的对象
        dbHelper = new MyDBHelper(
                this, //上下文环境
                "WordDB.db", //数据库名称
                null, //游标工程
                1);//初始版本号
        //通过数据库管理类对象获取数据库对象
        db = dbHelper.getWritableDatabase();
    }

    private void setListeners() {
        listener = new MyListener();
        btnQuery.setOnClickListener(listener);
        btnInsert.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);
        btnFind.setOnClickListener(listener);
    }

    private void findViews() {
        edtWord = findViewById(R.id.edt_word);
        edtTrans = findViewById(R.id.edt_trans);
        btnInsert = findViewById(R.id.btn_insert);
        btnQuery = findViewById(R.id.btn_query);
        btnFind =findViewById(R.id.btn_find);
        listView =findViewById(R.id.edt_list);
        edtDelete = findViewById(R.id.edt_delete);
        btnDelete = findViewById(R.id.btn_delete);
        edtfind = findViewById(R.id.edt_find);
    }

    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_insert:
                    //录入新单词
                    insertWord();
                    break;
                case R.id.btn_query:
                    //查询所有单词
                    Intent intent = new Intent();
                    intent.setClass(
                            MainActivity.this,
                            WordsActivity.class
                    );
                    startActivity(intent);
                    break;
                case R.id.btn_delete:
                    deleteWords();
                    break;
                case R.id.btn_find:
                    findWords();
                    break;
            }
        }
    }

    private void findWords() {
        String[] selectionArgs = { "%"+edtfind.getText().toString()+"%" };
        Cursor cursor = db.query("words",
                null, "word LIKE ?",selectionArgs ,
                null, null, null);
        //遍历查询结果
        StringBuffer buffer = new StringBuffer();
        int total = cursor.getCount();
        Log.i("msg", total + "条记录");
        if (total == 0) {
            arrayList.clear();
            arrayList.add("null");
        } else {
            while (cursor.moveToNext()) {

                String word = cursor.getString(1);

                int cIndex = cursor.getColumnIndex("translation");
                String trans = cursor.getString(cIndex);

                arrayList = new ArrayList<>();
                arrayList.add(buffer.append(word + ": " + trans + "\n").toString());

            }
        }
        adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

    }
    private void deleteWords() {
        db = dbHelper.getWritableDatabase();
        String whereClause = "word=?";
        String[] whereArgs = {String.valueOf(edtDelete.getText().toString())};
        db.delete("words", whereClause, whereArgs);
        edtDelete.setText("");
    }

    //录入新单词
    private void insertWord() {
        //封装新单词数据
        ContentValues cv = new ContentValues();
        cv.put("word", edtWord.getText().toString());
        cv.put("translation", edtTrans.getText().toString());
        //执行插入
        long id = db.insert("words", null, cv);
        if(id > 0){
            //插入成功，清空用户输入
            edtWord.setText("");
            edtTrans.setText("");
        }
    }
}