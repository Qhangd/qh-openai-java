package org.completions.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 不同令牌选项的对数概率
 *
 * https://beta.openai.com/docs/api-reference/create-completion
 */
@Data
public class LogProbResult {

    /**
     * 补全api选择的令牌
     */
    List<String> tokens;

    /**
     * The log probability of each token in {@link tokens}
     */
    List<Double> tokenLogprobs;

    /**
     * A map for each index in the completion result.
     * The map contains the top {@link CompletionRequest#logprobs} tokens and their probabilities
     */
    List<Map<String, Double>> topLogprobs;

    /**
     * 对于每个选定的标记，从返回文本开始的字符偏移量。
     */
    List<Integer> textOffset;
}
