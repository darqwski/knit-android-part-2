package com.example.darqwski.secondapplication;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Darqwski on 2018-11-19.
 */

public class MainRequester extends AsyncTask<String,String,String> {


        Context context;

        MainRequester(Context newContext) {
            context = newContext;
         }

protected void onPreExecute() {

        }
public int Code;

@Override
protected String doInBackground(String... urls) {
        String urlString = urls[0]; // URL to call

        OutputStream out = null;
        try {

        URL url = new URL(urlString);

final HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("GET");
        httpCon.setConnectTimeout(2000);
        httpCon.setReadTimeout(2000);
       // httpCon.setRequestProperty("Cookie", "Content");
        OutputStream os = httpCon.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.flush();
        osw.close();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        Code = httpCon.getResponseCode();
        BufferedInputStream bis = null;
        if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK)

        bis = new BufferedInputStream(httpCon.getInputStream());
        else
        bis = new BufferedInputStream(httpCon.getErrorStream());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
        buf.write((byte) result);
        result = bis.read();
        }
        return buf.toString();

        } catch (Exception e) {


        return e.getMessage();

        }

        }

@Override
protected void onPostExecute(final String result) {
        super.onPostExecute(result);
     ArrayList<Article> list = new ArrayList<>();
    try {
        JSONObject jObject = new JSONObject(result);
        JSONArray jsonArray=jObject.getJSONArray("items");
        for(int i = 0;i<jsonArray.length();i++) {
            JSONObject actObject = new JSONObject(jsonArray.getString(i));
            list.add( new Article(actObject.getString("title")));
            Log.wtf("items",actObject.getString("title"));

        }

        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {


            }
        });
    } catch (JSONException e) {
        e.printStackTrace();
    }
    ListView listView = ((ListView)((Activity)context).findViewById(R.id.listView));
    MyAdapter adapter= new MyAdapter(context,R.layout.typical_view,list);
    listView.setAdapter(adapter);

}

        }