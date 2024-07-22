package com.DevTino.festino_admin.user.bean;

import com.DevTino.festino_admin.booth.bean.GetDayBoothBean;
import com.DevTino.festino_admin.booth.bean.GetFoodBoothBean;
import com.DevTino.festino_admin.booth.bean.GetNightBoothBean;
import com.DevTino.festino_admin.booth.bean.small.GetDayBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.GetFoodBoothDAOBean;
import com.DevTino.festino_admin.booth.bean.small.GetNightBoothDAOBean;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import com.DevTino.festino_admin.booth.domain.FoodBoothDAO;
import com.DevTino.festino_admin.booth.domain.NightBoothDAO;
import com.DevTino.festino_admin.user.bean.small.GetUserDAOBean;
import com.DevTino.festino_admin.user.domain.UserDAO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetBoothIdByAdminName {
    GetCookieBean getCookieBean;
    GetDayBoothDAOBean getDayBoothDAOBean;
    GetNightBoothDAOBean getNightBoothDAOBean;
    GetFoodBoothDAOBean getFoodBoothDAOBean;
    GetUserIdByCookie getUserIdByCookie;
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public GetBoothIdByAdminName(GetUserDAOBean getUserDAOBean, GetCookieBean getCookieBean, GetDayBoothDAOBean getDayBoothDAOBean, GetNightBoothDAOBean getNightBoothDAOBean, GetFoodBoothDAOBean getFoodBoothDAOBean, GetUserIdByCookie getUserIdByCookie) {
        this.getUserDAOBean = getUserDAOBean;
        this.getCookieBean = getCookieBean;
        this.getDayBoothDAOBean = getDayBoothDAOBean;
        this.getFoodBoothDAOBean = getFoodBoothDAOBean;
        this.getNightBoothDAOBean = getNightBoothDAOBean;
        this.getUserIdByCookie = getUserIdByCookie;
    }

    public UUID exec(HttpServletRequest request, String secretKey) {
        Cookie cookie = getCookieBean.exec(request);
        UUID userId = getUserIdByCookie.exec(cookie, secretKey);
        UserDAO userDAO = getUserDAOBean.exec(userId);

        DayBoothDAO dayBoothDAO = getDayBoothDAOBean.exec(userDAO.getAdminName());
        if(dayBoothDAO != null) return dayBoothDAO.getBoothId();

        NightBoothDAO nightBoothDAO = getNightBoothDAOBean.exec(userDAO.getAdminName());
        if(nightBoothDAO != null) return nightBoothDAO.getBoothId();

        FoodBoothDAO foodBoothDAO = getFoodBoothDAOBean.exec(userDAO.getAdminName());
        if(foodBoothDAO != null) return foodBoothDAO.getBoothId();

        return null;
    }
}
