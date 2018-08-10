package com.expose.vinu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.expose.vinu.custom_font.MyEditText;
import com.expose.vinu.custom_font.MyTextView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminActivity extends AppCompatActivity{


    FirebaseFirestore db;

    Button btn_login;
    EditText admin,password;



    public static  final  String COLLECTION_NAME_KEY = "USERS";

    public static   String IDENTITIES = "";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



        db = FirebaseFirestore.getInstance();

        btn_login = findViewById(R.id.btn_login);

        admin = findViewById(R.id.admin);
        password = findViewById(R.id.password);















        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!admin.getText().toString().equals("") && !password.getText().toString().equals(""))
                {

                    DocumentReference docRef = db.collection(COLLECTION_NAME_KEY).document();
                    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if (documentSnapshot.exists())
                            {


                                Users user = documentSnapshot.toObject(Users.class);

                                if (user.getPassword().equals(password.getText().toString()))
                                {

                                    Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_SHORT).show();
                                    Log.d("HAI", user.getAdmin().toString()+ " => " + user.getPassword().toString() + " => " + user.getIdentity().toString());
                                    IDENTITIES = user.getIdentity();
                                    Log.d("HAI", IDENTITIES);
                                    Intent it = new Intent(AdminActivity.this,ScrollingActivity.class);
                                    startActivity(it);
                                }

                                else
                                {
                                    Toast.makeText(AdminActivity.this, "Passsword Mismatching", Toast.LENGTH_SHORT).show();
                                }





                            }

                            else
                            {

                                Toast.makeText(getApplicationContext(), "Check your Username ", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }

                else

                {


                    Toast.makeText(AdminActivity.this, "Username or Password Cannot be Empty", Toast.LENGTH_SHORT).show();
                }






            }
        });



    }


}

