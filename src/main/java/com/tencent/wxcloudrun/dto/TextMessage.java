package com.tencent.wxcloudrun.dto;

public class TextMessage {
    protected String ToUserName;//接收方账号
    protected String FromUserName;//开发者微信号
    protected long CreateTime;//消息创建时间
    protected String MsgType;//消息类型
    private String Content;//文本消息内容
    private String MsgId;//消息id，64位整型

    public TextMessage() {
    }

    public TextMessage(String toUserName, String fromUserName, long createTime, String msgType, String content, String msgId) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Content = content;
        MsgId = msgId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
