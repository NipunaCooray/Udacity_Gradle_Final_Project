package com.example.jokeviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JokeViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        Intent intent = getIntent();
        String message = intent.getStringExtra("joke_message");

        TextView jokeView = findViewById(R.id.tv_jokeText);
        jokeView.setText(message);
    }
}
