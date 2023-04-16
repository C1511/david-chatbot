package com.hehan.ai.chatbot.chat.platform;

import cn.hutool.core.collection.ListUtil;
import com.hehan.ai.chatbot.api.web_request.WebRequestApi;
import com.hehan.ai.chatbot.api.web_request.model.AnswerRequest;
import com.hehan.ai.chatbot.api.web_request.model.AnswerResponse;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author David
 * @description web请求api
 * @github
 * @Copyright
 */
@Slf4j
@Service
public class WebRequestPlatform implements Platform {

    @Override
    public Collection<Question> findQuestion() {
        return ListUtil.of(new Question().setContent("im default question"));
    }

    @Override
    public boolean doReply(Answer answer) {
        AnswerRequest request = new AnswerRequest().setReq_data(new AnswerRequest.ReqData().setText(answer.getContent()));
        AnswerResponse response = WebRequestApi.reply(request);
        return response.isSucceeded();
    }

    @Override
    public PlatformType getType() {
        return PlatformType.web_requestion;
    }
}
