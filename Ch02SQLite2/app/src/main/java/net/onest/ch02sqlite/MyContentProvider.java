package net.onest.ch02sqlite;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    private UriMatcher matcher;
    private final String WORD_AUTHORITY = "com.gao.provider";
    private final String TABLE_NAME = "address";

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int n = 0;
        //判断uri类型
        switch (matcher.match(uri)){
            case 1:
                //执行删除
                n = db.delete(TABLE_NAME,
                        selection,
                        selectionArgs);
                break;
            case 2:
                //获取uri中的id
                long id = ContentUris.parseId(uri);
                //判断id合法性
                if(id > 0) {
                    //构造where子句
                    String where = "id = " + id;
                    //拼接where条件
                    selection = where + " and " + selection;
                    //执行更新
                    n = db.delete(TABLE_NAME,
                            selection,
                            selectionArgs);
                }
                break;
            default:
                throw new UnsupportedOperationException("非法的Uri");
        }
        return n;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri uri1 = null;

        switch (matcher.match(uri)){
            case 1:
                long rowId = db.insert(TABLE_NAME,
                        null,
                        values);
                uri1 = ContentUris.withAppendedId(uri, rowId);
                break;
            default:
                throw new UnsupportedOperationException("非法的Uri");
        }
        return uri1;
    }

    @Override
    public boolean onCreate() {
        dbHelper = new MyDBHelper(
                this.getContext(),
                "AddressDB.db",
                null,
                1
        );
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(
                WORD_AUTHORITY,
                "name",
                1);
        matcher.addURI(
                WORD_AUTHORITY,
                "name/#",
                2);
        db = dbHelper.getWritableDatabase();
        return true;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        switch (matcher.match(uri)) {
            case 1:
                cursor = db.query(TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case 2:
                //获取uri末尾的id
                long id = ContentUris.parseId(uri);
                //判断id是否合法
                if(id >0) {
                    //构造where子句
                    String where = "name = " + id;
                    //拼接where条件
                    selection = where;
                    System.out.println("selection:"+selection);
                    //执行查询
                    cursor = db.query(TABLE_NAME,
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOrder);
                }
                break;


            default:
                throw new UnsupportedOperationException("非法的Uri");
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int n = 0;
        //判断uri类型
        switch (matcher.match(uri)){
            case 1:
                //执行更新
                n = db.update(TABLE_NAME,
                        values,
                        selection,
                        selectionArgs);
                break;
            case 2:
                //获取uri中的id
                long id = ContentUris.parseId(uri);
                //判断id合法性
                if(id > 0) {
                    //构造where子句
                    String where = "id = " + id;
                    //拼接where条件
                    selection = where + " and " + selection;
                    //执行更新
                    n = db.update(TABLE_NAME,
                            values,
                            selection,
                            selectionArgs);
                }
                break;
            default:
                throw new UnsupportedOperationException("非法的Uri");
        }
        return n;
    }
}