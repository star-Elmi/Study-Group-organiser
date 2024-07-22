package com.group10.StudyGroupOrganizer.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "UserTble")
@Data
public class User {
   @Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String fullName;
    private int age;
    private int phone;
    private String email;
    private String address;
    private String username;
    private String Password;
    private String sex;

}
