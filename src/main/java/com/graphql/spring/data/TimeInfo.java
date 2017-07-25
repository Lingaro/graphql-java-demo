package com.graphql.spring.data;

import graphql.annotations.GraphQLField;

import java.time.LocalDateTime;

public class TimeInfo {
    private final LocalDateTime time;

    public TimeInfo(LocalDateTime time) {
        this.time = time;
    }

    @GraphQLField
    public String getDate() {
        return time.toLocalDate().toString();
    }
    @GraphQLField
    public String getTime() {
        return time.toLocalTime().toString();
    }
}
