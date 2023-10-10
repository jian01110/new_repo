//package net.onest.ch3testwordprovider;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.ContentResolver;
//import android.content.ContentValues;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity2 extends AppCompatActivity {
//    private EditText edtWant, edtUpd;
//    private Button btnQuery, btnUpdate, btnDelete, btnInsert;
//    private TextView tvResult;
//    private MyClickListener listener;
//    private ContentResolver resolver;
//    //声明Uri
//    private String uriStr = "content://com.gao.provider/name";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        findViews();
//        //获取ContentResolver对象
//        resolver = this.getContentResolver();
//        //注册监听器
//        setListeners();
//    }
//    private void setListeners() {
//        listener = new MyClickListener();
//        btnInsert.setOnClickListener(listener);
//        btnQuery.setOnClickListener(listener);
//        btnUpdate.setOnClickListener(listener);
//        btnDelete.setOnClickListener(listener);
//    }
//
//    private void findViews() {
//        edtWant = findViewById(R.id.edt_want);
//        edtUpd = findViewById(R.id.edt_upd);
//        btnDelete = findViewById(R.id.btn_delete);
//        btnQuery = findViewById(R.id.btn_query);
//        btnInsert = findViewById(R.id.btn_insert);
//        btnUpdate = findViewById(R.id.btn_update);
//        tvResult = findViewById(R.id.tv_result);
//    }
//    class MyClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()){
//                case R.id.btn_insert:
//                    //插入新单词
//                    insertWord();
//                    break;
//                case R.id.btn_update:
//                    updateWord();
//                    break;
//                case R.id.btn_query:
//                    //指定查询
//                    queryWords();
//                    break;
//                case R.id.btn_delete:
//                    //删除
//                    deleteWord();
//                    break;
//            }
//        }
//    }
//    private void deleteWord() {
//        //获取单词
//        String word = edtWant.getText().toString();
//        //根据单词删除
//        resolver.delete(
//                Uri.parse(uriStr),
//                "name = '" + word + "'",
//                null
//        );
//    }
//
//    private void updateWord() {
//        String word = edtWant.getText().toString();
//        String trans = edtUpd.getText().toString();
//        //封装更新的数据
//        ContentValues values = new ContentValues();
//        values.put("address", trans);
//        //根据单词更新其中文解释
//        resolver.update(
//                Uri.parse(uriStr),
//                values,
//                "name = '" + word + "'",
//                null
//        );
//    }
//
//    @SuppressLint("Range")
//    private void queryWords() {
//        //执行查询
//        String want = edtWant.getText().toString();
//
//        Cursor cursor = resolver.query(
//                Uri.parse(uriStr),
//                null,
//                "name = '"+want+"'",
//                null,
//                null
//        );
//        //遍历结果集，在文本框中显示查询结果
//        StringBuffer buffer = new StringBuffer();
//        while(cursor.moveToNext()){
//            String name = cursor.getString(
//                    cursor.getColumnIndex("name"));
//            String phone = cursor.getString(
//                    cursor.getColumnIndex("phone"));
//            String address = cursor.getString(
//                    cursor.getColumnIndex("address"));
//            buffer.append(name + ":" + phone+address+"\n");
//        }
//        tvResult.setText(buffer.toString());
//    }
//
//    private void insertWord() {
//        //封装单词数据
//        String word = edtWant.getText().toString();
//        ContentValues values = new ContentValues();
//        values.put("name", word);
//        //执行插入操作
//        Uri uri = Uri.parse(uriStr);
//        resolver.insert(uri, values);
//    }
//}
