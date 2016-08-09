package com.panes.rapidly.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.panes.rapidly.annotation.Rapidly;
import com.panes.rapidly.aspect.RapidlyAspect;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
        Log.d(RapidlyAspect.TAG, "test");
    }

    @Rapidly
    private void test() {
        Log.d(RapidlyAspect.TAG, "test test test");
    }
}
