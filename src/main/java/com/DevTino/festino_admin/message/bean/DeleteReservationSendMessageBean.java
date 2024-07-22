package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CheckMessageStatusBean;
import com.DevTino.festino_admin.message.bean.small.GetAccessTokenBean;
import com.DevTino.festino_admin.message.bean.small.SendMessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class DeleteReservationSendMessageBean {

    GetAccessTokenBean getAccessTokenBean;
    SendMessageBean sendMessageBean;
    CheckMessageStatusBean checkMessageStatusBean;

    @Autowired
    public DeleteReservationSendMessageBean(GetAccessTokenBean getAccessTokenBean, SendMessageBean sendMessageBean, CheckMessageStatusBean checkMessageStatusBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.sendMessageBean = sendMessageBean;
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
        String message = userName + "님 " + adminName + " 예약이 취소되었습니다.";

        String messageStatus = sendMessageBean.exec(phoneNum, accessToken, refKey, message);
        if (messageStatus.equals("SEND_FAIL")) return messageStatus;

        return checkMessageStatusBean.exec(refKey, accessToken);
    }
}
