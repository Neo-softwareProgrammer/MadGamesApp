package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<GameData> gameList;

    RecyclerView recyclerView;
    GamesAdapter adapter;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        layout=findViewById(R.id.con);

        //layout.setBackgroundColor(Color.BLACK);
        recyclerView.setBackgroundColor(Color.WHITE);


        gameList=new ArrayList<>();
        gameList.add(new GameData(R.drawable.tac,"Tic Tac Toe"));
        gameList.add(new GameData(R.drawable.truth,"Truth or Dare"));
        gameList.add(new GameData(R.drawable.fingers,"Fist Fingers"));
        adapter=new GamesAdapter(this,gameList) ;

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
       // recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);


    }
}