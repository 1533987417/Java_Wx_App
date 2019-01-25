package com.example.demo2.tools;

import com.example.demo2.controllersec.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class HttpClient {
    public Result client(String url, HttpMethod method, MultiValueMap<String, String> params){
        RestTemplate client = new RestTemplate();
        client.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<Result> response = client.exchange(url, HttpMethod.POST, requestEntity, Result.class);
        return response.getBody();
    }
}