package com.alex.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @Description: 向指定url发送post方法请求
 * @Author:     alex
 * @CreateDate: 2019/7/30 16:07
 * @Version:    1.0
 * @Return 远程资源的响应结果
 */
public class HttpUtil {

    private static final Log logger = LogFactory.getLog(HttpUtil.class);

    /**
     * @Description: 向指定url发送post方法的请求
     * @Author:      alex
     * @CreateDate:  2019/7/30 16:34
     * @param
     * @return 远程资源的响应结果
    */
    public static String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL readUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) readUrl.openConnection();
            //发送post必须配置如下两行
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //设置post方法
            connection.setRequestMethod("POST");
            //设置通用的请求属性
            connection.setRequestProperty("accpt", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSTE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");;
            connection.connect();
            //获取urlConnection对象对应输出流
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            //发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if (param.length() > 0)
                        param.append("&");
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                }
                out.append(param.toString());
            }
            //flush输出流的缓冲
            out.flush();
            //定义BufferedReader输入流来读取url响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while((line = in.readLine()) != null)
                result.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }//使用finally块来关闭输入流、输出流
        finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
