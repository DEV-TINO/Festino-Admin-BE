package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CheckMessageStatusBean;
import com.DevTino.festino_admin.message.bean.small.GetAccessTokenBean;
import com.DevTino.festino_admin.message.bean.small.SendMessageContentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class CompleteReservationSendMessageBean {

    GetAccessTokenBean getAccessTokenBean;
    SendMessageContentBean sendMessageContentBean;
    CheckMessageStatusBean checkMessageStatusBean;

    @Autowired
    public CompleteReservationSendMessageBean(GetAccessTokenBean getAccessTokenBean, SendMessageContentBean sendMessageContentBean, CheckMessageStatusBean checkMessageStatusBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.sendMessageContentBean = sendMessageContentBean;
        this.checkMessageStatusBean = checkMessageStatusBean;
    }

    // 메세지 전송
    /* 반환값
        "SEND_FAIL" -> 메세지 전송 실패
        "SEND_SUCCESS" -> 메세지 전송 성공
    * */
    public String exec(String phoneNum, String userName, String adminName) throws IOException {

        String accessToken = getAccessTokenBean.exec();
        if (accessToken == null) return "SEND_FAIL";

        String refKey = UUID.randomUUID().toString();
        String message = userName + "님 " + adminName + "에서 즐거운 시간 보내시기 바랍니다.";

        String messageStatus = sendMessageContentBean.exec(phoneNum, accessToken, refKey, message);
        if (messageStatus.equals("SEND_FAIL")) return messageStatus;

        return checkMessageStatusBean.exec(refKey, accessToken);
    }
}
