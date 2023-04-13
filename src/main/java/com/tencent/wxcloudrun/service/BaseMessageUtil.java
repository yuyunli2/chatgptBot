package com.tencent.wxcloudrun.service;

public interface BaseMessageUtil <T>{
    /**
     * 将回复的信息对象转xml格式给微信
     * @return
     */
    public  abstract  String messageToxml(T t);

    /**
     * 回复的信息封装
     * @param FromUserName
     * @param ToUserName
     * @return
     */
    public abstract  String initMessage(String FromUserName,String ToUserName);
}
