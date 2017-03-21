package com.hanbit.testapp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit.testapp.factory.Composite;
import com.hanbit.testapp.member.MemberList;

import java.util.HashMap;

public class Index extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = Index.this;
        HashMap<?,?>componentes = init(context);
        Button button= (Button) componentes.get("btnIndex");
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));
            }
        });
    }
    public HashMap<?,?>init(Context context){
        Composite compo = new Composite(context,"Index");
        compo.execute();
        setContentView(compo.getFrame());
        return compo.getComponents();
    }
}