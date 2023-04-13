package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dto.ChatRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

  @PostMapping
  public void chat(@RequestBody ChatRequest request, HttpServletResponse response) throws IOException {
    String content = request.getContent();
    System.out.println("content: " + content);
    response.getWriter().write("it's response, get conent: " + content);
  }

}
