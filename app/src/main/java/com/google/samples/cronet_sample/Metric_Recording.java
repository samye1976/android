package com.google.samples.cronet_sample;

import android.util.Log;

import org.chromium.net.UrlRequest;

import java.util.HashMap;
import java.util.Map;

public class Metric_Recording extends UrlRequest.StatusListener{
    private final Map<Integer, Long> map =  new HashMap<>();


    @Override
    public void onStatus(int status) {
        map.put(status, System.nanoTime());
        android.util.Log.i("samye", String.valueOf(status));
    }
}
