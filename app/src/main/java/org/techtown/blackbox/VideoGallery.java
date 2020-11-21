package org.techtown.blackbox;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoGallery extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onPause() {
        if(videoView!=null && videoView.isPlaying()) videoView.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoView!=null)
            videoView.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_gallery);

        videoView = findViewById(R.id.videoVideo);
        Uri uri = getIntent().getParcelableExtra("videoUri");
//Uri uri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });




    }
}