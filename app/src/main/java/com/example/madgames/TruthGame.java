package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class TruthGame  extends AppCompatActivity {

    TextView truthPlayers,score;

    Button truthButton,dareButton,randomButton;
    String name;
    int count,scoreNum;
    ArrayList<truthPlayer> playerslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_game);
        truthButton=findViewById(R.id.truthButton);
        dareButton=findViewById(R.id.dareButton);
        randomButton=findViewById(R.id.randomButton);
        truthPlayers=findViewById(R.id.truthPlayer);
        score=findViewById(R.id.truthScore);


        Intent intent=getIntent();
        Bundle b=intent.getExtras();

        count=intent.getIntExtra("count",0);
        String names="";

        playerslist = (ArrayList<truthPlayer>) b.getSerializable("playerslist");

            name= playerslist.get(count).getName().toString();
           scoreNum=playerslist.get(count).getScore();
       // scoreNum=b.getInt("score",0);
        playerslist.get(count).setScore(scoreNum);


        if (scoreNum<1){
            score.setTextColor(Color.parseColor("#00000000"));
        }else{
            score.setTextColor(Color.WHITE);
        }
        score.setText(scoreNum+"".toString());
        truthPlayers.setText(name.toString());

    }

    public void showStament(View view){

        Intent intent=new Intent(this,TruthDareQuestion.class);
        intent.putExtra("statement",name+ " call out "+playerslist.get(1).getName()+"'s name 10 times");
       // intent.putExtra("score",scoreNum);
        intent.putExtra("count",count);
        Bundle b=new Bundle();
        b.putSerializable("playerslist", (Serializable) playerslist);
        intent.putExtras(b);
        startActivity(intent);

    }
}