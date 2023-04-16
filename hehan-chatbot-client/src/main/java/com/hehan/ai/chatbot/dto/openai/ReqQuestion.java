package com.hehan.ai.chatbot.dto.openai;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReqQuestion {
    private String ApiKey;
    private String content;
}
