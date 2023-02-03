package org.example;

import org.client.ChatGptService;
import org.completions.entity.CompletionRequest;

public class Main {
    public static void main(String[] args) {
        ChatGptService chatGptService = new ChatGptService("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");

        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("给我一个蛋糕")
                .maxTokens(100)
                .build();

        System.out.println(chatGptService.sendCompletion(completionRequest));
    }
}