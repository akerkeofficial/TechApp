package com.expose.vinu;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class FoodList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Food> list;
    FoodListAdapter adapter = null;
    Dialog myDialog;
    public static String name;
    public static String price;
    public static byte[] image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list_activity);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new FoodListAdapter(this, R.layout.food_items, list);
        gridView.setAdapter(adapter);
        myDialog = new Dialog(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent it = new Intent(FoodList.this,ConsultRace.class);
                startActivity(it);
                Log.d("HAI",name+price);
                Toast.makeText(FoodList.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        Gallery.sqLiteHelper = new SQLiteHelper(this, "FoodDB.sqlite", null, 1);

        // get all data from sqlite
        Cursor cursor = Gallery.sqLiteHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            name = cursor.getString(1);
            price = cursor.getString(2);
            image = cursor.getBlob(3);

            list.add(new Food(name, price, image, id));
        }
        adapter.notifyDataSetChanged();

    }
    public void next(View v) {
        Intent it = new Intent(FoodList.this,QuestionRus1.class);
        startActivity(it);
    }

}
