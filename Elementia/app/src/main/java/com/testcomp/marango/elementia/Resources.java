package com.testcomp.marango.elementia;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Resources extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        ImageButton btnMenu = (ImageButton) findViewById(R.id.resources_btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Control  menu's buttons
        Button btnCotizador = (Button) findViewById(R.id.resour_btn_cotizador);
        Button btnManuales = (Button) findViewById(R.id.resour_btn_manuales);
        Button btnVideos = (Button) findViewById(R.id.resour_btn_videos);
        Button btnTips = (Button) findViewById(R.id.resour_btn_tips);
        Button btnDosifi = (Button) findViewById(R.id.resour_btn_dosificador);


        ButtonController(btnCotizador,0);
        ButtonController(btnManuales,1);
        ButtonController(btnVideos,2);
        ButtonController(btnTips,3);
        ButtonController(btnDosifi,4);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/flama_condensed_basic.otf")
                .setFontAttrId(R.attr.font)
                .build()
        );

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private void ButtonController(final Button btn, final int opc){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btn.setAlpha(1);
                switch (opc){
                    case 0:
                        intent = new Intent(getApplicationContext(),Cotizador.class);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(),DownloadView.class);
                        intent.putExtra("VIEW_DOWN",1);

                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(),DownloadView.class);
                        intent.putExtra("VIEW_DOWN",2);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(),DownloadView.class);
                        intent.putExtra("VIEW_DOWN",3);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(),DownloadView.class);
                        intent.putExtra("VIEW_DOWN",4);
                        break;
                    default:
                        intent = new Intent(getApplicationContext(),Menu_Home.class);
                        break;
                }
                startActivity(intent);
                //finish();
            }
        });
    }
}
