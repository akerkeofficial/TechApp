package com.expose.vinu;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class QuestionKaz1 extends AppCompatActivity {

    EditText txvResult;
    private Button next;
    public static String answer = "";
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_kaz_1);

        firestore = FirebaseFirestore.getInstance();

        txvResult = (EditText) findViewById(R.id.txvResult);
        next = (Button)findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String name = RegistrRus.clientname;
//                String data = RegistrRus.clientdata;
//                String answer = txvResult.getText().toString();
//                String identity = MainActivity.IDENTITIES;
//
//
//                Map<String, String> userMap = new HashMap<>();
//
//                userMap.put("name", name);
//                userMap.put("data", data);
//                userMap.put("answer", answer);
//                userMap.put("identity", identity);
//
//                firestore.collection("answers").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(QuestionRus1.this, "Added Successfull", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(QuestionRus1.this, QuestionRus1.class));
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        String error = e.getMessage();
//
//                        Toast.makeText(QuestionRus1.this, "Error" + error, Toast.LENGTH_SHORT).show();
//                    }
//                });
                answer = txvResult.getText().toString();
                Log.d("HAI",answer);
                Intent it = new Intent(QuestionKaz1.this,RegistrRus.class);
                startActivity(it);
            }
        });
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                }
                break;
        }
    }



}

