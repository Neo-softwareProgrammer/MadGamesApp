package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class FistGame extends AppCompatActivity {

    Button player1,player2;
    int score1=0,score2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist_game);
        player1=findViewById(R.id.player1Button);
        player2=findViewById(R.id.player2Button);
        player1.setBackgroundColor(Color.RED);
        player2.setBackgroundColor(Color.BLUE);
        player1.setHeight(623);
        player2.setHeight(623);
        Intent intent=new Intent(getApplicationContext(),FistScore.class);

        Intent i=getIntent();
        Bundle b=i.getExtras();
         score1=b.getInt("score1");
         score2=b.getInt("score2");
        String player1nam=b.get("player1").toString();
        String player2nam=b.get("player2").toString();
        player1.setText(player1nam);
        player2.setText(player2nam);

        /*DisplayMetrics dm=new DisplayMetrics();
        int height=dm.heightPixels;
        player2.setText(height+"");*/

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    player1.setHeight(player1.getHeight() + 50);
                    player2.setHeight(player2.getHeight() - 50);

                    player1.setText("");
                    player2.setText("");

                if(checkWinner(player2)){
                    player1.setEnabled(false);
                    player2.setEnabled(false);
                    player1.setText(player1.getText().toString()+" Won!!!");
                    player1.setTextSize(80);
                    player1.setTextColor(Color.WHITE);
                    score1=score1+1;
                    changePage(player1nam,player2nam,score1,score2);

                }

            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player2.setHeight(player2.getHeight() + 50);
                player1.setHeight(player1.getHeight() - 50);

                player2.setText("");
                player1.setText("");

                if(checkWinner(player1)){
                    player2.setEnabled(false);
                player1.setEnabled(false);
                player2.setText(player2.getText().toString()+" Won!!!");
                player2.setTextSize(80);
                score2=score2+1;
                player2.setTextColor(Color.WHITE);

                    changePage(player1nam,player2nam,score1,score2);

                //openDialog();
                }

            }
        });
    }

    public boolean checkWinner(Button a){
        boolean win=false;
         if(a.getHeight()<200){
            win=true;
        }
        return win;

    }
    public void changePage(String player1,String player2,int score1,int score2){
        Intent intent=new Intent(getApplicationContext(),FistScore.class);
        intent.putExtra("player1",player1);
        intent.putExtra("player2",player2);
        intent.putExtra("score1",score1);
        intent.putExtra("score2",score2);
        startActivity(intent);
    }
    //public void openDialog(){


   // }
}