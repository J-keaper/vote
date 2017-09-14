package com.keaper.vote.common.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String getIP(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

    public static String getUserAgent(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return userAgent;
    }

}
