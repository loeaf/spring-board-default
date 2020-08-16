package com.loeaf.common;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public abstract class Domain {
    /**
     * 안녕 아이디
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @CreationTimestamp
    @Column(name = "regist_datetime")
    protected Date registDt;

    @UpdateTimestamp
    @Column(name = "modified_datetime")
    protected Date updtDt;
}
