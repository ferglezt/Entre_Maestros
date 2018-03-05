package com.testcomp.marango.elementia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class DownloadView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_view);

        ImageButton btnMenu = (ImageButton) findViewById(R.id.down_btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Menu_Home.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(intent);
                finish();
            }
        });

        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.downdloadView);

        int currentView = getIntent().getIntExtra("VIEW_DOWN",0);
        Log.i("value",currentView+"");

        viewFlipper.removeAllViews();
        View currentLayout;
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        switch (currentView){
            case 1:
                currentLayout = (View) inflater.inflate(R.layout.download_manuales,null);
                viewFlipper.addView(currentLayout);
                break;
            case 2:
                currentLayout = (View) inflater.inflate(R.layout.download_videos,null);
                viewFlipper.addView(currentLayout);
                break;
            case 3:
                currentLayout = (View) inflater.inflate(R.layout.download_tips,null);
                viewFlipper.addView(currentLayout);
                break;
            case 4:
                currentLayout = (View) inflater.inflate(R.layout.bank_dosif,null);
                viewFlipper.addView(currentLayout);
                break;
            default:

                break;
        }



    }
}
