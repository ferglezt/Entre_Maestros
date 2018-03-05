package com.testcomp.marango.elementia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Menu_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__home);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/flama_condensed_basic.otf")
                .setFontAttrId(R.attr.font)
                .build()
        );



        //Control  menu's buttons
        Button btnProfile = (Button) findViewById(R.id.home_btn_porfile);
        Button btnResource = (Button) findViewById(R.id.home_btn_resources);
        Button btnJobs = (Button) findViewById(R.id.home_btn_jobs);
        Button btnBuy = (Button) findViewById(R.id.home_btn_buy);
        Button btnChamba = (Button) findViewById(R.id.home_btn_chamba);
        Button btnEvent = (Button) findViewById(R.id.home_btn_events);
        Button btnHelp = (Button) findViewById(R.id.home_btn_ehelp);
        Button btnLogin = (Button) findViewById(R.id.home_btn_login);


        ButtonController(btnProfile,0);
        ButtonController(btnResource,1);
        ButtonController(btnJobs,2);
        ButtonController(btnBuy,3);
        ButtonController(btnChamba,4);
        ButtonController(btnEvent,5);
        ButtonController(btnHelp,6);
        ButtonController(btnLogin,7);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    //cotrol of onclick and action of menu's buttons
    private void ButtonController(final Button btn, final int opc){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btn.setAlpha(1);
                switch (opc){
                    case 0:
                        intent = new Intent(getApplicationContext(),MyProfile.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(),Resources.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(),Jobs.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(),Buys.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(),Chamba.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(),Events.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 6:
                        intent = new Intent(getApplicationContext(),Help.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    case 7:
                        intent = new Intent(getApplicationContext(),MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                    default:
                        intent = new Intent(getApplicationContext(),Menu_Home.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                        break;
                }
                startActivity(intent);
                //finish();
            }
        });
    }
}
