package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseManager myDm;
    private ArrayList<CateInfo> cateList=new ArrayList<CateInfo>();
    String input;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        input = getIntent().getStringExtra("hints");
        myDm = new DatabaseManager(this);
        myDm.open();

        getCateInfo(input);

        CateAdapter adapter = new CateAdapter(SearchResultActivity.this, R.layout.catesubcontent,cateList);
        ListView listView=(ListView)findViewById(R.id.searchlistview);
        listView.setAdapter(adapter);

        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(SearchResultActivity.this,CateInfoDetailActivity.class);
                CateInfo cate = (CateInfo) adapter.getItem(position);
                myIntent.putExtra("title",cate.getTitle());
                myIntent.putExtra("category", cate.getCategery());
                startActivity(myIntent);
            }
        });

    }
    private void initView() {
        //initilization view
        Button go_back = findViewById(R.id.back);
        go_back.setOnClickListener(this);
    }
    private void getCateInfo(String input){
        cateList = myDm.searchCateInfo(input);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
