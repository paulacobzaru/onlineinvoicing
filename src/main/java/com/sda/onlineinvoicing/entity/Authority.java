package com.sda.onlineinvoicing.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "authorities_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
