package com.testcomp.marango.elementia;

import java.util.ArrayList;

/**
 * Created by @daniH_VR on 2/16/2018.
 */

public class User {
    private  String name;
    private  String first_name;
    private  String last_name;
    private  String email;
    private  String phone;
    private  String birth;
    private  String country;
    private  String state;
    private  String colonia;
    private  String cp;
    private  String oficio;
    private  int exp;
    private  ArrayList<String> certificaciones;
    private  boolean aceptoTuC;


    public User(String name, String first_name, String last_name, String email) {
        this.name = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        //oficios = new ArrayList<String>();
        certificaciones = new ArrayList<String>();
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
/*
    public ArrayList<String> getOficios() {
        return oficios;
    }

    public void setOficios(ArrayList<String> oficios) {
        this.oficios = oficios;
    }
*/
    public ArrayList<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(ArrayList<String> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public boolean isAceptoTuC() {
        return aceptoTuC;
    }

    public void setAceptoTuC(boolean aceptoTuC) {
        this.aceptoTuC = aceptoTuC;
    }

    /*public void addOficio(String newOficio ){
        this.oficios.add(newOficio);
    }*/
    public void addCertificacion(String newCertificacion ){
        this.certificaciones.add(newCertificacion);
    }

    public void SaveOnDataBase(){
        //metodo para guardar mi objeto usuario en la base de datos
        /*
            TODO CODE Here
        */
    }
}
