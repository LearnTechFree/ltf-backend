package com.learntechfree.ltf.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum  AuthProvider {
    SYSTEM("system"),
    FACEBOOK("facebook"),
    GOOGLE("google"),
    GITHUB("github");

    AuthProvider(String provider) {
        this.provider = provider;
    }

    public static AuthProvider get(String value) {
        return codeHashMap.get(value);
    }

    private String provider;

    public static final Map<String, AuthProvider> codeHashMap = Arrays.stream(AuthProvider.values())
            .collect(Collectors.toMap(AuthProvider::getProvider, Function.identity()));
}
