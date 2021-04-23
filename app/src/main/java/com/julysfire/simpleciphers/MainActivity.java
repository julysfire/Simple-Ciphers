package com.julysfire.simpleciphers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity
{
    private AdView madView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-4179709266227495/6118881575");

        madView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

        final Bundle bundle = new Bundle();

        final Button caesarButton = (Button) findViewById(R.id.caesarButton);
        final Button atbashButton = (Button) findViewById(R.id.atbashButton);
        final Button baconianButton = (Button) findViewById(R.id.baconianButton);
        final Button vignereButton = (Button) findViewById(R.id.vignereButton);
        final Button hexDecBinButton = (Button) findViewById(R.id.hexdecbinaryButton);
        final Button telephoneButton = (Button) findViewById(R.id.telephoneButton);

        caesarButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                caesarButt();
            }
        });
        atbashButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                atbashButt();
            }
        });
        baconianButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                baconianButt();
            }
        });
        vignereButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                vignereButt();
            }
        });
        hexDecBinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hexdecButt();
            }
        });
        telephoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telephoneButt();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        final Context context = getApplicationContext();
        final int Duration = Toast.LENGTH_LONG;

        if (id == R.id.suggestions_settings)
        {
            Toast toast = Toast.makeText(context, "Please send suggestions to julysfire@gmail.com", Duration);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void caesarButt()
    {
        Intent intent = new Intent(this, CaesarActivity.class);
        startActivity(intent);
    }

    public void atbashButt()
    {
        Intent intent = new Intent(this, AtbashActivity.class);
        startActivity(intent);
    }

    public void baconianButt()
    {
        Intent intent = new Intent(this, BaconianActivity.class);
        startActivity(intent);
    }

    public void vignereButt()
    {
        Intent intent = new Intent(this, VignereActivity.class);
        startActivity(intent);
    }

    public void hexdecButt()
    {
        Intent intent = new Intent(this, HexDecimalBinaryActivity.class);
        startActivity(intent);
    }

    public void telephoneButt()
    {
        Intent intent = new Intent(this, TelephoneActivity.class);
        startActivity(intent);
    }
}
