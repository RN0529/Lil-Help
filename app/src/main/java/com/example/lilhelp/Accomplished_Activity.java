package com.example.lilhelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class Accomplished_Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomplished_);
        Bundle b = getIntent().getExtras();
        JournalEntry je = (JournalEntry)  b.getSerializable(DataHandler.today);
        final EditText ans = (EditText) findViewById(R.id.aq_answer);
        if(je.getAq() != null)
        {
            String savedContent = je.getAq().getAnswer();
            ans.setText(savedContent);
        }
        Button homeButton = (Button) findViewById(R.id.accomplished_question_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        Button nextButton = (Button) findViewById(R.id.accomplished_forward_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JournalScreen.class);
                JournalEntry je = new JournalEntry();
                if(getIntent().getExtras() != null)
                {
                    je = (JournalEntry) getIntent().getExtras().getSerializable(DataHandler.today);
                }
                String content = ans.getText().toString();
                if(je.getAq() == null)
                {
                    AccomplishQuestion aq = new AccomplishQuestion();
                    aq.setAnswer(content);
                    je.setAq(aq);
                }
                else
                {
                    je.getAq().setAnswer(content);
                }
                Bundle b = new Bundle();
                b.putSerializable(DataHandler.today, (Serializable) je);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        Button backButton = (Button) findViewById(R.id.accomplished_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Grateful_Activity.class);
                JournalEntry je = new JournalEntry();
                if(getIntent().getExtras() != null)
                {
                    je = (JournalEntry) getIntent().getExtras().getSerializable(DataHandler.today);
                }
                String content = ans.getText().toString();
                if(je.getAq() == null)
                {
                    AccomplishQuestion aq = new AccomplishQuestion();
                    aq.setAnswer(content);
                    je.setAq(aq);
                }
                else
                {
                    je.getAq().setAnswer(content);
                }
                Bundle b = new Bundle();
                b.putSerializable(DataHandler.today, (Serializable) je);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
