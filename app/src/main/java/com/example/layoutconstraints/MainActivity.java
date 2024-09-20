package com.example.layoutconstraints;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.imageView5); // Flag ImageView
        sw = findViewById(R.id.switch1); // Switch to toggle animation

        // Set listener for the switch
        sw.setOnCheckedChangeListener((btn, isChecked) -> {
            if (isChecked) {
                // If the switch is ON, start the rotate animation
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000); // 5 seconds per rotation
                rotate.setRepeatCount(Animation.INFINITE); // Infinite rotations
                rotate.setInterpolator(new LinearInterpolator()); // Constant speed
                imgView.startAnimation(rotate);
            } else {
                // If the switch is OFF, clear the animation
                imgView.clearAnimation();
            }
        });
    }
}
