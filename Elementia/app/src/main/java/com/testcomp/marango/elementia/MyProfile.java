package com.testcomp.marango.elementia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyProfile extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/flama_condensed_basic.otf")
                .setFontAttrId(R.attr.font)
                .build()
        );

        Button btnSave = (Button) findViewById(R.id.profile_btn_save);
        ImageButton btnMenu = (ImageButton) findViewById(R.id.profile_btn_menu);

        if(DataManager.USER_DATA != null){
            LoadDataUser();
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadDataUser();
                Intent intent = new Intent(getApplicationContext(),Menu_Home.class);
                startActivity(intent);
                finish();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Menu_Home.class);
                startActivity(intent);
                finish();
            }
        });


        final LinearLayout popEdit = (LinearLayout) findViewById(R.id.profile_viewPopEdit);
        final LinearLayout profileView = (LinearLayout) findViewById(R.id.profile_viewAll);

        final ImageButton btnName = (ImageButton) findViewById(R.id.profile_btn_editName);
        final TextView editName = (TextView) findViewById(R.id.profile_viewfullname);
        try {
            editName.setText(DataManager.USER_DATA.getName()
                    +" " + DataManager.USER_DATA.getFirst_name()
                    + " " +DataManager.USER_DATA.getLast_name());
        }
        catch (Exception e){

        }

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popEdit.setVisibility(View.VISIBLE);
                profileView.setEnabled(false);

                Button btnOK = (Button) findViewById(R.id.profile_edit_ready);
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popEdit.setVisibility(View.GONE);
                        profileView.setEnabled(true);
                    }
                });

            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void LoadDataUser(){
       /* EditText name = (EditText) findViewById(R.id.profile_name);
        EditText firstname = (EditText) findViewById(R.id.profile_ape_paterno);
        EditText lastname = (EditText) findViewById(R.id.profile_ape_materno);
        EditText email = (EditText) findViewById(R.id.profile_email);
        EditText phone = (EditText) findViewById(R.id.profile_phone);

        name.setText(DataManager.USER_DATA.getName());
        firstname.setText(DataManager.USER_DATA.getFirst_name());
        lastname.setText(DataManager.USER_DATA.getLast_name());
        email.setText(DataManager.USER_DATA.getEmail());
        phone.setText(DataManager.USER_DATA.getPhone());*/
    }

    private void UploadDataUser(){/*
        EditText name = (EditText) findViewById(R.id.profile_name);
        EditText firstname = (EditText) findViewById(R.id.profile_ape_paterno);
        EditText lastname = (EditText) findViewById(R.id.profile_ape_materno);
        EditText email = (EditText) findViewById(R.id.profile_email);
        EditText phone = (EditText) findViewById(R.id.profile_phone);

        DataManager.USER_DATA.setName(name.getText().toString());
        DataManager.USER_DATA.setFirst_name(firstname.getText().toString());
        DataManager.USER_DATA.setLast_name(lastname.getText().toString());
        DataManager.USER_DATA.setEmail(email.getText().toString());
        DataManager.USER_DATA.setPhone(phone.getText().toString());*/
    }
}
