package com.yxz.apps.cms.common;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: wmj
 * Date: 13-8-3
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */
public class CommonUtil {
    public static String genID(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            Random random = new Random();
            int r = random.nextInt(10);
            sb.append(r);
        }
        return sb.toString();
    }

    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
        return simpleDateFormat.format(new Date());
    }

    public static ResponseEntity<String> buildJsonByObject(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(object);
        return buildJson(s);
    }

    public static ResponseEntity<String> buildJson(String s) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-type", "application/json;charset=UTF-8");
        return new ResponseEntity<String>(s, responseHeaders, HttpStatus.OK);
    }
}
