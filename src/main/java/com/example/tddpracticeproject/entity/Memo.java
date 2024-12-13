package com.example.tddpracticeproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

@Entity
@Table(name = "memo")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

}
