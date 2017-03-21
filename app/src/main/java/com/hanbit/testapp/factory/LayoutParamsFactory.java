package com.hanbit.testapp.factory;

import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by hb2007 on 2017-03-15.
 */

public class LayoutParamsFactory {
    public static LinearLayout.LayoutParams createLayoutParams(String flag) { /*안에 이너 클래스 접근*/
        LinearLayout.LayoutParams rs = null;
        switch (flag) {
            case "mm":
                rs = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                break;
            case "mw":
                rs = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                break;
            case "ww":
                rs = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                break;
            case "wm":
                rs = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
                break;
        }
        return rs;
    }
}
