package com.example.aayush.friendscircle;


import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aayush on 05-02-2017.
 */

public class BackgroundDBMS extends AsyncTask<String, Void, String> {

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        /*
          protected Map<String, String> getParams(){
            Map<String, String> params1 = new HashMap<String, String>();
            params1.put("key1", value1);
            params1.put("key2",value2);
            params1.put("key3",value3);
            return checkParams(params1);
        };


        private Map<String, String> checkParams(Map<String, String> map){
            Iterator<Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
                if(pairs.getValue()==null){
                    map.put(pairs.getKey(), "");
                }
            }
            return map;
        }
        */

        String reg_url= "http://175.25.21.200/php/login.php";
        String name= params[0];
        String phnNo=params[1];
        String email=params[3];
        String dob= params[2];
        try {
            URL url= new URL(reg_url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS= httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String data= URLEncoder.encode("name","UTF-8" ) + "=" + URLEncoder.encode(name, "UTF-8")+"&"+
                    URLEncoder.encode("phno", "UTF-8")+ "=" + URLEncoder.encode(phnNo, "UTF-8")+"&"+
                    URLEncoder.encode("DOB", "UTF-8")+ "=" + URLEncoder.encode(dob, "UTF-8")+"&"+
                    URLEncoder.encode("email", "UTF-8")+ "=" + URLEncoder.encode(email, "UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS= httpURLConnection.getInputStream();
            IS.close();
            return "REGISTRATION SUCCESS !!";

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        //ctx.getApplicationContext();
        Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
        super.onPostExecute(result);
    }

    Context ctx;

    BackgroundDBMS(Context ctx){
        this.ctx= ctx;

    }
}
