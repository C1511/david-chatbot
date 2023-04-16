package com.hehan.ai.chatbot.api.web_request;

import cn.hutool.json.JSONUtil;
import com.hehan.ai.chatbot.api.web_request.model.AnswerRequest;
import com.hehan.ai.chatbot.api.web_request.model.AnswerResponse;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public class WebRequestApi {

    /**
     * 回答问题
     */
    public static AnswerResponse reply(AnswerRequest request) {
        String json = JSONUtil.toJsonStr(request);
        return JSONUtil.toBean(json, AnswerResponse.class);
    }
}

