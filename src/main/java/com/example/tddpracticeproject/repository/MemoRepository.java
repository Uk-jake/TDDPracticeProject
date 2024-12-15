package com.example.tddpracticeproject.repository;

import com.example.tddpracticeproject.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long > {

//    Memo findByMTitle(String mTitle); // 엔티티의 속성과 이름이 일치하는지 확인
}
