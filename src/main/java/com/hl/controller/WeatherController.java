package com.hl.controller;

import com.hl.util.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
/*
请不要尝试init和change方法，因为请求的key绑定了我的服务器API
你需要自己注册一个和风天气控制台的账号，创建一个key，并且在MyConfig里替换上你的key
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private RestTemplate restTemplate;
    private String baseUrl= MyConfig.BASEURL;
    private String key= MyConfig.KEY;

    @GetMapping(value = "/init")
    @ResponseBody
    public String init(){
        String url = baseUrl+"location="+MyConfig.DEFAULT_LOCATION+"&key="+key;
        ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class);
        String json=entity.getBody();
        return json;
    }
    @GetMapping(value = "/change")
    @ResponseBody
    public String change(@RequestParam String location){
        String url = baseUrl+"location="+location+"&key="+key;
        ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class);
        String json=entity.getBody();
        return json;
    }
    @GetMapping(value = "/show")
    @ResponseBody
    public String test(){
        return "hello ya";
    }
}
