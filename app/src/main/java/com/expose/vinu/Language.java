package com.expose.vinu;

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
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class Language extends AppCompatActivity implements View.OnClickListener{
    public TextView shop_user;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        db = FirebaseFirestore.getInstance();

        Button russian = (Button)findViewById(R.id.russian);
        russian.setOnClickListener(this);
        Button kazakh = (Button)findViewById(R.id.kazakh);
        kazakh.setOnClickListener(this);

         shop_user = (TextView)findViewById(R.id.user_shop);
        shop_user.setText(MainActivity.USER);
        shop_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Language.this,AdminActivity.class);
                startActivity(it);
            }
        });
        Log.d("good", MainActivity.USER);
        Toolbar toolbar =findViewById(R.id.toolbar);
        getSupportActionBar().hide();



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.russian: {
                startActivity(new Intent(this, FoodList.class));
                break;
            }

            case R.id.kazakh: {
                startActivity(new Intent(this, QuestionKaz1.class));
                break;
            }
        }
    }
}