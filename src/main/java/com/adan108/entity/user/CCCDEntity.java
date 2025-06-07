package com.adan108.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "java_cccd_001")
@Data
public class CCCDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberCCCD;

//   No need for this as it will create both depend one each other
    // So no need to create dependency here

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private UserEntity user;
}
