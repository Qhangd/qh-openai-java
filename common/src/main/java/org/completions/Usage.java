package com.theokanning.openai;

import lombok.Data;

/**
 * The OpenAI resources used by a request
 */
@Data
public class Usage {
    /**
     * 使用的提示令牌数量。
     */
    long promptTokens;

    /**
     * 使用的完成令牌数量。
     */
    long completionTokens;

    /**
     * 使用的token总数
     */
    long totalTokens;
}
