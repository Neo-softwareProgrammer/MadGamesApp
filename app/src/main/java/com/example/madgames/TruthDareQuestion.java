package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class TruthDareQuestion extends AppCompatActivity {

    TextView statement;
    ImageButton done,notDone;
    int count,score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_dare_question);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        String statment=b.getString("statement");

        statement=findViewById(R.id.statement);
        statement.setText(statment);
        done=findViewById(R.id.doneIcon);
        notDone=findViewById(R.id.notDoneIcon);

        count=b.getInt("count");
        //score=b.getInt("score");



        ArrayList<truthPlayer> playerslist = (ArrayList<truthPlayer>) b.getSerializable("playerslist");
        score= playerslist.get(count).getScore();



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TruthGame.class);
                Bundle b=new Bundle();
               // intent.putExtra("score",score+30);

                playerslist.get(count).setScore(score+30);
                count++;
                if(count==playerslist.size()){
                    count=0;
                }
                intent.putExtra("count",count);
                b.putSerializable("playerslist", (Serializable) playerslist);
                intent.putExtras(b);

                startActivity(intent);
            }
        });
        notDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TruthGame.class);
                Bundle b=new Bundle();
                count++;
                if(count==playerslist.size()){
                    count=0;
                }
                intent.putExtra("count",count);
               // intent.putExtra("score",score);
                b.putSerializable("playerslist", (Serializable) playerslist);
                intent.putExtras(b);

                startActivity(intent);
            }
        });



    }

}