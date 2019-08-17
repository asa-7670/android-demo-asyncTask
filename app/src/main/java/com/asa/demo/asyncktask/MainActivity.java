package com.asa.demo.asyncktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button launcherBtnView;

    private MyAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        textView = findViewById ( R.id.status_text_view );
        launcherBtnView = findViewById ( R.id.launcher_btn_view );
        launcherBtnView.setOnClickListener ( launcherOnClickListener );


        Animation animation = AnimationUtils.loadAnimation (MainActivity.this, R.anim.rotate_clockwise );
        findViewById ( R.id.image_view ).startAnimation ( animation );

    }

    private View.OnClickListener launcherOnClickListener = new View.OnClickListener () {
        @Override
        public void onClick(View view) {
            task = new MyAsyncTask ( textView );
            task.execute ( new Integer[] {2500, 1000});
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        if(task != null){
            Log.d("TASK", "OnDestroy called");
            task.cancel ( Boolean.TRUE );
        }
    }
}
