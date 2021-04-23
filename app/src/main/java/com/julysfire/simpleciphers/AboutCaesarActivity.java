package com.julysfire.simpleciphers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class AboutCaesarActivity extends AppCompatActivity
{
    private AdView madView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_caesar);
        MobileAds.initialize(this, "ca-app-pub-4179709266227495~4642148376");
        madView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);
        final TextView linkText = (TextView)findViewById(R.id.linkCaesarText);
        linkText.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
