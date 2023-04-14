package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.TextMessage;
import com.thoughtworks.xstream.XStream;

public class TextMessageUtil implements BaseMessageUtil<TextMessage> {
    public String messageToxml(TextMessage message) {
        XStream xstream = new XStream();
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }

    @Override
    public String initMessage(String FromUserName, String ToUserName) {
        return null;
    }

    public String initMessage(String FromUserName, String ToUserName, String Content) {
        TextMessage text = new TextMessage();
        text.setToUserName(FromUserName);
        text.setFromUserName(ToUserName);
        text.setContent(Content);
        text.setCreateTime(System.currentTimeMillis());
        text.setMsgType("text");
        return messageToxml(text);
    }
}
