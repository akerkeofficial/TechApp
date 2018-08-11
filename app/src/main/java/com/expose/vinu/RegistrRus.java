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


public class RegistrRus extends AppCompatActivity {
    private EditText name, phone;     //hit option + enter if you on mac , for windows hit ctrl + enter
    private Button add;

    FirebaseFirestore firestore;

    public static   String clientname = "";
    public static   String clientdata = "";
    String answer;

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
                String answer_status = "не оброботан";

                Map<String, String> userMap = new HashMap<>();

                userMap.put("name", client_name);
                userMap.put("phone", client_phone);
                userMap.put("identity", identity);
                clientdata = client_phone;
                clientname = client_name;

                firestore.collection("clients").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegistrRus.this, "Client Added Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrRus.this, QuestionRus1.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();

                        Toast.makeText(RegistrRus.this, "Error" + error, Toast.LENGTH_SHORT).show();
                    }
                });




                Log.d("HAI",QuestionRus1.answer);

                if (QuestionRus1.aa!=null) {
                    Log.d("HAI", client_name+client_phone+answer_status+answer+identity);
                     answer = QuestionRus1.aa;
                    Map<String, String> answerMap = new HashMap<>();

                    answerMap.put("name", client_name);
                    answerMap.put("data", client_phone);
                    answerMap.put("answer", answer);
                    answerMap.put("identity", identity);
                    answerMap.put("status", answer_status);

                    firestore.collection("aa").add(answerMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(RegistrRus.this, "Added Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrRus.this, Language.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String error = e.getMessage();

                            Toast.makeText(RegistrRus.this, "Error" + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if (QuestionRus1.bb!=null) {
                    Log.d("HAI", "First");
                    answer = QuestionRus1.bb;
                    Map<String, String> answerMap = new HashMap<>();

                    answerMap.put("name", client_name);
                    answerMap.put("data", client_phone);
                    answerMap.put("answer", answer);
                    answerMap.put("identity", identity);
                    answerMap.put("status", answer_status);

                    firestore.collection("bb").add(answerMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(RegistrRus.this, "Added Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrRus.this, Language.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String error = e.getMessage();

                            Toast.makeText(RegistrRus.this, "Error" + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if (QuestionRus1.cc!=null) {
                    Log.d("HAI", "First");
                    answer = QuestionRus1.cc;
                    Map<String, String> answerMap = new HashMap<>();

                    answerMap.put("name", client_name);
                    answerMap.put("data", client_phone);
                    answerMap.put("answer", answer);
                    answerMap.put("identity", identity);
                    answerMap.put("status", answer_status);

                    firestore.collection("cc").add(answerMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(RegistrRus.this, "Added Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrRus.this, Language.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String error = e.getMessage();

                            Toast.makeText(RegistrRus.this, "Error" + error, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else if (QuestionRus1.dd!=null) {
                    Log.d("HAI", "First");
                    answer = QuestionRus1.dd;
                    Map<String, String> answerMap = new HashMap<>();

                    answerMap.put("name", client_name);
                    answerMap.put("data", client_phone);
                    answerMap.put("answer", answer);
                    answerMap.put("identity", identity);
                    answerMap.put("status", answer_status);

                    firestore.collection("dd").add(answerMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(RegistrRus.this, "Added Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrRus.this, Language.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String error = e.getMessage();

                            Toast.makeText(RegistrRus.this, "Error" + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }



                String consult_name = ConsultRace.consult_name;
                String consult_status = ConsultRace.consult_status;
                String consult_rating = ConsultRace.consult_rating;
                String consult_feedback = ConsultRace.consult_feedback;


                Map<String, String> consult = new HashMap<>();

                consult.put("name", consult_name);
                consult.put("status", consult_status);
                consult.put("rating", consult_rating);
                consult.put("feedback", consult_feedback);

                firestore.collection("консультанты отзыв").add(consult).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegistrRus.this, "Added Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrRus.this, Language.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();

                        Toast.makeText(RegistrRus.this, "Error" + error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}

