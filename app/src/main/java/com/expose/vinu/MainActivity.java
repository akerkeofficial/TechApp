package com.expose.vinu;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.expose.vinu.custom_font.MyEditText;
import com.expose.vinu.custom_font.MyTextView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;


public class MainActivity extends AppCompatActivity
         {

    FirebaseFirestore db;

    MyTextView getstarted;
    MyEditText username,password;



    public static  final  String COLLECTION_NAME_KEY = "USERS";

    public static   String IDENTITIES = "";
    public static  String USER = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        db = FirebaseFirestore.getInstance();

        getstarted = findViewById(R.id.getstarted);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);



        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!username.getText().toString().equals("") && !password.getText().toString().equals(""))
                {


                    DocumentReference docRef = db.collection(COLLECTION_NAME_KEY).document(username.getText().toString());
                    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if (documentSnapshot.exists())
                            {


                                Users user = documentSnapshot.toObject(Users.class);

                                if (user.getPassword().equals(password.getText().toString()))
                                {

                                    Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_SHORT).show();
                                    Log.d("HAI", user.getName().toString()+ " => " + user.getPassword().toString() + " => " + user.getIdentity().toString());
                                    IDENTITIES = user.getIdentity();
                                    USER = user.getName();
                                    Log.d("HAI", IDENTITIES+USER);
                                    Intent it = new Intent(MainActivity.this,Gallery.class);
                                    startActivity(it);
                                }

                                else
                                {
                                    Toast.makeText(MainActivity.this, "Passsword Mismatching", Toast.LENGTH_SHORT).show();
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


                    Toast.makeText(MainActivity.this, "Username or Password Cannot be Empty", Toast.LENGTH_SHORT).show();
                }






            }
        });



    }


}
