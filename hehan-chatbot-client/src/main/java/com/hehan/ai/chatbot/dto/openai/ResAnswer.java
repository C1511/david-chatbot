package com.hehan.ai.chatbot.dto.openai;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResAnswer {
    private String content;
}
