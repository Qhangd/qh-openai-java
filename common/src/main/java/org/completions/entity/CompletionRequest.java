package org.completions.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletionRequest {


    /**
     * 模型id
     */
    private String model;

    /**
     * 你要说的话
     */
    private String prompt;

    /**
     * 返回的文本长度
     */
    private Integer maxTokens;

    /**
     * 同一问题的重复率，0的话最理智，1的话不重复
     */
    private Double temperature;

    /**
     * 一种替代温度采样的方法，称为核采样，其中模型考虑具有 top_p 概率质量的标记的结果。所以 0.1 意味着只考虑构成前 10% 概率质量的标记。
     *
     * 我们通常建议改变这个或temperature但不是两者。
     */
    private Double topP;

    /**
     * 为每个提示生成多少回复
     */
    private Integer n;

    /**
     * 是否回流部分进度。如果设置，令牌将在可用时作为仅数据服务器发送事件发送，流由data: [DONE]消息终止。
     */
    private Boolean stream;

    /**
     * 包括logprobs最有可能标记的对数概率，以及所选标记。例如，如果logprobs是 5，API 将返回 5 个最有可能的标记的列表。API 将始终返回logprob采样令牌的 ，因此响应中最多可能有logprobs+1元素。
     *
     * 的最大值为logprobs5。如果您需要更多，请通过我们的帮助中心联系我们并描述您的用例。
     */
    private Integer logprobs;

    /**
     * 是否提示问题
     */
    private Boolean echo;

    /**
     * API 将停止生成更多令牌的最多 4 个序列。返回的文本将不包含停止序列。
     */
    private List<String> stop;

    /**
     * -2.0 和 2.0 之间的数字。正值会根据到目前为止是否出现在文本中来惩罚新标记，从而增加模型谈论新主题的可能性。
     */
    private Double presencePenalty;

    /**
     * -2.0 和 2.0 之间的数字。正值会根据新标记在文本中的现有频率对其进行惩罚，从而降低模型逐字重复同一行的可能性。
     */
    private Double frequencyPenalty;

    /**
     * 在服务器端生成best_of完成并返回“最佳”（每个标记具有最高对数概率的那个）。无法流式传输结果。
     *
     * 与 一起使用时n，best_of控制候选完成的数量并n指定要返回的数量 -best_of必须大于n。
     *
     * 注意：因为这个参数会产生很多完成，它会很快消耗你的令牌配额。请谨慎使用并确保您对max_tokens和进行了合理的设置stop。
     */
    private Integer bestOf;

    /**
     * 修改指定标记出现在完成中的可能性。
     *
     * 接受一个 json 对象，该对象将标记（由 GPT 标记器中的标记 ID 指定）映射到从 -100 到 100 的相关偏差值。您可以使用此标记器工具（适用于 GPT-2 和 GPT-3）来转换文本到令牌 ID。从数学上讲，偏差会在采样之前添加到模型生成的对数中。确切的效果因模型而异，但 -1 和 1 之间的值应该会减少或增加选择的可能性；像 -100 或 100 这样的值应该导致相关令牌的禁止或独占选择。
     *
     * 例如，您可以传递{"50256": -100}以防止生成 <|endoftext|> 标记。
     */
    private Map<String, Integer> logitBias;

    /**
     * 代表您的最终用户的唯一标识符，可以帮助 OpenAI 监控和检测滥用行为。
     */
    private String user;
}
