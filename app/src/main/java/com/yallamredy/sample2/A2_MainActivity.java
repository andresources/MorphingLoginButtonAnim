package com.yallamredy.sample2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yallamredy.R;

public class A2_MainActivity extends AppCompatActivity implements
        View.OnClickListener, MyLoadingButton.MyLoadingButtonClick{

    MyLoadingButton myLoadingButton;

    Button normalButton, errorButton, loadingButton, doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_main);

        myLoadingButton = findViewById(R.id.my_loading_button);
        myLoadingButton.setMyButtonClickListener(this);

        normalButton = findViewById(R.id.normal_btn);
        errorButton = findViewById(R.id.error_btn);
        loadingButton = findViewById(R.id.loading_btn);
        doneButton = findViewById(R.id.done_btn);

        normalButton.setOnClickListener(this);
        errorButton.setOnClickListener(this);
        loadingButton.setOnClickListener(this);
        doneButton.setOnClickListener(this);

        setLoadingButtonStyle();

    }

    /**
     * Customise MyLoadingButton
     */
    private void setLoadingButtonStyle(){

        myLoadingButton.setAnimationDuration(1000)
                .setButtonColor(R.color.colorAccent)
                .setButtonLabel("Login")
                .setButtonLabelSize(20)
                .setProgressLoaderColor(Color.WHITE)
                .setButtonLabelColor(R.color.white);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){

            case R.id.normal_btn:

                myLoadingButton.showNormalButton();

                break;

            case R.id.loading_btn:

                myLoadingButton.showLoadingButton();

                break;

            case R.id.done_btn:

                myLoadingButton.showDoneButton();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // add your code here
                        RevealAnimUtil.starttActivityWithSceneTransitionAnimation(A2_MainActivity.this,myLoadingButton,A2_NewActivity.class);
                        //startActivity(new Intent(getApplicationContext(),A2_NewActivity.class));
                    }
                }, 500);


                break;

            case R.id.error_btn:

                myLoadingButton.showErrorButton();

                break;

        }

    }

    @Override
    public void onMyLoadingButtonClick() {
        Toast.makeText(this, "MyLoadingButton Click", Toast.LENGTH_SHORT).show();
    }
}