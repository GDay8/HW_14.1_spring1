package com.hw14_1.students_groups.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "name")
    private String name;

    @Column(name = "entrance_date")
    private LocalDateTime entranceDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "student")
    List<Cat> cats;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + student_id +
                ", name='" + name + '\'' +
                ", entranceDate=" + entranceDate +
                '}';
    }
}
