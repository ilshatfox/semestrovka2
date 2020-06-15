package com.example.demo.models;

import com.example.demo.validator.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "logs_info")
//@FieldMatch.List({@FieldMatch(first = "password", second = "passwordRepeat", message = "passwords vary")})
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 4, max = 100000)
    private String logField;

//    @NotNull
//    @Size(min = 4, max = 20)
//    private String password;
//
//    @Transient
//    @NotNull
//    @Size(min = 4, max = 20)
//    private String passwordRepeat;

}
