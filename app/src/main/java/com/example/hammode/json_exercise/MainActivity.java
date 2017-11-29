package com.example.hammode.json_exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MainActivity extends AppCompatActivity {
    String jsonFile, text;
    TextView mytext;
    Button count, list, modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        mytext = (TextView) findViewById(R.id.text);
        mytext.setMovementMethod(new ScrollingMovementMethod ());
        count= (Button )findViewById ( R.id.count );
        list= (Button )findViewById ( R.id.list );
        modify= (Button )findViewById ( R.id.modify );

        jsonFile= " [\n" +
                    " {\n" +
                    "   \"color\": \"black\",\n" +
                    "   \"category\" : \"hue\",\n" +
                    "   \"type\": \"primary\",\n" +
                    "   \"code\": {\n" +
                    "     \"rgba\": [255, 255, 255, 1],\n" +
                    "     \"hex\": \"#000\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "   {\n" +
                    "   \"color\": \"white\", \n" +
                    "   \"category\": \"value\", \n" +
                    "   \"code\": {\n" +
                    "   \"rgba\": [0, 0, 0, 1], \n " +
                    "   \"hex\": \"#FFF\" \n" +
                    "   }\n" +
                    "   }, \n" +
                    "   {\n" +
                    "   \"color\": \"red\", \n" +
                    "   \"category\": \"value\", \n" +
                    "   \"type\": \"primary\", \n" +
                    "   \"code\": {\n" +
                    "   \"rgba\": [255, 0, 0, 1], \n " +
                    "   \"hex\": \"#FF0\" \n" +
                    "   }\n" +
                    "   }, \n" +
                    "   {\n" +
                    "   \"color\": \"blue\", \n" +
                    "   \"category\": \"hue\", \n" +
                    "   \"type\": \"primary\", \n" +
                    "   \"code\": {\n" +
                    "   \"rgba\": [0, 0, 255, 1], \n" +
                    "   \"hex\": \"#00F\" \n" +
                    "   }\n" +
                    "   }, \n" +
                    "   {\n" +
                    "   \"color\": \"yellow\", \n" +
                    "   \"category\": \"hue\", \n" +
                    "   \"type\": \"primary\", \n" +
                    "   \"code\": {\n" +
                    "   \"rgba\": [255, 255, 0, 1], \n" +
                    "   \"hex\": \"#FF0\" \n" +
                    "   }\n" +
                    "   }, \n" +
                    "  {\n" +
                    "    \"color\": \"green\",\n" +
                    "    \"category\" : \"hue\",\n" +
                    "    \"type\": \"secondary\",\n" +
                    "    \"code\": {\n" +
                    "       \"rgba\": [0, 255, 0, 1],\n" +
                    "       \"hex\": \"#0F0\"\n" +
                    "     }\n" +
                    "   }\n" +
                    " ]" ;

        }
    public void List(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener(jsonFile).nextValue();
            for(int i=0;i<colors.length();i++) {
                JSONObject thecolor = colors.getJSONObject(i);
                JSONObject colorcode = thecolor.getJSONObject("code");
                JSONArray rgba = (JSONArray) colorcode.get("rgba");
                String X = Integer.toString(rgba.getInt(1));
                if (X.equals("255"))
                    text+=" "+(String)thecolor.get("color");
            }
            mytext.setText(text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void Modify(View view) throws JSONException
    {
        try {

            JSONArray colors = (JSONArray) new JSONTokener(jsonFile).nextValue();
            JSONObject thecolor = new JSONObject();
            thecolor.put("color", "orange");
            thecolor.put("category","hue");
            JSONObject code = new JSONObject();
            JSONArray rgba=new JSONArray();
            rgba.put(255);
            rgba.put(165);
            rgba.put(1);
            rgba.put(0);
            code.put("rgba",rgba);
            code.put("hex","#FA0");
            thecolor.put("code", code);
            colors.put(thecolor);
            mytext.setText(colors.toString(2));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void Count(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener (jsonFile).nextValue();
            int count=0;
            for(int i=0;i<colors.length();i++) {
                JSONObject thecolor = colors.getJSONObject(i);
                JSONObject colorcode = thecolor.getJSONObject("code");
                JSONArray rgba = (JSONArray) colorcode.get("rgba");
                String X = Integer.toString(rgba.getInt(1));
                if (X.equals("255"))
                    count++;
            }
            mytext.setText(Integer.toString(count));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





}
