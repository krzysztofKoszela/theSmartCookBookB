package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/*@EntityListeners(AuditingEntityListener.class)*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "APP_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Usr_id;

    @Column(nullable = false)
    private String Usr_name;
    @Column(nullable = false)
    private String Usr_email;
    @Column(nullable = false)
    private String Usr_pass;
    @Column
    private String Acc_descript;
    @Column
    private String Blog_URL;
    @Column
    private byte[] Usr_picture;

}
