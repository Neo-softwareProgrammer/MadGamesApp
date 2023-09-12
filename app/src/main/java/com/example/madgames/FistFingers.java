package com.example.madgames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FistFingers extends AppCompatActivity {

    Button button;
    TextView title,enterPlayer;
    ImageView gameImage;
    EditText player1,player2;
    CheckBox checkButton;
    RadioButton button1,button2;
    RadioGroup radioGroup;
    int score1=0;
    int score2=0;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist_fingers);


        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);

        player1.setTextColor(ContextCompat.getColor(this,R.color.black));
        player2.setBackgroundColor(Color.YELLOW);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences = getSharedPreferences("player",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();


            editor.putString("name1",player1.getText().toString());
            editor.putString("name2",player2.getText().toString());


                //editor.putString("status",button1.getText().toString());

                //editor.putString("status",button2.getText().toString());


            editor.apply();


    }

    @Override
    protected void onStart() {
        sharedPreferences=getSharedPreferences("player",MODE_PRIVATE);
       player1.setText( sharedPreferences.getString("name1",""));
       player2.setText(sharedPreferences.getString("name2",""));

        super.onStart();
    }

    public void nextPage(View v){
        if(!player1.getText().toString().isEmpty() ){
            Intent intent=new Intent(this,FistGame.class);
            intent.putExtra("player1",player1.getText());
            intent.putExtra("player2",player2.getText());
            intent.putExtra("score1",score1);
            intent.putExtra("score2",score2);
            getApplicationContext().startActivity(intent);
        }else {
            if (TextUtils.isEmpty(player1.getText().toString())) {
                player1.setError("field cannot be empty");
            }
            if (TextUtils.isEmpty(player2.getText().toString())) {
                player2.setError("field cannot be empty");
            }
        }
}
}