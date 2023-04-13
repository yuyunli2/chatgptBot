package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dto.ChatRequest;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
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
   * @param map
   * @return
   * @throws IOException
   */
  @PostMapping
  @ResponseBody
  public Map<String, Object> chat(@RequestBody Map<String, Object> map) throws IOException {
    System.out.println(map);
    String toUserName = (String) map.get("ToUserName");
    String fromUserName = (String) map.get("FromUserName");
    Long createTime = System.currentTimeMillis();
    String msgType = "text";
    String content = (String) map.get("Content");
    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("ToUserName", toUserName);
    responseMap.put("FromUserName", fromUserName);
    responseMap.put("CreateTime", createTime);
    responseMap.put("MsgType", msgType);
    responseMap.put("Content", content);
    System.out.println("responseMap: " + responseMap);
    return responseMap;
  }

}
