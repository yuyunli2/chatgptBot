package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.service.MessageUtil;
import com.tencent.wxcloudrun.service.TextMessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
      message = textMessage.initMessage(FromUserName, ToUserName,Content);
      response.getWriter().write(message);
    }
  }
}
