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
package com.google.samples.cronet_sample.data;

public class ImageRepository {

    private static String[] imageUrls= {
       //     "https://quic-test.boomplaymusic.com/images/77d99ecda0ff4bc78dc927635ef3469b.jpg",
            "https://d1pyb87qjhtitc.cloudfront.net/random100k.txt",
            "https://gcp.quic-benchmark.link/random100k.txt",
            "https://d1pyb87qjhtitc.cloudfront.net/v13.mp4",
            "https://gcp.quic-benchmark.link/hbo_test.mp4",
            "https://store-test-gl.heytapdl.com/do_not_delete/noc.gif",
            "https://storage.googleapis.com/cronet/sun.jpg",
            "https://storage.googleapis.com/cronet/flower.jpg",
            "https://storage.googleapis.com/cronet/chair.jpg",
            "https://storage.googleapis.com/cronet/white.jpg",
            "https://storage.googleapis.com/cronet/moka.jpg",
            "https://storage.googleapis.com/cronet/walnut.jpg"
    };

    public static int numberOfImages() {
        return imageUrls.length;
    }

    public static String getImage(int position) {
        return imageUrls[position];
    }
}
