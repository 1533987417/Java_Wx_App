package com.example.demo2.controllersec;

import com.example.demo2.entitysec.BindRes;
import com.example.demo2.entitysec.Bindwxinfo;


import com.example.demo2.entitysec.User;
import com.example.demo2.entitysec.UserRes;
import com.example.demo2.tools.HttpClient;

import com.example.demo2.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserControllerSec {
    @Autowired
    private UserRes userRes;

//引入JTW过滤器

    @Autowired
    private BindRes bindRes;
    //@Autowired
    //@Qualifier("entityManagerSecondary")
    //private EntityManager entityManager;
    @GetMapping("/getGetResearch")
    public HashMap<Key, Object> getGetResearch(@RequestParam("gzh")Long gzh){
        HashMap<Key,Object> map=new HashMap<Key,Object>();
        ;
        map.put(new Key("lunwen"),userRes.getGetResearch(gzh));
        map.put(new Key("zhuzuo"),userRes.getZhuzuo(gzh));
        map.put(new Key("zongxiang"),userRes.getzongxiang(gzh));
        map.put(new Key("hengxiang"),userRes.gethengxiang(gzh));
        map.put(new Key("zhuanli"),userRes.getzhuanli(gzh));
        map.put(new Key("rjzz"),userRes.getrjzz(gzh));
        map.put(new Key("dongwu"),userRes.getdongwu(gzh));
        map.put(new Key("zhiwu"),userRes.getzhiwu(gzh));
        map.put(new Key("zhiwuzq"),userRes.getzhiwupz(gzh));
        map.put(new Key("reward"),userRes.getReward(gzh));
        map.put(new Key("standard"),userRes.getstandard(gzh));
        map.put(new Key("other"),userRes.getother(gzh));
        return map;

    }


    @GetMapping("/bind")
    public HashMap<String, Object> login(@RequestParam("gzh")Long gzh, @RequestParam("password")String password, @RequestParam("code")String code){

        User user=userRes.verify(gzh,gzh,password);
        HashMap<String,Object> map=new HashMap<String,Object>();

        if(user==null){
            System.out.println("用户不存在");
            map.put("status",false);
            map.put("msg","用户名密码不匹配");
           // map.put("token",null);
            return map;

        }else{

            Result result= this.bindinfo(code);
            // list.add(0,token);

            Bindwxinfo bindwxinfo=new Bindwxinfo();
            bindwxinfo.setOpenid(result.getOpenid());
            bindwxinfo.setGzh(gzh);
            bindRes.save(bindwxinfo);
            String jwt=JwtUtil.generateToken(result.getOpenid());

            System.out.println("正确");
            map.put("status",true);
            map.put("data",user);
            map.put("token",jwt);

           /* return new BaseResponse(true,"绑定成功",list);*/
           return map;
        }

    }


    public Result bindinfo(String code){
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("appid","wx3937b53d0b422834");
        params.add("secret","b44c9818d0635235fec4f5afc84134d8");
        params.add("js_code",code);
        params.add("grant_type","authorization_code");
        HttpClient httpClient=new HttpClient();
        Result result= httpClient.client("https://api.weixin.qq.com/sns/jscode2session", HttpMethod.POST,params);
        System.out.println(result.getOpenid());
        return result;



    }
    //通过微信登陆工号
    @GetMapping("/loginbywx")
    public HashMap<String, Object> loginbywx(@RequestParam("code")String code){
        //System.out.println(code);
        Result result=this.bindinfo(code);
        result.getOpenid();
        Bindwxinfo result1 = bindRes.findBindwxinfoByOpenid(result.getOpenid());
        String token=JwtUtil.generateToken(result.getOpenid());
        HashMap<String,Object> map=new HashMap<String,Object>();
        User user=userRes.query(result1.getGzh(),result1.getGzh());
        map.put("data",user);
        map.put("token",token);
        return map;
    }
    @GetMapping("/getzhuzuo")
    public List getzhuzuo(@RequestParam("gzh")Long gzh){
       return userRes.getZhuzuo(gzh);
    }
    static class Key {
        private String key;

        public Key(String key) {
            this.key = key;
        }


        @Override
        public boolean equals(Object obj) {

            if (obj instanceof Key)
                return key.equals(((Key) obj).key);
            else
                return false;

        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }


}
