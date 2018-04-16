package com.qihui.mailwish.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qihui.mailwish.model.WetherRO;
import com.qihui.mailwish.service.GetWeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * create by chenqihui on 2018/4/5
 */
@Service
public class GetWeatherServiceImpl implements GetWeatherService {
    @Value("${wether.host}")
    private String host;
    @Value("${wether.appcode}")
    private String appCode;


    @Override
    public WetherRO getWether() {
        String path = "/weather/query";
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("city", "杭州");
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = host + path + "?city={city}";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "APPCODE " + appCode);
            HttpEntity entity = new HttpEntity(headers);
            ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, querys);
            JSONObject jsonObject = JSONObject.parseObject(result.getBody());
            WetherRO wetherRO = jsonObject.getObject("result", WetherRO.class);
            return wetherRO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
