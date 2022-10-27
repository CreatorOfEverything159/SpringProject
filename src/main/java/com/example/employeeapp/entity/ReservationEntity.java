package com.example.employeeapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private EmployeeEntity holder;

    private Timestamp startsAt;

    private Timestamp endsAt;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private WorkplaceEntity workplace;

    public EmployeeEntity getHolder() {
        return holder;
    }

    public void setHolder(EmployeeEntity holder) {
        this.holder = holder;
    }
}
