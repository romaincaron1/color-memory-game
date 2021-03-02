package com.dut2.colormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GameMenu extends AppCompatActivity {

    private ImageView mImageViewEasy;
    private ImageView mImageViewDifficult;
    private ImageView mImageViewExpert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        mImageViewEasy = findViewById(R.id.iv_btn_easy);
        mImageViewDifficult = findViewById(R.id.iv_btn_difficult);
        mImageViewExpert = findViewById(R.id.iv_btn_expert);

        Intent intent = new Intent(GameMenu.this, Game.class);
        Bundle bundle = new Bundle();
        mImageViewEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("mode", "easy");
                intent.putExtras(bundle);
                startActivityForResult(intent, 3000);
            }
        });

        mImageViewDifficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("mode", "difficult");
                intent.putExtras(bundle);
                startActivityForResult(intent, 3000);
            }
        });

        mImageViewExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("mode", "expert");
                intent.putExtras(bundle);
                startActivityForResult(intent, 3000);
            }
        });

    }
}