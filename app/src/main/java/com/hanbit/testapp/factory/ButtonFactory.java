package com.hanbit.testapp.factory;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

import java.util.Map;

/**
 * Created by hb2007 on 2017-03-15.
 */

public class ButtonFactory {
    public static Button createButton(Context context, Map<String, String>buttonMap){
        Button button = new Button(context);
        switch (buttonMap.get("type")){
            case "basic":
                button.setText(buttonMap.get("text"));
                button.setLayoutParams(LayoutParamsFactory.createLayoutParams(buttonMap.get("layoutParams")));
                button.setBackgroundColor(Color.parseColor(buttonMap.get("color")));
                break;
        }
        return button;
    }
}
