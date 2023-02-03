package org.completions.entity;

import lombok.Data;

/**
 * GPT-3生成的内容
 *
 * https://beta.openai.com/docs/api-reference/completions/create
 */
@Data
public class CompletionChoice {
    /**
     * 生成的文本。将包括提示，如果{@链接CompletionRequest#echo}是真的
     */
    private String text;

    /**
     * 返回列表中该补全的索引。
     */
    private Integer index;

    /**
     * 所选令牌和顶部令牌的日志概率
     */
    private LogProbResult logprobs;

    /**
     * GPT-3停止的原因，例如“长度”。
     */
    private String finish_reason;
}
