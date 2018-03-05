package com.testcomp.marango.elementia;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Daniel Hernandez on 2/21/2018.
 */

public class DataManager extends Application{
    public static User USER_DATA;
    public static int USER_ID;


    public static User ConsultUserDataBase(int id){
        User result;
        //new CreateUser().execute("http://localhost/entre_maestros/apilog/consulta.php?act=info&id="+id);
        return null;
    }

    public static void InsertDataBase(){

        String urlQuery = "http://localhost/entre_maestros/apilog/registro.php?act=n_user&eml="+USER_DATA.getEmail()+
                "&lnm="+USER_DATA.getFirst_name()+
                "&fnm="+USER_DATA.getLast_name()+
                "&nm="+USER_DATA.getName()+
                "&ph="+USER_DATA.getPhone()+
                "&dt="+USER_DATA.getBirth()+
                "&cnty="+USER_DATA.getCountry()+"&st="+USER_DATA.getState()+"&sbrb="+USER_DATA.getColonia()+
                "&pt="+USER_DATA.getCp()+"&nof="+USER_DATA.getOficio()+"&xp="+USER_DATA.getExp();
        urlQuery = urlQuery.replace(" ","%20");

        Log.i("urlQuery",urlQuery);

        String urlQueryCertif;
        for (int i = 0; i<USER_DATA.getCertificaciones().size(); i++){

        }
        //new CreateUser().execute(urlQuery);
    }

    private static class CreateUser extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {


            return strings[0];
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //Toast.makeText(getApplicationContext(),"Usuario Creado",Toast.LENGTH_SHORT);
        }
    }
}
