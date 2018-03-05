package com.testcomp.marango.elementia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class ResgistAccount extends AppCompatActivity {

    private User user;
    private int currentView = 0;

    private Spinner spinner_contry;
    private Spinner spinner_state;
    private Spinner spinner_colonia;
    private Spinner spinner_oficio;
    private String certifications;

    private EditText name;
    private EditText firstname;
    private EditText lastname;
    private EditText email;
    private EditText phone;
    private TextView birth;
    private EditText postal;
    private EditText exp;
    private EditText oficio;
    private CheckBox check_TyC;

    /*private CheckBox check_albanil;
    private CheckBox check_elec;
    private CheckBox check_plomero;
    private CheckBox check_other;
    private CheckBox check_insta;
    private CheckBox check_dist;
    private CheckBox check_sub;*/


    private String country_selection;
    private String state_selection;
    private String suburb_selection;
    private MyDate myDate = new MyDate();

    private String[] oficios = new String[]{"Albañil","Electricista","Plomero","Instalador","Distribuidor","Subdistribuidor","Otro"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgist_account);

        ImageButton btnMenu = (ImageButton) findViewById(R.id.regis_btn_menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Menu_Home.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        valueView();
    }

    //Metodo para controlar la accion del boton anterior
    private void Click_btnBack(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView --;
                if (currentView==0){
                    valueView();
                }
                else if (currentView==1){
                    valueView();
                }
                else if (currentView==2){
                    valueView();
                }
                else {
                    finish();
                }
            }
        });
    }

    //Metodo para controlar la accion del boton siguiente
    private void Click_btnNext(Button btn, final int action){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView ++;
                if (currentView==0){
                    valueView();
                }
                else if (currentView==1){
                    valueView();
                }
                else if (currentView==2){
                    valueView();
                }
                else {
                    //finish();
                }
                switch (action){
                    case 0:
                        DataManager.USER_DATA = new User(
                                ""+name.getText(),
                                ""+firstname.getText(),
                                ""+lastname.getText(),
                                ""+email.getText()
                        );
                        break;
                    case 1:
                        DataManager.USER_DATA.setPhone(phone.getText().toString());
                        DataManager.USER_DATA.setBirth(birth.getText().toString());
                        DataManager.USER_DATA.setCountry(country_selection);
                        DataManager.USER_DATA.setState(state_selection);
                        DataManager.USER_DATA.setColonia(suburb_selection);
                        DataManager.USER_DATA.setCp(postal.getText().toString());
                        break;
                    case 2:
                        DataManager.USER_DATA.setOficio(spinner_oficio.getSelectedItem().toString());
                        int expValue;
                        try{
                            expValue = Integer.valueOf(exp.getText().toString());
                        }catch (Exception e){
                            expValue = 0;
                        }

                        DataManager.USER_DATA.setExp(expValue);
                        if (check_TyC.isChecked()){
                            DataManager.InsertDataBase();
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Debes Acpetar los Terminos y condiciones para continuar",Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    //Metodo para evaluar la view activa y controlar las acciones segun sea el caso
    private void valueView(){
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.registContent);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View layoutCurrent;
        flipper.removeAllViews();

        switch(currentView){
            case 0:
                layoutCurrent = (View) inflater.inflate(R.layout.account_info_user, null);
                flipper.addView(layoutCurrent);

                viewInfo();
                break;
            case 1:
                layoutCurrent = (View) inflater.inflate(R.layout.account_info_personal, null);
                flipper.addView(layoutCurrent);
                viewPersonal();
                break;
            case 2:
                layoutCurrent = (View) inflater.inflate(R.layout.account_info_profesional, null);
                flipper.addView(layoutCurrent);
                viewProf();
                break;
        }
    }

    private void viewInfo(){
        //Button btnBack = (Button) findViewById(R.id.account_btn_info_cancel);
        Button btnNext = (Button) findViewById(R.id.account_btn_info_next);

        //Click_btnBack(btnBack);
        Click_btnNext(btnNext,0);

        name = (EditText) findViewById(R.id.account_name);
        firstname = (EditText) findViewById(R.id.account_lastname1);
        lastname = (EditText) findViewById(R.id.account_lastname2);
        email = (EditText) findViewById(R.id.account_email);
        birth = (TextView) findViewById(R.id.account_birth);
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopDate();
            }
        });


    }
    private void viewPersonal(){
        phone = (EditText) findViewById(R.id.account_phone);
        postal = (EditText) findViewById(R.id.account_cp);

        //Button btnBack = (Button) findViewById(R.id.account_btn_personal_cancel);
        Button btnNext = (Button) findViewById(R.id.account_btn_personal_next);
        //Click_btnBack(btnBack);
        Click_btnNext(btnNext,1);



        spinner_contry =(Spinner) findViewById(R.id.spinner_country);
        spinner_contry.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getCountries()));
        final int[] country_position = new int[1];
        spinner_state = (Spinner)findViewById(R.id.spinner_state);
        spinner_state.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getState(0,"Mexico")));
        spinner_colonia = (Spinner)findViewById(R.id.spinner_colonia);
        spinner_colonia.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getColonia(0,"CDMX")));

        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country_position[0] = position;
                country_selection = parent.getItemAtPosition(position).toString();
                spinner_colonia.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                                            R.layout.support_simple_spinner_dropdown_item,
                                            getColonia(country_position[0],country_selection)
                                            ));
                //spinnerController(spinner_state);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    private void viewProf(){
        spinner_oficio = (Spinner) findViewById(R.id.spinner_oficio);
        exp = (EditText) findViewById(R.id.account_exp);
        check_TyC = (CheckBox) findViewById(R.id.account_accep_terms);

        spinner_oficio.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,oficios));

        //Button btnBack = (Button) findViewById(R.id.account_btn_prof_back);
        Button btnNext = (Button) findViewById(R.id.account_btn_prof_save);

        //Click_btnBack(btnBack);
        Click_btnNext(btnNext,2);

        Button btnAdd = (Button) findViewById(R.id.account_btn_prof_add);
        final EditText certificacion = (EditText) findViewById(R.id.account_certif);
        final TextView showCertificacion = (TextView) findViewById(R.id.account_prof_content_certif);
        certifications = "";

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCert = certificacion.getText().toString();
                //DataManager.USER_DATA.addCertificacion(newCert);
                certifications += certificacion.getText()+"\n";
                showCertificacion.setText(certifications);
                certificacion.setText(null);

            }
        });

    }

    private String[] getCountries(){
        String[] countries = {"Mexico"};

        return countries;
    }

    private String[] getState(int positionSelected, String nameSelected){
        String[] states = {"CDMX","EdoMex","Michoacan","Guanajuato"};

        return states;
    }
    private String[] getColonia(int positionSelected, String nameSelected){
        String[] col_cdmx = {"Santa Fe","Coyoacan","Roma","Condesa"};
        String[] col_edomex = {"Ecatepec","Neza","Satelite","Toluca"};
        String[] col_mich = {"Morelia","Lazaro cardenas","Patzcuaro","Quiroga"};
        String[] col_gto = {"Leon","Irapuato","Silao","Celaya"};

        String[] col_current = new String[]{};

        switch (positionSelected){
            case 0:
                col_current = col_cdmx;
                break;
            case 1:
                col_current = col_edomex;
                break;
            case 2:
                col_current = col_mich;
                break;
            case 3:
                col_current = col_gto;
                break;
            default:
                break;
        }

        return col_current;
    }

    private void spinnerController(final Spinner spinner, final char value){
        final String[] selected = new String[1];
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected[0] = parent.getItemAtPosition(position).toString();
                if(value =='y'){
                    myDate.setYear(selected[0]);
                }
                else if(value =='m'){
                    myDate.setMonth(selected[0]);
                }
                else if(value =='d'){
                    myDate.setDay(selected[0]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void ShowPopDate(){
        final LinearLayout viewInfo = (LinearLayout) findViewById(R.id.account_viewInfo);
        final LinearLayout viewDate = (LinearLayout) findViewById(R.id.account_viewDate);
        final LinearLayout backPop = (LinearLayout) findViewById(R.id.popBackground);

        viewDate.setVisibility(View.VISIBLE);
        viewInfo.setVisibility(View.GONE);
        backPop.setVisibility(View.VISIBLE);

        final Spinner year = (Spinner)findViewById(R.id.spinner_year);
        Spinner month = (Spinner) findViewById(R.id.spinner_month);
        Spinner day = (Spinner) findViewById(R.id.spinner_day);

        ArrayList<String> yearList = new ArrayList<String>();
        Calendar currentDate = new GregorianCalendar(Locale.getDefault());
        yearList = myDate.GetYears(1900, Calendar.getInstance().get(Calendar.YEAR));
        year.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,yearList));
        ArrayList<String> monthList = new ArrayList<>();
        monthList = myDate.getMonthList();
        month.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,monthList));
        ArrayList<String> dayList = new ArrayList<>();
        dayList  = myDate.GetDays();

        day.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,dayList));
        spinnerController(year,'y');
        spinnerController(month,'m');
        spinnerController(day,'d');


        Button btnClose = findViewById(R.id.date_close_popup);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birth.setText(myDate.getDay() + " "+ myDate.getMonth() +" " + myDate.getYear());
                viewDate.setVisibility(View.GONE);
                backPop.setVisibility(View.GONE);
                viewInfo.setVisibility(View.VISIBLE);
            }
        });

    }




}
