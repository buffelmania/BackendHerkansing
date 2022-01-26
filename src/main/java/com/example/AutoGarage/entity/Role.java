package com.example.AutoGarage.entity;

import com.example.AutoGarage.entity.ERole;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Role {

   /* @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long id;

    @Enumerated(EnumType.STRING)
    private ERole name;
*/
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private int id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role() {
    }




    public Role(ERole name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
