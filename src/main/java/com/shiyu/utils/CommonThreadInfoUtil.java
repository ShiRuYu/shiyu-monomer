package com.shiyu.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommonThreadInfoUtil {
    public static final String URI = "uri";
    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";
    public static final ThreadLocal<Map<String,Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static String getURI() {
        return get(URI,String.class);
    }

    /**
     * threadLocal set
     *
     * @param key
     * @param t
     * @param <T>
     */
    public static <T> void set(String key, T t) {
        if (key == null || Objects.equals("", key.trim())) {
            key = t.getClass().getSimpleName();
        }
        Map<String,Object> objectMap = THREAD_LOCAL.get();
        if (objectMap == null) {
            objectMap = new HashMap<>(16);
            THREAD_LOCAL.set(objectMap);
        }
        objectMap.put(key, t);
    }
    /**
     * get
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(String key, Class<T> clazz) {
        if (key == null || Objects.equals("", key.trim())) {
            key = clazz.getSimpleName();
        }
        Map<String,Object> objectMap = THREAD_LOCAL.get();
        if (objectMap != null) {
            Object o = objectMap.get(key);
            if (o == null) {
                return null;
            }
            else if (o.getClass().equals(clazz)) {
                return (T) o;
            }
        }
        return null;
    }

    /**
     * 刷新缓存区
     */
    public static void refresh() {
        THREAD_LOCAL.remove();
    }
}
