package com.julysfire.simpleciphers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AboutHexDecimalBinary extends AppCompatActivity
{
    private AdView madView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_hexdecimalbinary);

        MobileAds.initialize(this, "ca-app-pub-4179709266227495~4642148376");
        madView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

        final TextView hexLink = (TextView)findViewById(R.id.hexadecmialLink);
        final TextView decimalLink = (TextView)findViewById(R.id.decimalLink);
        final TextView binaryLink = (TextView)findViewById(R.id.binarylink);

        hexLink.setMovementMethod(LinkMovementMethod.getInstance());
        decimalLink.setMovementMethod(LinkMovementMethod.getInstance());
        binaryLink.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
