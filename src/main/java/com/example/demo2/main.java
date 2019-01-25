package com.example.demo2;

import com.example.demo2.controllersec.Result;
import com.example.demo2.tools.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class main {

   static public void main(String[] args) {
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
       params.add("timespan","1537343739326");
       params.add("encodedActivityId","0067d79b7a6c8664e9d4f75163a1da1b");
       params.add("phone","13656285402");
      HttpClient httpClient=new HttpClient();
        Result result=  httpClient.client("http://train.17usoft.net/trainoperationalactivity/redPackage/cooperation",HttpMethod.POST,params);
       System.out.println(result);

    }
}
