package com.hehan.ai.chatbot.web;

import com.alibaba.cola.dto.Response;
import com.hehan.ai.chatbot.api.openai.ChatBotRequestService;
import com.hehan.ai.chatbot.domain.chat.model.QuestionRequest;
import com.hehan.ai.chatbot.dto.openai.ReqQuestion;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class GetQuestionController {

    private final ChatBotRequestService chatBotRequestService;

    /*
    {"max_tokens":2000,"messages":[{"content":"You are a helpful assistant.","role":"system"},{"content":"你好","role":"user"}],"model":"gpt-3.5-turbo"}
     */
    @PostMapping("ask")
    public Response ask(@RequestBody QuestionRequest questionRequest, @RequestHeader("authorization") String authorization, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(questionRequest.getMessages());
//        System.out.println(authorization);
//        System.out.println(request.getHeader("host"));
//        System.out.println(request.getHeader("user-agent"));
//        System.out.println(request.getHeader("authorization"));
        chatBotRequestService.doChat(new ReqQuestion().setContent(questionRequest.getMessages().get(1).getContent()));
//        ChatBotRequestServiceImpl.create(new ReqQuestion().setContent(questionRequest.getMessages().get(1).getContent()))
        return Response.buildSuccess();
    }
}
