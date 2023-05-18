package com.utc2.fuochung.jpa_mysql.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @NotEmpty(message = "Name should not null be null")
    private String name;
    private Long age;
    @Email(message = "Please enter the valid email address")
    private String email;
    @NotEmpty(message = "Department should not null be null")
    private String department;
    @CreationTimestamp
    @Column(name="create_At", nullable = false,updatable = false)
    private Date createAt;
    @UpdateTimestamp
    @Column(name="update_At")
    private Date updateAt;
}
