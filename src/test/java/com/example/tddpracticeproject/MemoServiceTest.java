//package com.example.tddpracticeproject;
//
//import com.example.tddpracticeproject.dto.MemoDto;
//import com.example.tddpracticeproject.service.MemoService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import com.example.tddpracticeproject.repository.MemoRepository;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@ExtendWith(MockitoExtension.class)
//public class MemoServiceTest {
//
//    @Mock
//    final MemoRepository memoRepository;
//
//    @InjectMocks
//    final MemoService memoService;
//
//    public MemoServiceTest(MemoRepository memoRepository, MemoService memoService) {
//        this.memoRepository = memoRepository;
//        this.memoService = memoService;
//
//    }
//
//    final String title = "new Title";
//    final String content = "new Content";
//
//
//
//    // 1. 메모 생성 서비스 테스트
////    @Test
////    @DisplayName("메모 생성 서비스 테스트")
////    public void createMemo(){
////        // given
////        MemoDto memoDto = MemoDto.builder().mTitle(title).mContent(content).build();
////
////
////        // when
////        memoService.saveMemo(memoDto);
////
////        // then
////
////    }
//
//
//
//}
