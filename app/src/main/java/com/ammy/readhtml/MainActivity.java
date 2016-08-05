package com.ammy.readhtml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Document doc = null;
                try {
                    doc = Jsoup.connect("https://play.google.com/store/apps/details?id=air.com.ls.gamentio").get();
                    Elements cssElements = doc.select(".meta-info .content");
                    Element ele = cssElements.get(3);

                    Elements text = ele.select("div");
                    String versionNumber = text.text();

                    Log.i("App version:- ",versionNumber);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
