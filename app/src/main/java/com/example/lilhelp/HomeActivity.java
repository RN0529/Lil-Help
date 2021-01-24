package com.example.lilhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button cogButton,infoButton,JournToday, hisjournal, help;
    TextView cogText, JourText, hisText, helpText, desc, infoText;
    RelativeLayout relLay;
    Boolean isClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        isClicked =false;
        cogButton = findViewById(R.id.cogButton);
        infoButton = findViewById(R.id.informationButton);
        JournToday = findViewById(R.id.journalToday);
        hisjournal = findViewById(R.id.previousJournals);
        help = findViewById(R.id.HELP);
        cogText = findViewById(R.id.cogtext);
        JourText = findViewById(R.id.journaltext);
        hisText = findViewById(R.id.histext);
        helpText = findViewById(R.id.helptext);
        desc = findViewById(R.id.descrip);
        relLay = findViewById(R.id.layout);
        infoText= findViewById(R.id.info);

        desc.setVisibility(View.INVISIBLE);
        helpText.setVisibility(View.INVISIBLE);
        hisText.setVisibility(View.INVISIBLE);
        JourText.setVisibility(View.INVISIBLE);
        cogText.setVisibility(View.INVISIBLE);


        //Setting click for help button
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, HelpResources.class));
            }
        });
    }

    public void onClick(View view){
        if(view == infoButton){
            if(isClicked==false){
                relLay.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                desc.setVisibility(View.VISIBLE);
                helpText.setVisibility(View.VISIBLE);
                hisText.setVisibility(View.VISIBLE);
                JourText.setVisibility(View.VISIBLE);
                cogText.setVisibility(View.VISIBLE);
                isClicked=true;
            }
            else{
                relLay.setBackgroundColor(getResources().getColor(android.R.color.white));
                desc.setVisibility(View.INVISIBLE);
                helpText.setVisibility(View.INVISIBLE);
                hisText.setVisibility(View.INVISIBLE);
                JourText.setVisibility(View.INVISIBLE);
                cogText.setVisibility(View.INVISIBLE);
                isClicked=false;

            }


        }
    }
}