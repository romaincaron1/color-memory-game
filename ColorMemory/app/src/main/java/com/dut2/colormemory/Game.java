package com.dut2.colormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    private int mNbBlockEasy = 10;
    private int mNbBlockDifficult = 15;
    private int mNbBlockExpert = 20;

    private TextView mDifficultyTitle;
    private ImageView block_1;
    private ImageView block_2;
    private ImageView block_3;
    private ImageView block_4;
    private ImageView block_5;
    private ImageView block_6;
    private ImageView block_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mDifficultyTitle = findViewById(R.id.difficulty_title);
        block_1 = findViewById(R.id.block_1);
        block_2 = findViewById(R.id.block_2);
        block_3 = findViewById(R.id.block_3);
        block_4 = findViewById(R.id.block_4);
        block_5 = findViewById(R.id.block_5);
        block_6 = findViewById(R.id.block_6);
        block_7 = findViewById(R.id.block_7);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //Mode facile
        if(bundle.getString("mode") == "easy"){
            mDifficultyTitle.setText("Facile");
            startGame(mNbBlockEasy);
            //Scores, classement, etc...
        }

        //Mode difficile
        if(bundle.getString("mode") == "difficult"){
            mDifficultyTitle = findViewById(R.id.difficulty_title);
            mDifficultyTitle.setText("Difficile");
            startGame(mNbBlockDifficult);
            //Scores, classement, etc...
        }

        //Mode expert
        if(bundle.getString("mode") == "expert"){
            mDifficultyTitle = findViewById(R.id.difficulty_title);
            mDifficultyTitle.setText("Expert");
            startGame(mNbBlockExpert);
            //Scores, classement, etc...
        }
    }

    private void startGame(int nbBlock) {
        if(nbBlock == mNbBlockEasy){
            block_3.setImageResource(R.drawable.blue_block);
            block_4.setImageResource(R.drawable.red_block);
            block_5.setImageResource(R.drawable.green_block);
            block_6.setImageResource(R.drawable.yellow_block);
        }
    }
}