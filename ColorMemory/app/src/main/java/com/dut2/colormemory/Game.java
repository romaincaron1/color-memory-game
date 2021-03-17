package com.dut2.colormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    private TextView mDifficultyTitle;
    private Button mStartButton;
    private ImageView block_1;
    private ImageView block_2;
    private ImageView block_3;
    private ImageView block_4;
    private ImageView block_5;
    private ImageView block_6;
    private ImageView block_7;
    private ImageView block_8;
    private ImageView block_9;
    private ImageView block_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mDifficultyTitle = findViewById(R.id.difficulty_title);
        mStartButton = findViewById(R.id.btn_start);
        block_1 = findViewById(R.id.block_1);
        block_2 = findViewById(R.id.block_2);
        block_3 = findViewById(R.id.block_3);
        block_4 = findViewById(R.id.block_4);
        block_5 = findViewById(R.id.block_5);
        block_6 = findViewById(R.id.block_6);
        block_7 = findViewById(R.id.block_7);
        block_8 = findViewById(R.id.block_8);
        block_9 = findViewById(R.id.block_9);
        block_10 = findViewById(R.id.block_10);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //mDifficultyTitle.setText(bundle.getString("mode"));

        //Mode facile
        if(bundle.getString("mode").equals("easy")){
            mDifficultyTitle.setText("Facile");
        }

        //Mode difficile
        if(bundle.getString("mode").equals("difficult")){
            mDifficultyTitle.setText("Difficile");
        }

        //Mode expert
        if(bundle.getString("mode") == "expert") {
            mDifficultyTitle.setText("Expert");
        }

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartButton.setVisibility(View.INVISIBLE);
                startGame(bundle.getString("mode"));
            }
        });
    }

    private void startGame(String difficulty) {
        if(difficulty.equals("easy")){
            block_3.setImageResource(R.drawable.blue_block);
            block_4.setImageResource(R.drawable.red_block);
            block_7.setImageResource(R.drawable.green_block);
            block_8.setImageResource(R.drawable.yellow_block);

            //for(int i = 0; i < 7; i++){
            //}
        }
    }
}