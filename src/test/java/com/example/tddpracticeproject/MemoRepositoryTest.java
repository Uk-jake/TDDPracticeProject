package com.example.tddpracticeproject;

import com.example.tddpracticeproject.entity.Memo;
import com.example.tddpracticeproject.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    // 1. MemoRepository 객체 불러와지는지
    @Test
    @DisplayName("MemoRepository 객체 확인")
    public void existedMemoRepo(){
        assertThat(memoRepository).isNotNull();
    }

    // 2. 테이블과 잘 연결되었는지
    @Test
    @DisplayName("테이블과 잘 연결되었는지 테스트")
    public void testInsert() {
        // given: 데이터를 생성하고 저장
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().mTitle("title").mContent("Sample " + i).build();
            memoRepository.save(memo);
        });

        // when: 저장된 데이터의 개수를 확인
        long count = memoRepository.count();

        // then: 예상 결과와 실제 결과가 일치하는지 검증
        assertThat(count).isEqualTo(100);
    }

    // 3. Memo가 잘 생성되는지 확인
    @Test
    @DisplayName("Memo 생성")
    public void createMemo(){
        // given
        String title = "title";
        String content = "Test content";

        final Memo memo = Memo.builder().mTitle(title).mContent(content).build();

        // when
        final Memo result = memoRepository.save(memo);

        // then
        assertThat(result.getMId()).isNotNull();
        assertThat(result.getMTitle()).isEqualTo(title);
        assertThat(result.getMContent()).isEqualTo(content);
    }

    // 4. Memo 조회 테스트
    @Test
    @DisplayName("Memo 조회 테스트")
    public void findAllMemo(){
        // given
        IntStream.rangeClosed(1, 10).forEach( i -> {
            Memo memo = Memo.builder().mTitle("title").mContent("Sample..").build();
            memoRepository.save(memo);
        });

        // when
        List<Memo> memoList = memoRepository.findAll();

        // then
        assertThat(memoList.size()).isEqualTo(10);
    }

    // 5. Memo 수정 테스트
    @Test
    @DisplayName("Memo 수정 테스트")
    public void testUpdateMemo() {
        // given
        Memo memo = Memo.builder().mTitle("original title").mContent("original content").build();
        Memo savedMemo = memoRepository.save(memo);

        // when
        savedMemo.setMTitle("updated title");
        savedMemo.setMContent("updated content");
        Memo updatedMemo = memoRepository.save(savedMemo);

        // then
        assertThat(updatedMemo.getMTitle()).isEqualTo("updated title");
        assertThat(updatedMemo.getMContent()).isEqualTo("updated content");
    }

    // 6, Memo 삭제 테스트
    @Test
    @DisplayName("Memo 삭제 테스트")
    public void deleteMemo() {
        // given
        Memo memo = Memo.builder().mTitle("title").mContent("content").build();
        Memo savedMemo = memoRepository.save(memo); // 저장된 엔티티를 반환받음

        Long memoId = savedMemo.getMId(); // 저장된 Memo의 ID 가져오기
        assertThat(memoRepository.findById(memoId)).isPresent(); // 삭제 전 존재 여부 확인

        // when
        memoRepository.deleteById(memoId);

        // then
        Optional<Memo> result = memoRepository.findById(memoId);
        assertThat(result).isEmpty(); // 삭제 후 존재하지 않는지 확인
    }


}
