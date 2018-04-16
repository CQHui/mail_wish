package com.qihui.mailwish.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qihui.mailwish.service.MorningSentenceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * create by chenqihui on 2018/4/9
 */
@Service
public class MorningSentenceImpl implements MorningSentenceService {

    @Value("${jinshan.host}")
    private String host;
    @Override
    public String getMorningSentence() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(host, String.class);
        JSONObject jsonResult = JSON.parseObject(result.getBody(), JSONObject.class);
        return jsonResult.getString("content");
    }
}
