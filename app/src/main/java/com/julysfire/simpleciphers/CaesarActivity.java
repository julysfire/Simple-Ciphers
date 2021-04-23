package com.julysfire.simpleciphers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.ClipboardManager;
import android.content.ClipData;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CaesarActivity extends AppCompatActivity
{
    private AdView madView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caesar_main);
        MobileAds.initialize(this, "ca-app-pub-4179709266227495~4642148376");
        madView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

        //Objects
        final EditText numberText = (EditText) findViewById(R.id.phraseText);
        final EditText inputText = (EditText) findViewById(R.id.inputString);
        final TextView outputText = (TextView) findViewById(R.id.outputText);
        final Button decryptButton = (Button) findViewById(R.id.buttonDecrypt);
        final Button encryptButton = (Button) findViewById(R.id.buttonEncrypt);
        final Button copyButton = (Button) findViewById(R.id.caesarCopyButton);

        final ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        final Context context = getApplicationContext();
        final int Duration = Toast.LENGTH_LONG;
        final int DurationShot = Toast.LENGTH_SHORT;
        final CharSequence textNum = "Please enter a number into the second step.";
        final CharSequence textText = "Please enter some text into the first step.";

        //Decrypt
        decryptButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String input = "";
                int offsetNum = 0;
                boolean runNum = true;
                boolean runText = true;

                if(inputText.getText().toString().isEmpty() == false)
                {
                    input = inputText.getText().toString();
                }
                else {
                    runText = false;
                    Toast toast = Toast.makeText(context, textText, Duration);
                    toast.show();
                }

                if(numberText.getText().toString().isEmpty() == false)
                {
                    offsetNum = Integer.parseInt(numberText.getText().toString());
                }
                else {
                    runNum = false;
                    Toast toast = Toast.makeText(context, textNum, Duration);
                    toast.show();
                }
                if(runNum == true && runText == true)
                {
                    CaesarCipher caesarDec = new CaesarCipher();
                    String outputString = caesarDec.decrypt(input, offsetNum);
                    outputText.setText(outputString);
                }
            }
        });


        //Encrypt
        encryptButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                String input = "";
                int offsetNum = 0;
                boolean runNum = true;
                boolean runText = true;

                if(inputText.getText().toString().isEmpty() == false)
                {
                    input = inputText.getText().toString();
                }
                else
                {
                    runText = false;
                    Toast toast = Toast.makeText(context, textText, Duration);
                    toast.show();
                }
                if(numberText.getText().toString().isEmpty() == false)
                {
                    offsetNum = Integer.parseInt(numberText.getText().toString());
                }
                else
                {
                    runNum = false;
                    Toast toast = Toast.makeText(context, textNum, Duration);
                    toast.show();
                }
                if (runNum == true && runText == true)
                {
                    CaesarCipher caesarEnc = new CaesarCipher();
                    String outputString = caesarEnc.encrypt(input, offsetNum);
                    outputText.setText(outputString);
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
            Intent aboutIntent = new Intent(this, AboutCaesarActivity.class);
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
}
