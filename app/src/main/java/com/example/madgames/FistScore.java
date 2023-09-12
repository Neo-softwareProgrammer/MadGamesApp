package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FistScore extends AppCompatActivity {

    Button play,quit;
    TextView player1,player2,player1Score,player2Score;
    int totScore1,totScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist_score);


        Intent intent=getIntent();
        Bundle b= intent.getExtras();
        String p1=b.getString("player1").toString();
        String p2=b.getString("player2").toString();
        int score1=(int) b.getInt("score1");
        int score2=(int) b.getInt("score2");
        totScore1=score1;
        totScore2=score2;
        player1=(TextView) findViewById(R.id.player1n);
        player2=(TextView) findViewById(R.id.player2n);
        player1Score=findViewById(R.id.textView4);
        player2Score=findViewById(R.id.textView5);
        player1Score.setText(totScore1+"");
        player2Score.setText(totScore2+"");
        player1.setText(p1);
        player2.setText(p2);

        quit=(Button) findViewById(R.id.home);
        play=(Button) findViewById(R.id.playAgain);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),FistGame.class);
                i.putExtra("player1",p1);
                i.putExtra("player2",p2);
                i.putExtra("score1",score1);
                i.putExtra("score2",score2);
                startActivity(i);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}