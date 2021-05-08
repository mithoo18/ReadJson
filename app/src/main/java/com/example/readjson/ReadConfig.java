package com.example.readjson;
import android.content.Context;
import org.json.JSONObject;
import java.io.InputStream;
import org.json.JSONException;
import java.io.IOException;

public class ReadConfig {
    public JSONObject loadJSONFromAsset(Context context,String filename){
        String json = null;
        JSONObject jsonObject = null;
        try {

            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        try{
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
