package com.expose.vinu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.android.gms.tasks.OnSuccessListener;
public class Camera extends AppCompatActivity {
    private Button mupload;
    private ImageView img;
    private static final int CAMERA_REQUEST_CODE = 1;
    private StorageReference mStorage;

    private ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStorage= FirebaseStorage.getInstance().getReference();

        mProgress=new ProgressDialog(this);
        mupload = (Button) findViewById(R.id.button3);
        img=(ImageView) findViewById(R.id.imageView);
        mupload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK & requestCode == CAMERA_REQUEST_CODE) {
            mProgress.setMessage("Uploading mage...");
            mProgress.show();
            Uri uri = data.getData();
            StorageReference filepath=mStorage.child("Photos").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mProgress.dismiss();
                    Uri downloadUri=taskSnapshot.getDownloadUrl();
                    Toast.makeText(Camera.this,"Uploading an image finished",Toast.LENGTH_LONG).show();
                }
            });

        }
    }
    //how to make it motherfucking???????????
}