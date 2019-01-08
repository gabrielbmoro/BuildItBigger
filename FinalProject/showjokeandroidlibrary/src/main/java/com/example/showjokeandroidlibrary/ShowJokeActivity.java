package com.example.showjokeandroidlibrary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public static String JOKE_INTENT_KEY = "joke intent key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        String jokeArgument = getIntent().getExtras().getString(JOKE_INTENT_KEY);

        if (jokeArgument == null || jokeArgument.isEmpty()) finish();
        else {
            TextView tvJokeContent = findViewById(R.id.tvJokeText);
            tvJokeContent.setText(jokeArgument);
        }

    }

    public static void startActivity(Context context, @NonNull String jokeArgument) {
        Intent intent = new Intent(context, ShowJokeActivity.class);
        intent.putExtra(JOKE_INTENT_KEY, jokeArgument);
        context.startActivity(intent);
    }

}
