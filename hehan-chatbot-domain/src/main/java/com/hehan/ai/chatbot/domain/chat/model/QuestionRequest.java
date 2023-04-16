package com.hehan.ai.chatbot.domain.chat.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/*
{"max_tokens":2000,"messages":[{"content":"You are a helpful assistant.","role":"system"},{"content":"你好","role":"user"}],"model":"gpt-3.5-turbo"}
 */
@Data
@Accessors(chain = true)
public class QuestionRequest {
    private String maxTokens;
    private List<QuestionRequestContent> messages;
    private String model;

    @Data
    @Accessors(chain = true)
    public static class QuestionRequestContent {
        private String content;
        private String role;
    }
}
