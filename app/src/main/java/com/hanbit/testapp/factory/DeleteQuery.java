package com.hanbit.testapp.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hb2008 on 2017-03-15.
 */

public abstract class DeleteQuery extends QueryFactory{
    SQLiteOpenHelper helper;
    public DeleteQuery(Context context) {
        super(context);
        helper=new DatabaseHelper(context);
    }

    @Override
    public SQLiteDatabase getDatabase() {
        return helper.getWritableDatabase();
    }

    public abstract void delete(String sql);
}