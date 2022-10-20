package com.mutbook.week1_mission.app.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class JoinDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
}
