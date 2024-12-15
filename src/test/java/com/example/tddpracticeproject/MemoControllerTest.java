package com.example.tddpracticeproject;

import com.example.tddpracticeproject.controller.MemoController;
import com.example.tddpracticeproject.dto.MemoDto;
import com.example.tddpracticeproject.service.MemoService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Controller를 테스트 할 때는 가짜 요청을 보내서 테스트하므로
//클래스를 만들 때 어노테이션이 다릅니다.
@WebMvcTest(MemoController.class)
public class MemoControllerTest {
    //실제가 아닌 가짜 객체를 생성해주기 위한 MockMvc를 외부로부터 주입
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    MemoService memoService;

    @Test
    public void createMemo() throws Exception {
        //Controller 의 요청에 사용할 파라미터 객체를 생성
        MemoDto memoDTO = MemoDto.builder().
                mTitle("Controller Test").mContent("content").build();

        //웹의 파라미터로 변경
        Gson gson = new Gson();
        String title = gson.toJson(memoDTO.getMTitle());
        String content = gson.toJson(memoDTO.getMContent());

        //테스트
        mockMvc.perform(
                        post("/save")
                                .content(title + content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

