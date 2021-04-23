package com.julysfire.simpleciphers;

import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HexDecimalBinaryActivity extends AppCompatActivity
{
    private AdView madView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hex_decimal_binary);

        //Ads
        MobileAds.initialize(this, "ca-app-pub-4179709266227495/6118881575");
        madView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);
        //

        final Button goButton = (Button) findViewById(R.id.goButton);
        final EditText inputText = (EditText)findViewById(R.id.inputString);
        final TextView outputText = (TextView)findViewById(R.id.outputText);
        final Button copyButton = (Button) findViewById(R.id.hexDecCopyButton);

        final ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        final Context context = getApplicationContext();
        final int Duration = Toast.LENGTH_LONG;
        final int DurationShot = Toast.LENGTH_SHORT;
        final CharSequence empty = "Please enter some text to be converted!";

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String output = "";
                HexDecimalBinary encryptDecrypt = new HexDecimalBinary();
                String input = inputText.getText().toString();

                if(input.isEmpty())
                {
                    Toast toast = Toast.makeText(context, empty, Duration);
                    toast.show();
                }
                else {
                    output = encryptDecrypt.encryptDecrypt(input, getInputType(), getOutputType());
                    outputText.setText(output);
                }
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clipboard copy
                ClipData clip = ClipData.newPlainText("Copied Data", outputText.getText().toString());
                clipboard.setPrimaryClip(clip);
                if (outputText.getText().toString() == "")
                {
                    Toast toast = Toast.makeText(context, "Nothing to copy.", DurationShot);
                    toast.show();
                }
                else
                {
                    Toast toast = Toast.makeText(context, "Copied to clipboard", DurationShot);
                    toast.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        final Context context = getApplicationContext();
        final int Duration = Toast.LENGTH_LONG;

        if(id == R.id.about_settings)
        {
            Intent aboutIntent = new Intent(this, AboutHexDecimalBinary.class);
            startActivity(aboutIntent);
            return true;
        }
        else if (id == R.id.suggestions_settings)
        {
            Toast toast = Toast.makeText(context, "Please send suggestions to julysfire@gmail.com", Duration);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getInputType()
    {
        final Spinner inputSpinner = (Spinner) findViewById(R.id.inputType);
        return inputSpinner.getSelectedItem().toString();
    }

    public String getOutputType()
    {
        final Spinner outputSpinner = (Spinner) findViewById(R.id.outputType);
        return outputSpinner.getSelectedItem().toString();
    }
}
