package org.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import org.completions.entity.CompletionRequest;
import org.completions.entity.CompletionResult;

@BaseRequest(baseURL = "https://api.openai.com/v1")
public interface ChatGptClient {

    @Post(value = "/completions", headers = {"Content-Type: application/json"})
    CompletionResult completion(@Body CompletionRequest completionRequest);
}
