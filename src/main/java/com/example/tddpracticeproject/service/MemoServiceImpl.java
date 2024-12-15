package com.example.tddpracticeproject.service;

import com.example.tddpracticeproject.dto.MemoDto;
import com.example.tddpracticeproject.entity.Memo;
import com.example.tddpracticeproject.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoDto saveMemo(MemoDto memoDto) {
        //데이터 유효성 검사

        //삽입이나 수정 삭제의 경우는 매개변수로 Repository의 매개변수를 생성
        Memo memo = Memo.builder().mTitle(memoDto.getMTitle()).mContent(memoDto.getMContent()).build();

        //삽입
        memoRepository.save(memo);

        //memoDTO에 삽입된 데이터의 mno가 저장
        memoDto.setMId(memo.getMId());

        return memoDto;
    }
}
