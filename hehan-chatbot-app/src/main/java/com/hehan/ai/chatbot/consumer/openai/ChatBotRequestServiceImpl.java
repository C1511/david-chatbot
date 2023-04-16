package com.hehan.ai.chatbot.consumer.openai;

import com.hehan.ai.chatbot.api.openai.ChatBotRequestService;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.ChatBotForWebRequest;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import com.hehan.ai.chatbot.dto.openai.ReqQuestion;
import com.hehan.ai.chatbot.dto.openai.ResAnswer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ChatBotRequestServiceImpl implements ChatBotRequestService {

//    private Question question;

    @Override
    public ResAnswer doChat(ReqQuestion reqQuestion) {
        Answer answer = ChatBotForWebRequest.create(AnswerEngineType.openai).doChat(new Question().setContent(reqQuestion.getContent()));
        return new ResAnswer().setContent(answer.getContent());
    }

//    public static ChatBotRequestService create(Question q){
//        return of(q);
//    }
}
