package com.andre.mytraining.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
Button trainingloginforweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trainingloginforweb =(Button)findViewById(R.id.buttonlatihan1);
        trainingloginforweb.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent training1=new Intent(this,LoginForWeb.class);
        startActivity(training1);
    }
}
