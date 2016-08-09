package com.panes.rapidly.log;

import android.util.Log;

import com.panes.rapidly.aspect.RapidlyAspect;

/**
 * Created by panes on 2016/8/9.
 */
public class RapidlyLog {
    public static void log (String msg){
        Log.d(RapidlyAspect.TAG, msg);
    }
}
