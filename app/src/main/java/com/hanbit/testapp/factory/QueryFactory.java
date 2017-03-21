package com.hanbit.testapp.factory;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hb2008 on 2017-03-15.
 */

public abstract class QueryFactory {
    Context context;
    public QueryFactory(Context context){
        this.context=context;
    }
    public abstract SQLiteDatabase getDatabase();

}