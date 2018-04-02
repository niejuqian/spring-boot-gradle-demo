package com.demo.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by niejiuqian on 2017/9/13.
 */
public class ResponseHelper {

    /**
     * 直接输出文本
     * @param response
     * @param resultBody
     */
    public static void write(HttpServletResponse response, String resultBody,String contentType) {
        response.setContentType(contentType);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin","*");
        int length = 0;
        try {
            byte[] bytes = resultBody.getBytes("utf-8");
            length = bytes.length;
            response.setHeader("Content-Length", length + "");
            response.setDateHeader("Expires", 0);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(resultBody);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接输出json文本
     * @param response
     * @param resultBody
     */
    public static void writeJson(HttpServletResponse response, String resultBody) {
        write(response,resultBody,"application/json;charset=utf-8");
    }

    /**
     * 直接输出普通文本
     * @param response
     * @param resultBody
     */
    public static void writeText(HttpServletResponse response, String resultBody) {
        write(response,resultBody,"text/xml;charset=utf-8");
    }
}
