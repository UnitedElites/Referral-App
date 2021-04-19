package com.example.referal_app_version2;

import android.app.DatePickerDialog;
import android.graphics.Matrix;
import android.icu.util.Calendar;
import android.text.InputType;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import android.widget.ImageView;

import androidx.core.content.FileProvider;

import java.io.File;



public class NewAppointmentActivity extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog dpd;
    private DatabaseManager myDm;
    private EditText DOD,title, day_time,appt_detail;
    private String email;

    public static final int TAKE_PHOTO = 1;
    private Button mTakePhoto;
    private ImageView picture;
    private Uri imageUri;
    private String ipath;
    File outputImage;
    String filename = "output_image";

    int i = 1;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_appointment);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        mTakePhoto = (Button) findViewById(R.id.showbigimage);

        picture = (ImageView) findViewById(R.id.showImage);

        email = getIntent().getStringExtra("user_email");
        myDm = new DatabaseManager(this);
        myDm.open();


        initView();


        mTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                outputImage = new File(getExternalCacheDir(), filename+".jpg");
                while(outputImage.exists()) {
                    outputImage = new File(getExternalCacheDir(), filename + i+".jpg");
                    i++;
                }
                try {
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                imageUri = FileProvider.getUriForFile(NewAppointmentActivity.this,
                            "com.example.referal_app_version2.fileprovider", outputImage);


                //Open Camera activity
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });

        //set calendar
        DOD.setInputType(InputType.TYPE_NULL);
        DOD.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Calendar ca = Calendar.getInstance();
                int day = ca.get(Calendar.DAY_OF_MONTH);
                int month = ca.get(Calendar.MONTH);
                int year = ca.get(Calendar.YEAR);

                dpd = new DatePickerDialog(NewAppointmentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        DOD.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                dpd.show();
            }
        });

    }


    private void initView() {
        //initilization view
        DOD = findViewById(R.id.dateEdit);
        appt_detail = findViewById(R.id.detailEdit);
        day_time = findViewById(R.id.DtimeEdit);
        title = findViewById(R.id.titleEdit);
        Button addnew = findViewById(R.id.aptButton);
        addnew.setOnClickListener(this);
        Button go_back = findViewById(R.id.back);
        go_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.aptButton:

                String apt_title = title.getText().toString().trim();
                String appoint_date = DOD.getText().toString().trim();
                String appoint_detail = appt_detail.getText().toString().trim();
                String day_time_temp = day_time.getText().toString().trim();
                //registration check
                if (!TextUtils.isEmpty(apt_title) && !TextUtils.isEmpty(appoint_date) && !TextUtils.isEmpty(appoint_detail) && !TextUtils.isEmpty(day_time_temp)) {
                    boolean flag = false;
                    ArrayList<Appointment> data = myDm.getAppt(email);
                    for (int i = 0; i < data.size(); i++) {
                        Appointment appt = data.get(i);
                        if ((apt_title.equals(appt.getTitle()) )) {
                            flag = true;
                        }
                    }

                    if(flag == false){
                        myDm.add_2(email,apt_title,appoint_date, day_time_temp, appoint_detail,ipath);
                        if(ApptListDisplayActivity.adapter!= null) {
                            ApptListDisplayActivity.apptList.clear();
                            ApptListDisplayActivity.apptList.addAll(myDm.getAppt(email));
                            ApptListDisplayActivity.adapter.notifyDataSetChanged();
                        }
                        finish();
                    }else{
                        Toast.makeText(this, "Title already Exists", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bm = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        bm = rotateImage(bm,90);
                        picture.setImageBitmap(bm);
                        ipath = outputImage.getPath();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                break;

            default:
                break;
        }
    }

    public Bitmap rotateImage(Bitmap bitmap, float degree) {
        //create new matrix
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return bmp;
    }
}




