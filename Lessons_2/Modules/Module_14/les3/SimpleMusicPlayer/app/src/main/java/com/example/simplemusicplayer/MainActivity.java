package com.example.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton playImageButton, stopImageButton;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playImageButton = findViewById(R.id.playImageButton);
        stopImageButton = findViewById(R.id.stopImageButton);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mussic);
    }

    public void MusicButtons(View view) {
        if (view.getId() == R.id.playImageButton) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                playImageButton.setImageResource(R.drawable.ic_pause);
            } else {
                mediaPlayer.pause();
                playImageButton.setImageResource(R.drawable.ic_play);
            }
        } else if (view.getId() == R.id.stopImageButton) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                playImageButton.setImageResource(R.drawable.ic_play);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mussic);
            }
        }
    }
}