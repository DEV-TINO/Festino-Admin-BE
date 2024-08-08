package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CheckMessageStatusBean;
import com.DevTino.festino_admin.message.bean.small.GetAccessTokenBean;
import com.DevTino.festino_admin.message.bean.small.SendMessageContentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class ReservationTop2SendMessageBean {

    GetAccessTokenBean getAccessTokenBean;
    SendMessageContentBean sendMessageContentBean;
    CheckMessageStatusBean checkMessageStatusBean;

    @Autowired
    public ReservationTop2SendMessageBean(GetAccessTokenBean getAccessTokenBean, SendMessageContentBean sendMessageContentBean, CheckMessageStatusBean checkMessageStatusBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.sendMessageContentBean = sendMessageContentBean;
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

        return sendMessageContentBean.exec(phoneNum, accessToken, refKey, message);

        // 1팀 대기는 로직상 체크 안하고 가기로 결정
        /*String messageStatus = sendMessageBean.exec(phoneNum, accessToken, refKey, message);
        if (messageStatus.equals("SEND_FAIL")) return messageStatus;

        return checkMessageStatusBean.exec(refKey, accessToken);*/
    }
}
