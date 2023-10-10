package net.onest.ch02sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //只有第一次使用时才会自动调用该方法
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //一般执行一次性操作的逻辑，如数据库表的创建
        String table = "create table address(" +
                "phone int default 0," +
                "name varchar(30) ," +
                "address varchar(100) default null)";
        sqLiteDatabase.execSQL(table);
    }

    //当数据库版本有更新时自动回调
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
