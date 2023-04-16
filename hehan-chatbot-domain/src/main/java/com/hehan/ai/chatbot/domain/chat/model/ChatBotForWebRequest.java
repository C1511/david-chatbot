package com.hehan.ai.chatbot.domain.chat.model;

import com.alibaba.cola.domain.DomainFactory;
import com.alibaba.cola.domain.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 聊天机器人聚合根
 *
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Slf4j
@Data
@AllArgsConstructor(staticName = "of")
@Entity
public class ChatBotForWebRequest {
    private AnswerEngine answerEngine;

    public Answer doChat(Question question) {

        Answer answer = answerEngine.doAnswer(question);
        if (answer == null) {
            log.error("answer is null");
            return null;
        }
        return answer;

    }

    public static ChatBotForWebRequest create(AnswerEngineType answerEngineType) {
        AnswerEngine answerEngine = DomainFactory.create(AnswerEngine.class).setAnswerEngineType(answerEngineType);
        return of(answerEngine);
    }

}
