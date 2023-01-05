package com.example.demo.common;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	// 널체크
    public static String paramNullCheck(HttpServletRequest request, String paramName, String returnVal) {
        return request.getParameter(paramName)==null?returnVal:request.getParameter(paramName);
    }
}
