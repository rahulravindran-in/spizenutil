package com.spizenstudio.master;

/**
 * Created by rahul on 08-10-2017.
 * From company : Spizen
 */

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.spizenstudio.master.exceptions.ArraylistsSizesMismatchException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by rahul on 8/28/2016.
 */
public class Spimod {

    public static String getSourceCodeOfWebsite(String urlget) {
        String fetched_data = "";
        try {
            URL url = null;
            url = new URL(urlget);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            StringBuilder response = new StringBuilder(50000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            int i = 0;
            while ((i = rd.read()) > 0) {
                response.append((char) i);
            }
            fetched_data = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fetched_data;
    }

    public static ArrayList regularExpression(String PatternBegginingEndAndRegex, String PatternSource) {

        ArrayList<String> ArraylistToAdd = new ArrayList<>();

        Pattern p = Pattern.compile(PatternBegginingEndAndRegex);
        Matcher m = p.matcher(PatternSource);

        while (m.find()) {

            ArraylistToAdd.add(m.group(1));

        }
        return ArraylistToAdd;
    }

    public static ArrayList<HashMap<String, String>> hashmapitx(ArrayList<String> array, String arrayname) {

        ArrayList<HashMap<String, String>> Array_Collection = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            HashMap<String, String> HM_COLLECTION = new HashMap<>();
            HM_COLLECTION.put(arrayname, array.get(i));
            Array_Collection.add(HM_COLLECTION);
        }

        return Array_Collection;

    }

    public static ArrayList<HashMap<String, String>> hashmapit(ArrayList<String> array1, String array1name, ArrayList<String> array2, String array2name) {

        ArrayList<HashMap<String, String>> Array_Collection = new ArrayList<>();

        for (int i = 0; i < array1.size(); i++) {
            HashMap<String, String> HM_COLLECTION = new HashMap<>();
            HM_COLLECTION.put(array1name, array1.get(i));
            HM_COLLECTION.put(array2name, array2.get(i));
            Array_Collection.add(HM_COLLECTION);
        }

        return Array_Collection;

    }

    public static ArrayList<HashMap<String, String>> hashmapit2(ArrayList<String> array1, String array1name, ArrayList<String> array2, String array2name, ArrayList<String> array3, String array3name) {

        ArrayList<HashMap<String, String>> Array_Collection = new ArrayList<>();

        for (int i = 0; i < array1.size(); i++) {
            HashMap<String, String> HM_COLLECTION = new HashMap<>();
            HM_COLLECTION.put(array1name, array1.get(i));
            HM_COLLECTION.put(array2name, array2.get(i));
            HM_COLLECTION.put(array3name, array3.get(i));
            Array_Collection.add(HM_COLLECTION);
        }

        return Array_Collection;

    }




    public static void Send_Post_Request(String URL_POST, String POST_VAR1_NAME, String POST_VAR1, String POST_VAR2_NAME, String POST_VAR2
            , String POST_VAR3_NAME, String POST_VAR3, String POST_VAR4_NAME, String POST_VAR4) {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add(POST_VAR1_NAME, POST_VAR1)
                .add(POST_VAR2_NAME, POST_VAR2)
                .add(POST_VAR3_NAME, POST_VAR3)
                .add(POST_VAR4_NAME, POST_VAR4)
                .build();

        Request request = new Request.Builder()
                .url(URL_POST)
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ListAdapter adapt_list(Context context, ArrayList<HashMap<String, String>> ArraylistHashmap,int rowLayout,ArrayList<String> names,ArrayList<Integer> ids) throws ArraylistsSizesMismatchException {

        if(names.size() != ids.size()){
            throw new ArraylistsSizesMismatchException("Both the name list size and the ids list size must match");
        }

        String[] arrNames = new String[names.size()];
        int[] arrIDs = new int[ids.size()];

        for (int i = 0; i < names.size(); i++) {
            arrNames[i] = names.get(i);
            arrIDs[i] = ids.get(i);
        }

        ListAdapter adapter = new SimpleAdapter(context, ArraylistHashmap, rowLayout, arrNames ,arrIDs);
        return adapter;
    }






//    public static void Send_Post_Request(String URL_POST, ArrayList<String> POST_NAMES, ArrayList<String> POST_VARS) throws ArraylistsSizesMismatchException{
//
////        if(POST_NAMES.size() != POST_VARS.size()){
////            throw new ArraylistsSizesMismatchException("Both the POST_NAMES list size and the POST_VARS list size must match");
////        }
////
////        OkHttpClient client = new OkHttpClient();
////        RequestBody body = new FormBody.Builder().build();
////
////
////        for (int i = 0; i < POST_VARS.size(); i++) {
////
////        }
////
////        .add(POST_VAR1_NAME, POST_VAR1)
////                .add(POST_VAR2_NAME, POST_VAR2)
////                .add(POST_VAR3_NAME, POST_VAR3)
////                .add(POST_VAR4_NAME, POST_VAR4)
////                .build();
////
////        Request request = new Request.Builder()
////                .url(URL_POST)
////                .post(body)
////                .build();
////
////        try {
////            client.newCall(request).execute();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//    }

}

