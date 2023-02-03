package org.client;

import com.dtflys.forest.Forest;
import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.converter.json.ForestJacksonConverter;
import com.dtflys.forest.http.ForestAsyncMode;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.interceptor.InterceptorFactory;
import com.dtflys.forest.retryer.BackOffRetryer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.completions.entity.CompletionRequest;
import org.completions.entity.CompletionResult;

import java.util.ArrayList;
import java.util.List;

public class ChatGptService {

    private final String token;

    private ChatGptClient chatGptClient;

    public ChatGptService(String token) {
        this.token = token;

        ForestConfiguration configuration = Forest.config();
        // 连接池最大连接数，默认值为500
        configuration.setMaxConnections(123);
        // 每个路由的最大连接数，默认值为500
        configuration.setMaxRouteConnections(222);
        // [自v1.5.22版本起可用] 最大请求等待队列大小
        configuration.setMaxRequestQueueSize(100);
        // [自v1.5.21版本起可用] 最大异步线程数
        configuration.setMaxAsyncThreadSize(300);
        // [自v1.5.22版本起可用] 最大异步线程池队列大小
        configuration.setMaxAsyncQueueSize(16);
        // 请求超时时间，单位为毫秒, 默认值为3000
        configuration.setTimeout(30000);
        // 连接超时时间，单位为毫秒, 默认值为2000
        configuration.setConnectTimeout(20000);
        // 设置重试器
        configuration.setRetryer(BackOffRetryer.class);
        // 请求失败后重试次数，默认为0次不重试
        configuration.setMaxRetryCount(0);
        // 单向验证的HTTPS的默认SSL协议，默认为SSLv3
        //configuration.setSslProtocol(SSLUtils.SSLv3);

        ForestJacksonConverter forestJacksonConverter = new ForestJacksonConverter();

        ObjectMapper mapper = forestJacksonConverter.getMapper();
        mapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configuration.setJsonConverter(forestJacksonConverter);

        //向拦截器中添加token
        List<Class<? extends Interceptor>> interceptors = new ArrayList<>();
        interceptors.add(SimpleInterceptor.class);
        configuration.setInterceptors(interceptors);
        InterceptorFactory interceptorFactory = configuration.getInterceptorFactory();
        SimpleInterceptor interceptor = interceptorFactory.getInterceptor(SimpleInterceptor.class);
        interceptor.setToken(token);

        // 打开或关闭日志，默认为true
        configuration.setLogEnabled(true);
        // [自v1.5.27版本起可用] 异步模式（默认为 platform）
        configuration.setAsyncMode(ForestAsyncMode.PLATFORM);

        ChatGptClient client = Forest.client(ChatGptClient.class);
        this.chatGptClient = client;
    }

    public CompletionResult sendCompletion(CompletionRequest completionRequest) {
        return chatGptClient.completion(completionRequest);
    }

}
