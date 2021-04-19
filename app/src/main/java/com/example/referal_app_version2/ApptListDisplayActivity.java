package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ApptListDisplayActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseManager myDm;
    private String email;
    public static ArrayList<Appointment> apptList=new ArrayList<Appointment>();
    public static ApptAdapter adapter;



    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_appointment);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);


        myDm = new DatabaseManager(this);
        myDm.open();

        email = myDm.getEmail();

        getAppt(email);

        adapter = new ApptAdapter(ApptListDisplayActivity.this, R.layout.apptsubcontent,apptList);


        ListView listView=(ListView)findViewById(R.id.appt_list);

        listView.setAdapter(adapter);

        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(ApptListDisplayActivity.this, ApptDetialDisplayActivity.class);
                Appointment appt = (Appointment) adapter.getItem(position);
                myIntent.putExtra("title",appt.getTitle());
                myIntent.putExtra("user_email",email);
                startActivity(myIntent);
            }
        });

    }

    private void getAppt(String email){
        apptList = myDm.getAppt(email);
    }

    private void initView() {
        //initilization view
        Button add_new = findViewById(R.id.bt_add);
        add_new.setOnClickListener(this);

        Button btn_barHome_a = findViewById(R.id.barMain);
        Button btn_barProfile_a = findViewById(R.id.barProfile);
        Button btn_barCategory_a = findViewById(R.id.barCate);
        btn_barProfile_a.setOnClickListener(this);
        btn_barCategory_a.setOnClickListener(this);
        btn_barHome_a.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                Intent intent_plan = new Intent(ApptListDisplayActivity.this, NewAppointmentActivity.class);
                intent_plan.putExtra("user_email",email);
                startActivity(intent_plan);
                break;
            case R.id.barCate:
                Intent cat2Intent = new Intent(ApptListDisplayActivity.this, CategeryActivity.class);//跳转到注册界面
                cat2Intent.putExtra("user_email",email);//跳转到注册界面
                startActivity(cat2Intent);
                finish();
                break;

            case R.id.barProfile:
                Intent profile2Intent = new Intent(ApptListDisplayActivity.this, ProfileActivity.class);
                profile2Intent.putExtra("user_email",email);
                startActivity(profile2Intent);
                finish();
                break;

            case R.id.barMain:
                Intent main2Intent = new Intent(ApptListDisplayActivity.this, HomePageActivity.class);//跳转到注册界面
                main2Intent.putExtra("user_email",email);
                startActivity(main2Intent);
                finish();
                break;
        }

    }
}
