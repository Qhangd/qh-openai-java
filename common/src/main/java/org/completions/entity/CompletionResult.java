package org.completions.entity;

import com.theokanning.openai.Usage;
import lombok.Data;

import java.util.List;

/**
 * 一个包含来自补全api的响应的对象
 *
 * https://beta.openai.com/docs/api-reference/completions/create
 */
@Data
public class CompletionResult {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 返回的对象类型 例如 "text_completion"
     */
    private String object;

    /**
     * 创建时间 时间戳
     */
    private long created;

    /**
     * 使用的模型
     */
    private String model;

    /**
     * 回复列表
     */
    private List<CompletionChoice> choices;

    /**
     * 使用情况
     */
    private Usage usage;
}
