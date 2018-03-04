    package com.mrtyvz.archedimageprogressbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        whatsappProgress.setArcSize(45.0f);
        whatsappProgress.setCircleColor(Color.parseColor("#4db6ac"));
        whatsappProgress.setArcColor(Color.parseColor("#004A01"));
        whatsappProgress.setArcLength(50);
        whatsappProgress.setArcStroke(12.0f);
        whatsappProgress.setArcSpeed(6);

        /*--------------INSTAGRAM-------------*/
        ArchedImageProgressBar instagramArcProgress = findViewById(R.id.ig_progressBar);
        Bitmap igIcon = BitmapFactory.decodeResource(getResources(), R.drawable.instagram);

        instagramArcProgress.setProgressImage(igIcon, 28.0f);
        instagramArcProgress.setCircleSize(50.0f);
        instagramArcProgress.setArcSize(55.0f);
        instagramArcProgress.setCircleColor(Color.parseColor("#f44336"));
        instagramArcProgress.setArcColor(Color.parseColor("#b71c1c"));
        instagramArcProgress.setArcLength(70);
        instagramArcProgress.setArcStroke(18.0f);
        instagramArcProgress.setArcSpeed(9);


        /*--------------LINKEDIN-----------------*/

        ArchedImageProgressBar linkedinArcProgress = findViewById(R.id.linkedin_progressBar);
        Bitmap linkedinIcon = BitmapFactory.decodeResource(getResources(),R.drawable.linkedin_sign);

        linkedinArcProgress.setProgressImage(linkedinIcon,14.0f);
        linkedinArcProgress.setCircleSize(30.0f);
        linkedinArcProgress.setArcSize(32.75f);
        linkedinArcProgress.setCircleColor(Color.parseColor("#3949ab"));
        linkedinArcProgress.setArcColor(Color.parseColor("#1a237e"));
        linkedinArcProgress.setArcLength(210);
        linkedinArcProgress.setArcStroke(8.85f);
        linkedinArcProgress.setArcSpeed(5);


        /*---------------SPOTIFY---------------*/
        ArchedImageProgressBar spotifyArcProgress = findViewById(R.id.spotify_progressBar);
        Bitmap spotifyIcon = BitmapFactory.decodeResource(getResources(), R.drawable.spotify_black);

        spotifyArcProgress.setProgressImage(spotifyIcon, 15.0f);
        spotifyArcProgress.setCircleSize(30.0f);
        spotifyArcProgress.setArcSize(33.0f);
        spotifyArcProgress.setCircleColor(Color.parseColor("#64dd17"));
        spotifyArcProgress.setArcColor(Color.parseColor("#000000"));
        spotifyArcProgress.setArcLength(90);
        spotifyArcProgress.setArcStroke(21.0f);
        spotifyArcProgress.setArcSpeed(4);


        /*---------------CUSTOM_TEXT_1---------------*/
        ArchedImageProgressBar customTextArcProgress = findViewById(R.id.ct1_progressBar);

        customTextArcProgress.setProgressText(new String[]{"Loading"}, "#c5cae9");
        customTextArcProgress.setProgressTextSize(13.0f);
        customTextArcProgress.setCircleSize(35.0f);
        customTextArcProgress.setArcSize(43.0f);
        customTextArcProgress.setCircleColor(Color.parseColor("#3949ab"));
        customTextArcProgress.setArcColor(Color.parseColor("#fb8c00"));
        customTextArcProgress.setArcLength(120);
        customTextArcProgress.setArcStroke(9.0f);
        customTextArcProgress.setArcSpeed(3);


        /*---------------CUSTOM_TEXT_2---------------*/
        ArchedImageProgressBar customText2ArcProgress = findViewById(R.id.ct2_progressBar);

        customText2ArcProgress.setProgressText(new String[]{"Wellcome !"}, "#ffffff");
        customText2ArcProgress.setProgressTextSize(14.25f);
        customText2ArcProgress.setCircleSize(45.0f);
        customText2ArcProgress.setArcSize(48.0f);
        customText2ArcProgress.setCircleColor(Color.parseColor("#FFA000"));
        customText2ArcProgress.setArcColor(Color.parseColor("#FF5722"));
        customText2ArcProgress.setArcLength(180);
        customText2ArcProgress.setArcStroke(15.0f);
        customText2ArcProgress.setArcSpeed(7);
    }
}
