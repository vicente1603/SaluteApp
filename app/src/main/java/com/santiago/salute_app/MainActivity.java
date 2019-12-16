package com.santiago.salute_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_whatsApp;
    private Button btn_number1;
    private Button btn_number2;
    private Button btn_agendar;
    private Button btn_maps;
    private Button btn_uber;
    private ImageButton img_btn_instagram;
    private ImageButton img_btn_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_whatsApp = findViewById(R.id.btn_whatsapp);
        btn_number1 = findViewById(R.id.btn_number1);
        btn_number2 = findViewById(R.id.btn_number2);
        btn_agendar = findViewById(R.id.btn_agendar);
        btn_maps = findViewById(R.id.btn_maps);
        btn_uber = findViewById(R.id.btn_uber);
        img_btn_instagram = findViewById(R.id.image_btn_instagram);
        img_btn_email = findViewById(R.id.image_btn_email);

        btn_whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String toNumber = "5579988535655";

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber));
                    startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


        btn_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = "79 988535655";
                Uri uri = Uri.parse("tel:" + number1);

                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }

                startActivity(intent);

            }
        });

        btn_number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number2 = "79 998400015";
                Uri uri = Uri.parse("tel:" + number2);

                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }

                startActivity(intent);

            }
        });

        btn_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://centrosalute.calendrier.com.br/#/home");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        img_btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email="eccmello@hotmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + Email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));

            }
        });

        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Uri gmmIntentUri = Uri.parse("geo:-10.951356,-37.0751735,17?q="  + Uri.encode("R. Paulo Henrique Machado Pímentel, 179 - Inácio Barbosa"));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 1000);

            }
        });

        img_btn_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("http://instagram.com/_u/terapiasalute");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/terapiasalute")));
                }

            }
        });

        btn_uber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                PackageManager pm = getPackageManager();
//                try {
//                    pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
//                    String uri = "geo:-10.951356,-37.0751735,17?q="  ;
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(uri));
//                    startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
//                } catch (PackageManager.NameNotFoundException e) {
//                    try {
//                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
//                    } catch (android.content.ActivityNotFoundException anfe) {
//                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));
//                    }
//                }

                String uri = "geo:-10.951356,-37.0751735,17";
                startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.sair) {

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
