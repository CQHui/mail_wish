package com.qihui.mailwish.model;

import java.io.Serializable;

/**
 * create by chenqihui on 2018/4/5
 */
public class WetherRO implements Serializable {
    private static final long serialVersionUID = 2965940022168657703L;
    private String city;
    private String date;
    private String weather;
    private String temphigh;
    private String templow;
    private AQIRO apiRO;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemphigh() {
        return temphigh;
    }

    public void setTemphigh(String temphigh) {
        this.temphigh = temphigh;
    }

    public String getTemplow() {
        return templow;
    }

    public void setTemplow(String templow) {
        this.templow = templow;
    }

    public AQIRO getApiRO() {
        return apiRO;
    }

    public void setApiRO(AQIRO apiRO) {
        this.apiRO = apiRO;
    }
}
