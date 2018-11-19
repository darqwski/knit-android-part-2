package com.example.darqwski.secondapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;
        new MainRequester(context).execute("https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.rmf24.pl%2Ffakty%2Ffeed");
    }
}
