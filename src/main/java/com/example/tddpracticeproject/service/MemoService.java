package com.example.tddpracticeproject.service;

import com.example.tddpracticeproject.dto.MemoDto;

public interface MemoService {
    //Service 계층에서 삽입 작업시 다시 리턴하는 이유는 대부분 Sequence 나 AutoIncrement 때문
    //자동으로 생성되는 기본키는 입력을 받지 않기 때문에 어떤 값인지 알지 못하기 때문에
    //Repository가 삽입한 데이터를 조회하면 알 수 있습니다.
    public MemoDto saveMemo(MemoDto memoDTO);
}
