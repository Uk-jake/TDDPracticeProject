package com.example.tddpracticeproject.controller;


import com.example.tddpracticeproject.dto.MemoDto;
import com.example.tddpracticeproject.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/save")
    public ResponseEntity<MemoDto> saveMemo(@RequestBody MemoDto memoDto){
        MemoDto result = memoService.saveMemo(memoDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
