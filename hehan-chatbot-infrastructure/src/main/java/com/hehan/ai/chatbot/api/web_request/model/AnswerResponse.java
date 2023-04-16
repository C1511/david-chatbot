package com.hehan.ai.chatbot.api.web_request.model;

import lombok.Data;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Data
public class AnswerResponse {

    private RespData respData;

    private boolean succeeded;


    @Data
    public static class Question {
        private boolean expired;
        private Questionee questionee;
        private boolean anonymous;
        private String ownerLocation;
        private String text;
    }

    @Data
    public static class Questionee {
        private String avatarUrl;
        private long userId;
        private String name;
        private String alias;
        private String description;
        private String location;
    }

    @Data
    public static class RespData {
        private TopicsItem topics;
    }

    @Data
    public static class TopicsItem {
        private int readingCount;
        private Question question;
        private boolean answered;
        private String createTime;
        private UserSpecific userSpecific;
        private int rewardsCount;
        private String type;
        private boolean digested;
        private int likesCount;
        private int commentsCount;
        private boolean sticky;
        private long topicId;
        private int readersCount;
    }

    @Data
    public static class UserSpecific {
        private boolean subscribed;
        private boolean liked;
    }
}