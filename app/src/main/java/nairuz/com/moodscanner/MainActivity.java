package nairuz.com.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

import java.lang.reflect.Array;


public class MainActivity extends SherlockActivity {

    private ImageView thumb_imageView;
    private TextView result_textView;
    private AnimationDrawable thumb_animation;
    private String[] mood_results;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String array:
        mood_results = new String[]{"Someone is cranky!",
                "You are my sunshine!",
                "No comments...",
                "You're stressed out!",
                "Happy camper :)",
                "Not your day :(",
                "Smile - it's good for you.",
                "In the clouds...",
                "Pensive!",
                "Sad!",
                "Excited!"};

        //Animation part :
        thumb_imageView = (ImageView) findViewById(R.id.imageView_animation_Id);
        thumb_imageView.setBackgroundResource(R.drawable.thumb_animation);
        thumb_animation = (AnimationDrawable) thumb_imageView.getBackground();

        //result text view part
        result_textView = (TextView) findViewById(R.id.mood_result);

        //Action Listener that responsible for the longed pressed click
        thumb_imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                thumb_animation.start(); //start the animation
                showResult();
                //Toast.makeText(getApplicationContext(),mood_results.length,Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }


    public void showResult() {

        //use class Runnable to delay action
        mRunnable = new Runnable() {
            @Override
            public void run() {
                //randomize mood_Result string and show via setText:
                int rand = (int) (Math.random() * mood_results.length);
                result_textView.setText(mood_results[rand]); // show randomize text

                //to stop animation
                thumb_animation.stop();
            }
        };

        //use Handler to post delay runnable method
        Handler handler = new Handler();
        handler.postDelayed(mRunnable, 5000); //post Delay method takes runnable method and time in milliseconds
        // 5000 millisecons is 5 seconds


    }


}
