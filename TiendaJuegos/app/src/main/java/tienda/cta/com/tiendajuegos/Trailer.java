package tienda.cta.com.tiendajuegos;

import android.os.Bundle;
import android.widget.Toast;

//import com.google.android.youtube.player.YouTubeBaseActivity;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//
//public class Trailer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
//
//    public static final String API_KEY = "AIzaSyDys-vvz5hyFrZb5Ne_aBV_Plok4y3p9k0";
//    public static final String VIDEO_ID = "o7VVHhK9zf0";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trailer);
//
//        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeplayerview);
//        youTubePlayerView.initialize(API_KEY, this);
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider,
//                                        YouTubeInitializationResult result) {
//        Toast.makeText(getApplicationContext(),
//                "onInitializationFailure()",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
//                                        boolean wasRestored) {
//        if (!wasRestored) {
//            player.cueVideo(VIDEO_ID);
//        }
//    }
//
//}
