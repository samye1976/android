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

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WelcomeActivity extends AppCompatActivity{

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.welcome_layout);
        setUpToolbar();

        ((TextView) findViewById(R.id.welcome_introduction))
                .setText(R.string.welcome_introduction_text);
        ((TextView) findViewById(R.id.cronet_load_CloudFront_small))
                .setText("cronet_load_images_text_cf_small");
        ((TextView) findViewById(R.id.cronet_load_GCP_small))
                .setText("cronet_load_images_text_gcp_small");
        ((TextView) findViewById(R.id.cronet_load_CloudFront_large))
                .setText("cronet_load_images_text_cf_large");
        ((TextView) findViewById(R.id.cronet_load_GCP_large))
                .setText("cronet_load_images_text_gcp_large");
    }

    /*
    public void openImages(View view) {
        Intent mpdIntent = new Intent(this, MainActivity.class);
        startActivity(mpdIntent);
    }
     */

    public void openImages_cf_small(View view) {
        Intent mpdIntent = new Intent(this, MainActivity.class);
        mpdIntent.putExtra("item", 0);
        startActivity(mpdIntent);
    }

    public void openImages_gcp_small(View view) {
        Intent mpdIntent = new Intent(this, MainActivity.class);
        mpdIntent.putExtra("item",1);
        startActivity(mpdIntent);
    }

    public void openImages_cf_large(View view) {
        Intent mpdIntent = new Intent(this, MainActivity.class);
        mpdIntent.putExtra("item", 2);
        startActivity(mpdIntent);
    }

    public void openImages_gcp_large(View view) {
        Intent mpdIntent = new Intent(this, MainActivity.class);
        mpdIntent.putExtra("item",3);
        startActivity(mpdIntent);
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.welcome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((TextView) toolbar.findViewById(R.id.welcome_title)).setText(R.string.welcome_activity);
    }
}
