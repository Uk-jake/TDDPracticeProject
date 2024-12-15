package com.example.tddpracticeproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemoDto {

    private Long mId;

    private String mTitle;

    private String mContent;
}
