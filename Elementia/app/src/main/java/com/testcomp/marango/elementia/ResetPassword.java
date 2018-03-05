package com.testcomp.marango.elementia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ResetPassword extends AppCompatActivity {
    LinearLayout viewPass;
    LinearLayout viewPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        viewPass = (LinearLayout) findViewById(R.id.reset_viewPass);
        viewPop = (LinearLayout) findViewById(R.id.reset_viewSopport);
        viewPass.setVisibility(View.VISIBLE);
        viewPop.setVisibility(View.GONE);

        Button btnSend = (Button) findViewById(R.id.reset_send);
        Button btnCancel = (Button) findViewById(R.id.reset_cancel);
        TextView btnPopsoport = (TextView) findViewById(R.id.reset_show_pop);

        BtnSendEmail(btnSend);
        BtnCancel(btnCancel);
        ShowPop(btnPopsoport);

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

    private void BtnSendEmail(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPop.getVisibility() == View.GONE) {
                    Toast.makeText(getApplicationContext(), "Se ha enviado un email con tu password", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    private void BtnCancel(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPop.getVisibility() == View.GONE) {
                    finish();
                }
            }
        });
    }
    private void ShowPop(TextView btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPop.setVisibility(View.VISIBLE);
            }
        });

        Button btnClose = (Button) findViewById(R.id.reset_close_popup);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPop.setVisibility(View.GONE);
            }
        });
    }
}
