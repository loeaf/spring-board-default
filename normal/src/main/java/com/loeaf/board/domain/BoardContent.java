package com.loeaf.board.domain;

import com.loeaf.common.Domain;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="board_content")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardContent extends Domain {
    @Column(length = 2000, nullable = false)
    private String content;
}