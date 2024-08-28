package com.DevTino.festino_admin.message.bean;

import com.DevTino.festino_admin.message.bean.small.CheckMessageStatusBean;
import com.DevTino.festino_admin.message.bean.small.GetAccessTokenBean;
import com.DevTino.festino_admin.message.bean.small.GetCustomMessageDAOBean;
import com.DevTino.festino_admin.message.bean.small.SendMessageContentBean;
import com.DevTino.festino_admin.message.domain.ENUM.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class DeleteReservationSendMessageBean {

    GetAccessTokenBean getAccessTokenBean;
    SendMessageContentBean sendMessageContentBean;
    CheckMessageStatusBean checkMessageStatusBean;
    GetCustomMessageDAOBean getCustomMessageDAOBean;

    @Autowired
    public DeleteReservationSendMessageBean(GetAccessTokenBean getAccessTokenBean, SendMessageContentBean sendMessageContentBean, CheckMessageStatusBean checkMessageStatusBean, GetCustomMessageDAOBean getCustomMessageDAOBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.sendMessageContentBean = sendMessageContentBean;
        this.checkMessageStatusBean = checkMessageStatusBean;
        this.getCustomMessageDAOBean = getCustomMessageDAOBean;
    }

    // 메세지 전송
    /* 반환값
        "SEND_FAIL" -> 메세지 전송 실패
        "SEND_SUCCESS" -> 메세지 전송 성공
    * */
    public String exec(UUID boothId, String phoneNum, String userName) throws IOException {

        String accessToken = getAccessTokenBean.exec();
        if (accessToken == null) return "SEND_FAIL";

        String refKey = UUID.randomUUID().toString();
        //String message = userName + "님 " + adminName + " 예약이 취소되었습니다.";

        String message = userName + "님 " + getCustomMessageDAOBean.exec(boothId, MessageType.DELETE).getMessage();

        String messageStatus = sendMessageContentBean.exec(phoneNum, accessToken, refKey, message);
        if (messageStatus.equals("SEND_FAIL")) return messageStatus;

        return checkMessageStatusBean.exec(refKey, accessToken);
    }
}
