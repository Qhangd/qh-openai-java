package org.client;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleInterceptor<T> implements Interceptor<T> {
    private final static Logger log = LoggerFactory.getLogger(SimpleInterceptor.class);

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean beforeExecute(ForestRequest request) {
        request.addHeader("Authorization", "Bearer " + token);  // 添加Header
        return true;
    }
}
