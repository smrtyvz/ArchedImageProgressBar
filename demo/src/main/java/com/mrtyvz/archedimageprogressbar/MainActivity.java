package com.mrtyvz.archedimageprogressbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mrtyvz.archedimageprogress.ArchedImageProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArchedImageProgressBar whatsappProgress = findViewById(R.id.wp_progressBar);
        Bitmap wpIcon = BitmapFactory.decodeResource(getResources(), R.drawable.whatsapp_logo);

        whatsappProgress.setProgressImage(wpIcon, 17.50f);
        whatsappProgress.setCircleSize(40.0f);
        whatsappProgress.setArchSize(45.0f);
        whatsappProgress.setCircleColor(Color.parseColor("#4db6ac"));
        whatsappProgress.setArchColor(Color.parseColor("#004A01"));
        whatsappProgress.setArchLength(50);
        whatsappProgress.setArchStroke(12.0f);
        whatsappProgress.setArchSpeed(6);
        whatsappProgress.setClockwise(true);

        /*--------------INSTAGRAM-------------*/
        ArchedImageProgressBar instagramArcProgress = findViewById(R.id.ig_progressBar);
        Bitmap igIcon = BitmapFactory.decodeResource(getResources(), R.drawable.instagram);

        instagramArcProgress.setProgressImage(igIcon, 28.0f);
        instagramArcProgress.setCircleSize(50.0f);
        instagramArcProgress.setArchSize(55.0f);
        instagramArcProgress.setCircleColor(Color.parseColor("#f44336"));
        instagramArcProgress.setArchColor(Color.parseColor("#b71c1c"));
        instagramArcProgress.setArchLength(70);
        instagramArcProgress.setArchStroke(18.0f);
        instagramArcProgress.setArchSpeed(9);


        /*--------------LINKEDIN-----------------*/

        ArchedImageProgressBar linkedinArcProgress = findViewById(R.id.linkedin_progressBar);
        Bitmap linkedinIcon = BitmapFactory.decodeResource(getResources(), R.drawable.linkedin_sign);

        linkedinArcProgress.setProgressImage(linkedinIcon, 14.0f);
        linkedinArcProgress.setCircleSize(30.0f);
        linkedinArcProgress.setArchSize(32.75f);
        linkedinArcProgress.setCircleColor(Color.parseColor("#3949ab"));
        linkedinArcProgress.setArchColor(Color.parseColor("#1a237e"));
        linkedinArcProgress.setArchLength(210);
        linkedinArcProgress.setArchStroke(8.85f);
        linkedinArcProgress.setArchSpeed(5);


        /*---------------SPOTIFY---------------*/
        ArchedImageProgressBar spotifyArcProgress = findViewById(R.id.spotify_progressBar);
        Bitmap spotifyIcon = BitmapFactory.decodeResource(getResources(), R.drawable.spotify_black);

        spotifyArcProgress.setProgressImage(spotifyIcon, 15.0f);
        spotifyArcProgress.setCircleSize(30.0f);
        spotifyArcProgress.setArchSize(33.0f);
        spotifyArcProgress.setCircleColor(Color.parseColor("#64dd17"));
        spotifyArcProgress.setArchColor(Color.parseColor("#000000"));
        spotifyArcProgress.setArchLength(90);
        spotifyArcProgress.setArchStroke(21.0f);
        spotifyArcProgress.setArchSpeed(4);
        spotifyArcProgress.setClockwise(true);


        /*---------------CUSTOM_TEXT_1---------------*/
        ArchedImageProgressBar customTextArcProgress = findViewById(R.id.ct1_progressBar);

        customTextArcProgress.setProgressText(new String[]{"Loading"}, "#c5cae9");
        customTextArcProgress.setProgressTextSize(13.0f);
        customTextArcProgress.setCircleSize(35.0f);
        customTextArcProgress.setArchSize(43.0f);
        customTextArcProgress.setCircleColor(Color.parseColor("#3949ab"));
        customTextArcProgress.setArchColor(Color.parseColor("#fb8c00"));
        customTextArcProgress.setArchLength(120);
        customTextArcProgress.setArchStroke(9.0f);
        customTextArcProgress.setArchSpeed(3);


        /*---------------CUSTOM_TEXT_2---------------*/
        ArchedImageProgressBar customText2ArcProgress = findViewById(R.id.ct2_progressBar);

        customText2ArcProgress.setProgressText(new String[]{"Wellcome !"}, "#ffffff");
        customText2ArcProgress.setProgressTextSize(14.25f);
        customText2ArcProgress.setCircleSize(45.0f);
        customText2ArcProgress.setArchSize(48.0f);
        customText2ArcProgress.setCircleColor(Color.parseColor("#FFA000"));
        customText2ArcProgress.setArchColor(Color.parseColor("#FF5722"));
        customText2ArcProgress.setArchLength(180);
        customText2ArcProgress.setArchStroke(15.0f);
        customText2ArcProgress.setArchSpeed(7);
        customText2ArcProgress.setClockwise(true);
    }
}
