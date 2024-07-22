package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CheckMessageStatusBean;
import com.DevTino.festino_admin.message.bean.small.GetAccessTokenBean;
import com.DevTino.festino_admin.message.bean.small.SendMessageBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class ReservationTop2SendMessageBean {

    GetAccessTokenBean getAccessTokenBean;
    SendMessageBean sendMessageBean;
    CheckMessageStatusBean checkMessageStatusBean;

    @Autowired
    public ReservationTop2SendMessageBean(GetAccessTokenBean getAccessTokenBean, SendMessageBean sendMessageBean, CheckMessageStatusBean checkMessageStatusBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.sendMessageBean = sendMessageBean;
        this.checkMessageStatusBean = checkMessageStatusBean;
    }

    // 메세지 전송
    /* 반환값
        "SEND_FAIL" -> 메세지 전송 실패
        "SEND_SUCCESS" -> 메세지 전송 성공
    * */
    public String exec(String phoneNum, String userName) throws IOException {

        String accessToken = getAccessTokenBean.exec();
        if (accessToken == null) return "SEND_FAIL";

        String refKey = UUID.randomUUID().toString();
        String message = userName + "님 곧 입장이 가능합니다. 부스로 바로 와주세요.";

        String messageStatus = sendMessageBean.exec(phoneNum, accessToken, refKey, message);
        if (messageStatus.equals("SEND_FAIL")) return messageStatus;

        return checkMessageStatusBean.exec(refKey, accessToken);
    }
}
