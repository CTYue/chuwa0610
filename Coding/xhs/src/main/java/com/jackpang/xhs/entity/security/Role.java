package com.jackpang.xhs.entity.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author b1go
 * @date 6/26/22 3:43 PM
 */
@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;

}
