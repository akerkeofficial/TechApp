package com.expose.vinu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener{
    FirebaseFirestore db;
    public TextView textUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        textUser = (TextView)findViewById(R.id.textUser) ;


        db = FirebaseFirestore.getInstance();

        textUser.setText(MainActivity.IDENTITIES );
        Button admin = (Button)findViewById(R.id.admin);
        admin.setOnClickListener(this);
        Button user = (Button)findViewById(R.id.user);
        user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.admin: {
                startActivity(new Intent(this, AdminActivity.class));
                break;
            }

            case R.id.user: {
                startActivity(new Intent(this, Language.class));
                break;
            }
        }
    }
}
