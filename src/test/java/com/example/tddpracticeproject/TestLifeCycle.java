package com.example.tddpracticeproject;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    @DisplayName("Test Case 2")
    public void test2(){
        System.out.println("test2");
    }

    //이 Test는 Test를 할 때 제외
    @Test
    @DisplayName("Test Case 3")
    @Disabled
    public void test3(){
        System.out.println("test3");
    }

    // 전체 테스트 시작 전
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    // 전체 테스트 시작 후
    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    // 모든 테스트 시작할 때 마다
    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    // 모든 테스트 끝나고
    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}


