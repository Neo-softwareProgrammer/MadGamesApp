package com.example.madgames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicGame extends AppCompatActivity {

    TextView player1Name,player2Name,player1Score,player2Score,scoreTitle;

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,quitButton,playAgainButton;
    Button[] buttons;
    private static int[] id={R.id.button01,R.id.button02,R.id.button03,R.id.button04,R.id.button05,R.id.button06,R.id.button07,R.id.button08,R.id.button09};
    int totP,num,scorePlayer1,scorePlayer2;
    int colorPlaying;
    String player,message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_game);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        colorPlaying=Color.YELLOW;
        player1Name=findViewById(R.id.player1Name);
        player2Name=findViewById(R.id.player2Name);
        player1Name.setText((String)b.get("player1").toString());
        player2Name.setText((String)b.get("player2").toString());
        player1Name.setTextColor(colorPlaying);
        scoreTitle=findViewById(R.id.score);
        player1Score=findViewById(R.id.textView9);
        player2Score=findViewById(R.id.textView10);
        quitButton=findViewById(R.id.quitButton);
        playAgainButton=findViewById(R.id.nextGameButton);


        player2Score.setTextColor(Color.BLACK);
        player1Score.setTextColor(Color.BLACK);
        scoreTitle.setTextColor(Color.BLACK);

        button1=findViewById(R.id.button01);
        button2=findViewById(R.id.button02);
        button3=findViewById(R.id.button03);
        button4=findViewById(R.id.button04);
        button5=findViewById(R.id.button05);
        button6=findViewById(R.id.button06);
        button7=findViewById(R.id.button07);
        button8=findViewById(R.id.button08);
        button9=findViewById(R.id.button09);


       // button1.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
      //  button2.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
      //  button3.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
      //  button4.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
     //   button5.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
      //  button6.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
      //  button7.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
     //   button8.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
       // button9.setBackgroundColor(ContextCompat.getColor(this,R.color.charcoal));
        playAgainButton.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));
        quitButton.setBackgroundColor(Color.RED);


        num=1;
        totP=1;
        scorePlayer1=0;
        scorePlayer2=0;
        buttons=new Button[]{button1,button2,button3,button4,button5,button4,button6,button7,button8,button9};


        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.truthItem){
            startActivity(new Intent(this,TrueOrDare.class));
        }

        return super.onOptionsItemSelected(item);

    }

    public void pressedButton(View v){


        num=num+1;


            player = "X";
            Button button = (Button) v;
            v.setBackgroundColor(Color.WHITE);

            if (num % 2 == 0) {

                button.setText(player);
                button.setTextColor(Color.RED);
                player2Name.setTextColor(colorPlaying);
                player1Name.setTextColor(Color.WHITE);
                 if(Check(player)){
                     scorePlayer1=scorePlayer1+1;
                     player1Score.setText(""+scorePlayer1);
                     player1Score.setTextColor(Color.WHITE);
                     player2Score.setTextColor(Color.WHITE);
                     scoreTitle.setTextColor(Color.WHITE);
                     changeColor(player);
                     playAgainButton.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
                     Toast.makeText(this, player1Name.getText().toString()+" Won !!!", Toast.LENGTH_SHORT).show();
                     for (int a=0 ;a< 9 ;a++){
                         buttons[a]=(Button) findViewById(id[a]);
                         buttons[a].setEnabled(false);
                     }
                 }


            } else {
                player = "O";
                button.setText(player);
                button.setTextColor(Color.BLUE);
                player1Name.setTextColor(colorPlaying);
                player2Name.setTextColor(Color.WHITE);
                if(Check(player)){
                    scorePlayer2=scorePlayer2+1;
                    player2Score.setText(""+scorePlayer2);
                    player1Score.setTextColor(Color.WHITE);
                    player2Score.setTextColor(Color.WHITE);
                    scoreTitle.setTextColor(Color.WHITE);
                    changeColor(player);
                    playAgainButton.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
                    Toast.makeText(this, player2Name.getText().toString()+" Won !!!", Toast.LENGTH_SHORT).show();
                    for (int a=0 ;a< 9 ;a++){
                        buttons[a]=(Button) findViewById(id[a]);
                        buttons[a].setEnabled(false);
                    }

                }

            }

            button.setEnabled(false);
         if(totP==9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
             player1Score.setTextColor(Color.WHITE);
             player2Score.setTextColor(Color.WHITE);
             scoreTitle.setTextColor(Color.WHITE);
            playAgainButton.setBackgroundColor(ContextCompat.getColor(this,R.color.green));


        }
        totP=totP+1;

    }


    public void nextGame(View v){

        if(totP>=9||Check(player)){
            for (int a=0 ;a< 9 ;a++){
                buttons[a]=(Button) findViewById(id[a]);
                buttons[a].setEnabled(true);
                buttons[a].setText("");
                buttons[a].setBackground(getDrawable(R.drawable.ticbutton));
                totP=1;
                playAgainButton.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));

            }
        }else{
            Toast.makeText(this, "Finish current Game first", Toast.LENGTH_SHORT).show();
        }

    }


    public boolean Check(String player){
        /*winning combination
        * b1,b2,b3::b4,b5,b6::b7,b8,b9
        * b1,b5,b9::b3,b5,b7::
        * b1,b4,b7::b2,b5,b8::b3,b6,b9*/
        boolean winning1=false;
        if(     button1.getText().toString().equals(button2.getText().toString())&&button2.getText().toString().equals(button3.getText().toString())&&button1.getText().toString().equals(player)||
                button4.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button6.getText().toString())&&button4.getText().toString().equals(player)||
                button7.getText().toString().equals(button8.getText().toString())&&button8.getText().toString().equals(button9.getText().toString())&&button7.getText().toString().equals(player)||
                button1.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button9.getText().toString())&&button1.getText().toString().equals(player)||
                button3.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button7.getText().toString())&&button3.getText().toString().equals(player)||
                button1.getText().toString().equals(button4.getText().toString())&&button4.getText().toString().equals(button7.getText().toString())&&button1.getText().toString().equals(player)||
                button3.getText().toString().equals(button6.getText().toString())&&button6.getText().toString().equals(button9.getText().toString())&&button3.getText().toString().equals(player)||
                button2.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button8.getText().toString())&&button2.getText().toString().equals(player)

        )
        {
             winning1=true;
        }
             return winning1;
    }

    public void changeColor(String player){
        if( button1.getText().toString().equals(button2.getText().toString())&&button2.getText().toString().equals(button3.getText().toString())&&button1.getText().toString().equals(player)){
            button1.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button2.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button3.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        } else if ( button4.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button6.getText().toString())&&button4.getText().toString().equals(player)) {
            button4.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button5.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button6.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else if (button7.getText().toString().equals(button8.getText().toString())&&button8.getText().toString().equals(button9.getText().toString())&&button7.getText().toString().equals(player)) {
            button7.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button8.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button9.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else if ( button1.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button9.getText().toString())&&button1.getText().toString().equals(player)) {
            button1.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button5.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button9.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else if ( button3.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button7.getText().toString())&&button3.getText().toString().equals(player)) {
            button3.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button5.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button7.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else if ( button1.getText().toString().equals(button4.getText().toString())&&button4.getText().toString().equals(button7.getText().toString())&&button1.getText().toString().equals(player)) {
            button1.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button4.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button7.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else if ( button3.getText().toString().equals(button6.getText().toString())&&button6.getText().toString().equals(button9.getText().toString())&&button3.getText().toString().equals(player)) {
            button3.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button6.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button9.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else if ( button2.getText().toString().equals(button5.getText().toString())&&button5.getText().toString().equals(button8.getText().toString())&&button2.getText().toString().equals(player)) {
            button2.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button5.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            button8.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }

    }

}