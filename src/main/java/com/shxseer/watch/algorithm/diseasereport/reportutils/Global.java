package com.shxseer.watch.algorithm.diseasereport.reportutils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 全局变量类，获取配置文件中的信息。
 * @author zhangliang
 * @since 2018-07-17 11:04
 */
public class Global {

    private static Logger log=LoggerFactory.getLogger(Global.class);
    private static Map<String, String> map = new HashMap<String, String>();

    private static final String encode = "UTF-8";
    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    private static Properties loader = getProperties("global.properties");


    public static String getProperty(String key) {
        String value = map.get(key);
        if (value == null){
            value = loader.getProperty(key);
            map.put(key, value != null ? value : "");
        }
        return value;
    }

    private static Map<String,String> initDiseaseInfo(){
        Map<String,String> map=new HashMap<String,String>();

        return map;
    }

    private static Properties getProperties(String... resourcesPaths){
        Properties properties=new Properties();
        for (String location : resourcesPaths) {
            InputStream is = null;
            try {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                properties.load(is);
            } catch (IOException ex) {
                log.info("Could not load properties from path:" + location + ", " + ex.getMessage());
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
        return properties;
    }
}
