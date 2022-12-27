package com.example.webseries;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="car_table")
public class CarModel {
    @Id
    private String carId;
    private String carModel;
    private String carNo;
    private String status;
}
