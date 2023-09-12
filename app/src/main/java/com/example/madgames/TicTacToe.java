package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {

    Button button;
    TextView title,enterPlayer;
    ImageView gameImage;
    EditText player1,player2;
    ConstraintLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);



        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);


        player1.setTextColor(ContextCompat.getColor(this,R.color.black));
       // player1.setBackgroundColor(Color.blue());
        //player2.setBackgroundColor(Color.YELLOW);




    }

    public void nextPage(View v){
        if(!player1.getText().toString().isEmpty() && !player2.getText().toString().isEmpty()){
            Intent intent=new Intent(this,TicGame.class);
            intent.putExtra("player1",player1.getText());
            intent.putExtra("player2",player2.getText());
            getApplicationContext().startActivity(intent);
        }else {
            if(TextUtils.isEmpty(player1.getText().toString())){
                player1.setError("field cannot be empty");
            }
            if (TextUtils.isEmpty(player2.getText().toString())) {
                player2.setError("field cannot be empty");
            }
        }


    }
}