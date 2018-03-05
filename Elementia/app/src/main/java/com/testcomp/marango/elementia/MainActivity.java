package com.testcomp.marango.elementia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/flama_condensed_basic.otf")
                .setFontAttrId(R.attr.font)
                .build()
        );

        Button btnSend = (Button) findViewById(R.id.log_btnIniciar);
        Button btnCreate = (Button) findViewById(R.id.log_btnCreate);
        TextView btnHelp = (TextView) findViewById(R.id.log_btnHelp);

        BtnCreate(btnCreate);
        BtnLogIn(btnSend);
        BtnHelp(btnHelp);


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void BtnLogIn(Button btn)
    {
        final EditText email = (EditText) findViewById(R.id.log_userName);
        //EditText pass = (EditText) findViewById(R.id.log_pass);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //new ConsulDataAccess().execute("http://localhost/entre_maestros/apilog/consulta.php?email="+email.getText());
                Log.i("peticion","http://localhost/entre_maestros/apilog/consulta.php?email="+email.getText()+"&action=access&id=null");
                Intent intent = new Intent(getApplicationContext(),Menu_Home.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void BtnCreate(Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),ResgistAccount.class);
                startActivity(intent);
                //finish();
            }
        });
    }

    private void BtnHelp(TextView btn)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),ResetPassword.class);
                startActivity(intent);
                //finish();
            }
        });
    }

    private class ConsulDataAccess extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {


            return strings[0];
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            EditText pass = (EditText) findViewById(R.id.log_pass);
            CheckBox remember = (CheckBox) findViewById(R.id.log_remember);
            String passConsult;
            String passInput = pass.getText().toString();

            JSONArray resultConsult = null;
            resultConsult = new JSONArray();

            try {
                passConsult = resultConsult.getString(1);
                if (passInput.equals(passConsult)){
                    DataManager.USER_ID = resultConsult.getInt(0);
                    Toast.makeText(getApplicationContext(),"Bienvenido "+ resultConsult.getString(2),Toast.LENGTH_SHORT).show();
                    if (remember.isChecked()){
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("id_user",DataManager.USER_ID);
                        editor.commit();
                    }
                    else {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("id_user",0);
                        editor.commit();
                    }
                    Intent intent = new Intent(getApplicationContext(),Menu_Home.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Correo o Contrasana incorrecto",Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Asegurate estar registrado o contacta a soporte",Toast.LENGTH_LONG).show();

            }
        }
    }
}
