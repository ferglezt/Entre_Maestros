package com.testcomp.marango.elementia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Jobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/flama_condensed_basic.otf")
                .setFontAttrId(R.attr.font)
                .build()
        );

        ImageButton btnMenu = (ImageButton) findViewById(R.id.jobs_btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView btnEdit =(ImageView)findViewById(R.id.job_btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonController(1);
            }
        });

        Button btnCatalogo = (Button) findViewById(R.id.job_btnCatalogo);
        Button btnNew = (Button) findViewById(R.id.job_btnNew);
        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonController(2);
            }
        });
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonController(3);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void ButtonController(int opc) {
        LinearLayout viewList = (LinearLayout) findViewById(R.id.viewJobs);
        ViewFlipper view = (ViewFlipper) findViewById(R.id.jobs_actions);
        viewList.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
        view.removeAllViews();
        View currentLayout;
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        switch (opc) {
            case 1:
                currentLayout = (View) inflater.inflate(R.layout.jobs_view_info, null);
                view.addView(currentLayout);
                break;
            case 2:
                currentLayout = (View) inflater.inflate(R.layout.jobs_catalogo, null);
                view.addView(currentLayout);
                break;
            case 3:
                currentLayout = (View) inflater.inflate(R.layout.jobs_new, null);
                view.addView(currentLayout);
                break;
            default:
                viewList.setVisibility(View.VISIBLE);
                view.setVisibility(View.GONE);
                break;

        }
    }
}
