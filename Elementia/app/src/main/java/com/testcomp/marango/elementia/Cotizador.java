package com.testcomp.marango.elementia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Cotizador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizador);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/flama_condensed_basic.otf")
                .setFontAttrId(R.attr.font)
                .build()
        );

        ImageButton btnMenu = (ImageButton) findViewById(R.id.coti_btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Menu_Home.class);
                startActivity(intent);
                finish();
            }
        });

        Button newCoti = (Button) findViewById(R.id.coti_btn_new);
        Button prevCoti = (Button) findViewById(R.id.coti_btn_prev);

        ButtonOnclickOpc(newCoti,0);
        ButtonOnclickOpc(prevCoti,1);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void ButtonOnclickOpc(Button btn, final int opc){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout viewOpc = (LinearLayout) findViewById(R.id.coti_viewOptions);
                ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewEdit);
                viewOpc.setVisibility(View.GONE);
                viewFlipper.setVisibility(View.VISIBLE);
                if (opc == 0) {
                    NewCotiController(viewFlipper,1);
                }
                else {
                    PrevCotiController(viewFlipper);
                }
            }
        });
    }

    private void NewCotiController(final ViewFlipper view, final int currentView){
        view.removeAllViews();
        View currentLayout;
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        switch (currentView){
            case 1:
                currentLayout = (View) inflater.inflate(R.layout.coti_new_cliente,null);
                view.addView(currentLayout);
                break;
            case 2:
                currentLayout = (View) inflater.inflate(R.layout.coti_new_cliente_trabajador,null);
                view.addView(currentLayout);
                break;
            case 3:
                currentLayout = (View) inflater.inflate(R.layout.coti_new_cliente_material,null);
                view.addView(currentLayout);
                break;
            case 4:
                currentLayout = (View) inflater.inflate(R.layout.coti_new_cliente_costos,null);
                view.addView(currentLayout);
                break;
            case 5:
                currentLayout = (View) inflater.inflate(R.layout.coti_new_result,null);
                view.addView(currentLayout);
                break;
            case 6:
                currentLayout = (View) inflater.inflate(R.layout.coti_result,null);
                view.addView(currentLayout);
                break;
            default:
                LinearLayout viewOpc = (LinearLayout) findViewById(R.id.coti_viewOptions);
                ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewEdit);
                viewOpc.setVisibility(View.VISIBLE);
                viewFlipper.setVisibility(View.GONE);
                break;
        }
        final ViewFlipper newView = view;
        final int[] current = {currentView};
        if (currentView > 1 && currentView < 5){
            Button btnBack = (Button) findViewById(R.id.coti_btnBack);
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current[0]--;
                    NewCotiController(newView,current[0]);
                }
            });
        }
        if (currentView >= 1 && currentView < 5) {
            Button btnNext = (Button) findViewById(R.id.coti_btnNext);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current[0]++;
                    NewCotiController(newView, current[0]);
                }
            });
        }

        if (currentView == 5){
            Button btnLook = (Button) findViewById(R.id.coti_btn_ver);
            btnLook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current[0]++;
                    NewCotiController(view,current[0]);
                }
            });
        }

        if (currentView == 6){
                Button btnBack = (Button) findViewById(R.id.coti_btnBack);
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        current[0]--;
                        NewCotiController(newView,current[0]);
                    }
                });

                Button btnNext = (Button) findViewById(R.id.coti_btnNext);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        current[0]++;
                        NewCotiController(newView, current[0]);
                    }
                });
        }

    }

    private void PrevCotiController(final ViewFlipper view){
        view.removeAllViews();
        View currentLayout;
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        currentLayout = (View) inflater.inflate(R.layout.coti_previas,null);
        view.addView(currentLayout);

        ImageButton btn = (ImageButton) findViewById(R.id.coti_btn_editCoti);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewCotiController(view,6);
            }
        });
    }


}
