package com.example.tddpracticeproject.repository;

import com.example.tddpracticeproject.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long > {
}
