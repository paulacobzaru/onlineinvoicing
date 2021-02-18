package com.sda.onlineinvoicing.entity;

import javax.persistence.*;

@Entity
@Table(name ="unit_type")
public class UnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int unitTypeId;

    @Column(length = 100)
    private String unitName;

    public int getUnitTypeId() {
        return unitTypeId;
    }

    public void setUnitTypeId(int unitTypeId) {
        this.unitTypeId = unitTypeId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return "UnitType{" +
                "unitTypeId=" + unitTypeId +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
