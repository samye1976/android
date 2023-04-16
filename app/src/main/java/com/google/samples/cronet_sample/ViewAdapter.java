/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.samples.cronet_sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.util.Log;

import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.RecyclerView;

import com.google.samples.cronet_sample.data.ImageRepository;

import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.ExperimentalUrlRequest;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private final MainActivity mainActivity;
    private static final String TAG = MainActivity.class.getSimpleName();

    public ViewAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_layout, null);
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImageViewCronet;

        public ViewHolder(View v) {
            super(v);
            mImageViewCronet = itemView.findViewById(R.id.cronet_image);
        }

        public ImageView getmImageViewCronet() {
            return mImageViewCronet;
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        CronetApplication cronetApplication = mainActivity.getCronetApplication();

        // UrlRequest and UrlRequest.Callback are the core of Cronet operations. UrlRequest is used
        // to issue requests, UrlRequest.Callback specifies how the application reacts to the server
        // responses.

        // Set up a callback which, on a successful read of the entire response, interprets
        // the response body as an image. By default, Cronet reads the body in small parts, having
        // the full body as a byte array is application specific logic. For more details about
        // the callbacks please see implementation of ReadToMemoryCronetCallback.
        ReadToMemoryCronetCallback callback = new ReadToMemoryCronetCallback() {
            @Override
            void onSucceeded(UrlRequest request, UrlResponseInfo info, byte[] bodyBytes,
                             long latencyNanos) {
                mainActivity.protocol = info.getNegotiatedProtocol();
                // Log.e(TAG, "res_headers:" + info.getAllHeaders());
                Map<String, List<String>> header=info.getAllHeaders();
                if (header.containsKey("x-amz-cf-pop")) {
                    mainActivity.pop = header.get("x-amz-cf-pop").get(0);
                }
                else {
                    mainActivity.pop = "NA";
                }

                if (header.containsKey("x-amz-cf-id")) {
                    mainActivity.rid = header.get("x-amz-cf-id").get(0);
                }
                else {
                    mainActivity.rid = "NA";
                }

                // Contribute the request latency
                //mainActivity.onCronetImageLoadSuccessful(latencyNanos);

                // Send image to layout
                /*
                final Bitmap bimage = BitmapFactory.decodeByteArray(bodyBytes, 0, bodyBytes.length);
                mainActivity.runOnUiThread(() -> {
                    holder.getmImageViewCronet().setImageBitmap(bimage);
                    holder.getmImageViewCronet().getLayoutParams().height = bimage.getHeight();
                    holder.getmImageViewCronet().getLayoutParams().width = bimage.getWidth();
                });
                */
            }
        };
/*
        // The URL request builder allows you to customize the request.
        UrlRequest.Builder builder = cronetApplication.getCronetEngine()
                .newUrlRequestBuilder(
                        ImageRepository.getImage(position),
                        callback,
                        cronetApplication.getCronetCallbackExecutorService())
                // You can set arbitrary headers as needed
                .addHeader("x-my-custom-header", "Hello-from-Cronet")
                //.addHeader("range","bytes=0-1000")
                // Cronet supports QoS if you specify request priorities
                .setPriority(UrlRequest.Builder.REQUEST_PRIORITY_IDLE);
        // ... and more! Check the UrlRequest.Builder docs.

 */


        // The URL request builder allows you to customize the request.
        ExperimentalUrlRequest.Builder builder = (ExperimentalUrlRequest.Builder) cronetApplication.getCronetEngine()
                .newUrlRequestBuilder(
                        ImageRepository.getImage(mainActivity.item),
                        callback,
                        cronetApplication.getCronetCallbackExecutorService())
                // You can set arbitrary headers as needed
                .addHeader("x-my-custom-header", "Hello-from-Cronet")
                //.addHeader("range","bytes=0-1000")
                // Cronet supports QoS if you specify request priorities
                .setPriority(UrlRequest.Builder.REQUEST_PRIORITY_IDLE);
        // ... and more! Check the UrlRequest.Builder docs.


        // Start the request
        builder.setRequestFinishedListener(new RequestFinishedInfo.Listener(cronetApplication.getCronetCallbackExecutorService()) {
            @Override
            public void onRequestFinished(RequestFinishedInfo requestInfo) {
                    //Log.e(TAG, "url:" + requestInfo.getUrl());
                    //Log.e(TAG, "annotations:" + requestInfo.getAnnotations());
                    //Log.e(TAG, "exception:" + requestInfo.getException());
                    //Log.e(TAG, "finishedReason:" + requestInfo.getFinishedReason());
                    //Log.e(TAG, "fbl:" + requestInfo.getMetrics().getTtfbMs());
                    //Log.e(TAG, "lbl:" + requestInfo.getMetrics().getTotalTimeMs());
                    //Log.e(TAG, "sc-bytes:" + requestInfo.getMetrics().getReceivedByteCount());
                    //Log.e(TAG, "tcp-reused:" + requestInfo.getMetrics().getSocketReused());
                    //Log.e(TAG, "dns-start:" + requestInfo.getMetrics().getDnsStart());
                    //Log.e(TAG, "dns-end:" + requestInfo.getMetrics().getDnsEnd());
                    //Log.e(TAG, "request-start:" + requestInfo.getMetrics().getRequestStart());
                    //Log.e(TAG, "request-end:" + requestInfo.getMetrics().getRequestEnd());
                    //Log.e(TAG, "connect-start:" + requestInfo.getMetrics().getConnectStart());
                    //Log.e(TAG, "connect-end:" + requestInfo.getMetrics().getConnectEnd());
                    //Log.e(TAG, "push-start:" + requestInfo.getMetrics().getPushStart());
                    //Log.e(TAG, "push-end:" + requestInfo.getMetrics().getPushEnd());
                    //Log.e(TAG, "sending-start:" + requestInfo.getMetrics().getSendingStart());
                    //Log.e(TAG, "sending-end:" + requestInfo.getMetrics().getSendingEnd());
                    //Log.e(TAG, "ssl-start:" + requestInfo.getMetrics().getSslStart());
                    //Log.e(TAG, "ssl-end:" + requestInfo.getMetrics().getSslEnd());
                    //Log.e(TAG, "response-start:" + requestInfo.getMetrics().getResponseStart());
                    mainActivity.url = requestInfo.getUrl();
                    mainActivity.lbl = requestInfo.getMetrics().getTotalTimeMs();
                    mainActivity.fbl = requestInfo.getMetrics().getTtfbMs();
                    if (requestInfo.getMetrics().getDnsStart() != null) {
                        mainActivity.dns = requestInfo.getMetrics().getDnsEnd().getTime() - requestInfo.getMetrics().getDnsStart().getTime();
                    }
                    else {
                        mainActivity.dns = 0;
                    }
                    if (requestInfo.getMetrics().getSslStart() != null) {
                        mainActivity.ssl = requestInfo.getMetrics().getSslEnd().getTime() - requestInfo.getMetrics().getSslStart().getTime();
                    }
                    else {
                        mainActivity.ssl = 0;
                    }
                    mainActivity.tcp_reuse = requestInfo.getMetrics().getSocketReused();


                // Contribute the request latency
                    mainActivity.onCronetImageLoadSuccessful(100);
            }
        });



        builder.build().start();

        
    }

    @Override
    public int getItemCount() {
        return Math.min(
                mainActivity.getCronetApplication().imagesToLoadCeiling.get(),
                ImageRepository.numberOfImages());
    }

    /**
     * Holder of multiple metrics that can be atomically updated.
     */


}
