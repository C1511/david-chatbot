package com.hehan.ai.chatbot.api.openai;

import com.hehan.ai.chatbot.dto.openai.ReqQuestion;
import com.hehan.ai.chatbot.dto.openai.ResAnswer;

public interface ChatBotRequestService {
    public ResAnswer doChat(ReqQuestion reqQuestion);
}
