package net.onest.ch02sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordsActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    private Button btnback;
    ListView listView;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        btnback = findViewById(R.id.btn_back);
        listView= findViewById(R.id.list_view);
        dbHelper = new MyDBHelper(
                this, //上下文环境
                "WordDB.db", //数据库名称
                null, //游标工程
                1);//初始版本号
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("words",
                null, null, null,
                null, null, null);
        //遍历查询结果
        StringBuffer buffer = new StringBuffer();
        int total = cursor.getCount();
        Log.i("msg", total + "条记录");
        if(total == 0){
        } else {
            while (cursor.moveToNext()) {

                String word = cursor.getString(1);

                int cIndex = cursor.getColumnIndex("translation");
                String trans = cursor.getString(cIndex);

                arrayList = new ArrayList<>();
                arrayList.add(buffer.append(word + ": " + trans + "\n").toString());

            }

            btnback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(
                            WordsActivity.this,
                            MainActivity.class
                    );
                    startActivity(intent);
                }
            });
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(WordsActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
    }
}