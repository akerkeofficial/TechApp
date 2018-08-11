package com.expose.vinu;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;



public class QuestionKaz1 extends AppCompatActivity {

    EditText txvResult;
    private Button next;
    public static String answer = "";
    private FirebaseFirestore firestore;
    public static CheckBox a, b, c, d;
    View.OnClickListener checkBoxListener;
    public static String aa,bb,cc,dd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_kaz_1);

        firestore = FirebaseFirestore.getInstance();
        a = (CheckBox) findViewById(R.id.a);
        b = (CheckBox) findViewById(R.id.b);
        c = (CheckBox) findViewById(R.id.c);
        d = (CheckBox) findViewById(R.id.d);
        txvResult = (EditText) findViewById(R.id.txvResult);

        checkBoxListener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvResult = (EditText) findViewById(R.id.txvResult);
                txvResult.setText("I Like ");

                switch(v.getId()) {

                    case R.id.a:
                        txvResult.setText(txvResult.getText().toString()+" "+ a.getText().toString());
                        aa = txvResult.getText().toString();
                        b.setChecked(false);
                        c.setChecked(false);
                        d.setChecked(false);


                        break;

                    case R.id.b:
                        txvResult.setText(txvResult.getText().toString()+" "+ b.getText().toString());
                        bb = txvResult.getText().toString();
                        a.setChecked(false);
                        c.setChecked(false);
                        d.setChecked(false);

                        break;

                    case R.id.c:
                        txvResult.setText(txvResult.getText().toString()+" "+ c.getText().toString());
                        cc = txvResult.getText().toString();
                        b.setChecked(false);
                        a.setChecked(false);
                        d.setChecked(false);

                        break;

                    case R.id.d:
                        txvResult.setText(txvResult.getText().toString()+" "+ d.getText().toString());
                        dd = txvResult.getText().toString();
                        b.setChecked(false);
                        c.setChecked(false);
                        a.setChecked(false);

                        break;
                }
//            if(a.isChecked()) {
//                txvResult.setText(txvResult.getText().toString()+" "+ a.getText().toString());
//                b.setChecked(false);
//                c.setChecked(false);
//                d.setChecked(false);
//            }
//
//            if(b.isChecked()) {
//                txvResult.setText(txvResult.getText().toString()+ " "+b.getText().toString());
//                c.setChecked(false);
//                a.setChecked(false);
//                d.setChecked(false);
//            }
//            if(c.isChecked()) {
//                txvResult.setText(txvResult.getText().toString()+" "+ c.getText().toString());
//                b.setChecked(false);
//                a.setChecked(false);
//                d.setChecked(false);
//
//            }
//
//            if(d.isChecked()) {
//                txvResult.setText(txvResult.getText().toString()+ " "+d.getText().toString());
//                b.setChecked(false);
//                a.setChecked(false);
//                c.setChecked(false);
//            }


            }
        };
        a.setOnClickListener(checkBoxListener);
        b.setOnClickListener(checkBoxListener);
        c.setOnClickListener(checkBoxListener);
        d.setOnClickListener(checkBoxListener);
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
                finish();
            }
        });
    }

}





