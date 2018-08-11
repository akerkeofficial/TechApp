package com.expose.vinu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegistrKaz extends AppCompatActivity {
    private EditText name, phone;     //hit option + enter if you on mac , for windows hit ctrl + enter
    private Button add;

    private FirebaseFirestore firestore;

    public static   String clientname = "";
    public static   String clientdata = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr_rus);
        //Get Firebase auth instance
        firestore = FirebaseFirestore.getInstance();

        add = (Button) findViewById(R.id.add);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String client_name = name.getText().toString();
                String client_phone = phone.getText().toString();
                String identity = MainActivity.identity;

                Map<String, String> userMap = new HashMap<>();

                userMap.put("name", client_name);
                userMap.put("phone", client_phone);
                userMap.put("identity", identity);
                clientdata = client_phone;
                clientname = client_name;

                firestore.collection("clients").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegistrKaz.this, "Client Added Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrKaz.this, QuestionRus1.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();

                        Toast.makeText(RegistrKaz.this, "Error" + error, Toast.LENGTH_SHORT).show();
                    }
                });



                String answer = QuestionRus1.answer;
                Log.d("HAI",QuestionRus1.answer);



                Map<String, String> answerMap = new HashMap<>();

                answerMap.put("name", client_name);
                answerMap.put("data", client_phone);
                answerMap.put("answer", answer);
                answerMap.put("identity", identity);

                firestore.collection("answers").add(answerMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegistrKaz.this, "Added Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrKaz.this, Language.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();

                        Toast.makeText(RegistrKaz.this, "Error" + error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}

