package com.example.tddpracticeproject;

import com.example.tddpracticeproject.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    // 1. MemoRepository 객체 불러와지는지
    @Test
    @DisplayName("MemoRepository 객체 확인")
    public void ExistedMemoRepo(){
        assertThat(memoRepository).isNotNull();
    }

}
