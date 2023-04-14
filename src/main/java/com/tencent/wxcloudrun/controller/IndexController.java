package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONArray;
import com.tencent.wxcloudrun.service.MessageUtil;
import com.tencent.wxcloudrun.service.TextMessageUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * index控制器
 */
@Controller
public class IndexController {

  /**
   * 主页页面
   * @return API response html
   */
  @GetMapping
  public String index() {
    return "index";
  }

  /**
   * {ToUserName=gh_c0dcfafd5ba7, FromUserName=ocfKe5yo_AnWkd8kdcorTv7SXlfU, CreateTime=1681394782, MsgType=text, Content=2, MsgId=24071788176428433}
   * @return
   * @throws IOException
   */
  @PostMapping
  public void chat(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setCharacterEncoding("utf-8");
    Map<String,String> map = MessageUtil.xmlToMap(request);
    String ToUserName = map.get("ToUserName");
    String FromUserName = map.get("FromUserName");
    String MsgType = map.get("MsgType");
    String Content = map.get("Content");
    System.out.println("map: " + map);
    String message = null;
    if("text".equals(MsgType)){
      TextMessageUtil textMessage = new TextMessageUtil();
      message = textMessage.initMessage(FromUserName, ToUserName,sendPost(Content));
      response.getWriter().write(message);
    }
  }

  public static String sendPost(String data) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization","Bearer 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");
    httpHeaders.add("Content-Type", "application/json"); // 传递请求体时必须设置
//        String requestJson = "{\n" +
//                "    \"model\": \"text-davinci-003\",\n" +
//                "     \"prompt\": \"你好\",\n" +
//                "      \"temperature\": 0, \n" +
//                "      \"max_tokens\": 2048\n" +
//                "}";
    String requestJson = String.format(
            "{\n" +
            "     \"model\": \"gpt-3.5-turbo\",\n" +
            "     \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]\n" +
            "}",data
    );
    System.out.println(requestJson);
//    HttpEntity<String> entity = new HttpEntity<String>(requestJson,httpHeaders);
//    ResponseEntity<String> response = client.exchange("https://api.openai.com/v1/chat/completions", HttpMethod.POST, entity, String.class);
//    System.out.println(response.getBody());
//    JSONObject jsonObject = JSONObject.parseObject(response.getBody());
//    JSONArray choices = jsonObject.getJSONArray("choices");
//    JSONObject message = (JSONObject) choices.getJSONObject(0).get("message");
//    String content = (String) message.get("content");
//    return content;
    return "SUCCESS";
  }

  public void getGptDate(String requestJson, HttpHeaders httpHeaders) {
    RestTemplate client = new RestTemplate();
    HttpEntity<String> entity = new HttpEntity<String>(requestJson,httpHeaders);
    ResponseEntity<String> response = client.exchange("https://api.openai.com/v1/chat/completions", HttpMethod.POST, entity, String.class);
    System.out.println(response.getBody());
    JSONObject jsonObject = JSONObject.parseObject(response.getBody());
    JSONArray choices = jsonObject.getJSONArray("choices");
    JSONObject message = (JSONObject) choices.getJSONObject(0).get("message");
    String content = (String) message.get("content");
  }
}
