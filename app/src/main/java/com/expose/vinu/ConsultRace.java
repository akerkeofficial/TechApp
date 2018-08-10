package com.expose.vinu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class ConsultRace extends AppCompatActivity {
    private static Button button_sbm;
    TextView text_v,name,status;
    private static RatingBar rating_b;
    ImageView photo;
    public static String rating;
    EditText txvResult;
    public static String consult_answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consult_race);
        listenerForRatingBar();
        onButtonClickListener();
    }

    public void listenerForRatingBar(){
        rating_b = (RatingBar) findViewById(R.id.ratingBar);
        text_v = (TextView) findViewById(R.id.textView);
        name = (TextView) findViewById(R.id.name);
        status = (TextView) findViewById(R.id.second);
        txvResult = (EditText) findViewById(R.id.txvResult);

        name.setText(FoodList.name);
        status.setText(FoodList.price);

        FoodListAdapter.foodImage = FoodList.image;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bitmap = BitmapFactory.decodeByteArray(FoodListAdapter.foodImage, 0, FoodListAdapter.foodImage.length);
        photo.setImageBitmap(bitmap);

//        InputStream inputStream  = new ByteArrayInputStream(FoodList.image);
//        Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
//        photo.setImageBitmap(bitmap);

        rating_b.setOnRatingBarChangeListener(

                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                        text_v.setText(String.valueOf(rating));
                    }
                }
        );
    }
    public void onButtonClickListener(){
        rating_b = (RatingBar) findViewById(R.id.ratingBar);
        button_sbm = (Button) findViewById(R.id.button);

        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ConsultRace.this,
                                String.valueOf(rating_b.getRating()),
                                Toast.LENGTH_SHORT).show();
                        rating = String.valueOf(rating_b.getRating());
                        consult_answer = txvResult.getText().toString();
                        Log.d("HAI",rating+"   " + consult_answer);
                    }
                }
        );
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