package com.cedaniel200.github.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Repository {
    private final String name;
    private final String description;
    private final boolean initializeWithREADME;
    private final GitIgnore gitIgnore;
    private final License license;
}
