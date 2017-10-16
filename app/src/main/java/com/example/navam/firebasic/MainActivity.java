package com.example.navam.firebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference myDatabase;
    int use = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        final Button myButton = (Button) findViewById(R.id.storeButton);
        final TextView title = (TextView) findViewById(R.id.myText);
        final TextView stored = (TextView) findViewById(R.id.myText2);
        final TextView displayStored = (TextView) findViewById(R.id.myText3);
        final EditText typeIn = (EditText) findViewById(R.id.myTextBox);
        myDatabase = FirebaseDatabase.getInstance().getReference();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inBox = typeIn.getText().toString();
                displayStored.setText(inBox);
                typeIn.setText("");
                typeIn.setHint("Type Here");
                // create child in root database and assign value to child
                myDatabase.child("Text" + use).setValue(inBox);
                use++;

            }
        });
    }
}
