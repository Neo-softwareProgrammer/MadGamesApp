package com.example.madgames;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrueOrDare extends AppCompatActivity {

    Button addPlayer,play,remove;
    AlertDialog dialog;
    TextView title,enterPlayer;
    ImageView gameImage;
    EditText player1,player2;
    ConstraintLayout layout;
    LinearLayout linearLayout;
    List<truthPlayer> playerlist;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_or_dare);
        addPlayer =findViewById(R.id.addPlayer);
        play= findViewById(R.id.darePlayButton);
        play.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        linearLayout=findViewById(R.id.scrollLayout);
        playerlist=new ArrayList<>();



        buildDialog();

        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playerlist.size()<2){
                    Toast.makeText(TrueOrDare.this, "Not Enough Players", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent =new Intent(getApplicationContext(),TruthGame.class);
                    Bundle b=new Bundle();
                    b.putSerializable("playerslist", (Serializable) playerlist);
                    intent.putExtra("count",0);
                    intent.putExtras(b);
                   // intent.putSe( "playerslist", (ArrayList<truthPlayer>) playerlist);
                    startActivity(intent);
                }
            }
        });


    }

    private void buildDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view =getLayoutInflater().inflate(R.layout.dialogbox,null);

        EditText playerName= view.findViewById(R.id.playerNameEdit);


        builder.setView(view);
        builder.setTitle("Enter name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!playerName.getText().toString().isEmpty()){
                        addCard(playerName.getText().toString());
                        playerlist.add(new truthPlayer(playerName.getText().toString()+"",0));}
                        else{
                            errorMsg(playerName);
                        }
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        dialog=builder.create();
        errorMsg(playerName);


    }

    private void addCard(String playerName) {
        View view=getLayoutInflater().inflate(R.layout.card,null);

        TextView name=view.findViewById(R.id.nameText);
        Button delete=view.findViewById(R.id.deleteButton);
        //delete.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
        name.setTextColor(ContextCompat.getColor(this,R.color.azureblue));
        name.setText(playerName.toString());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int j=0; j<playerlist.size(); j++)
                    if(playerName.equalsIgnoreCase(playerlist.get(j).getName().toString())){
                        playerlist.remove(j);
                    }
                linearLayout.removeView(view);

            }
        });
        linearLayout.addView(view);
    }

    public void errorMsg(View v){

        EditText edit = (EditText) v;
            if(TextUtils.isEmpty(edit.getText().toString())){
                edit.setError("field cannot be empty");
            }


    }
}