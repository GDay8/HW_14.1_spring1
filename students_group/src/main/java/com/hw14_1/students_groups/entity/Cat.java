package com.hw14_1.students_groups.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer cat_id;

    @Column(name = "name")
    private String name;

    @Column(name = "fact")
    private String fact;

    @Column(name = "lenght")
    private Integer lenght;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + cat_id +
                ", name='" + name + '\'' +
                ", fact='" + fact + '\'' +
                ", lenght=" + lenght +
                '}';
    }
}
