package com.example.madgames;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyViewHolder> {

    Context context;
    List<GameData> gamesList;

    public GamesAdapter(Context context, List<GameData> gamesList) {
        this.context = context;
        this.gamesList = gamesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemblock,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.image.setImageResource(gamesList.get(position).getImage());
        holder.name.setText(gamesList.get(position).getName());
        int num=position;
        holder.layout.setOnClickListener(new View.OnClickListener() {

           @Override
            public void onClick(View view) {

               Intent intent=null;
               if(num==0){
                   intent=new Intent(context,TicTacToe.class);

               } else if (num==1) {
                   intent=new Intent(context,TrueOrDare.class);
               }else {
                   intent=new Intent(context,FistFingers.class);
               }

               context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            layout=itemView.findViewById(R.id.layout);
        }
    }
}
