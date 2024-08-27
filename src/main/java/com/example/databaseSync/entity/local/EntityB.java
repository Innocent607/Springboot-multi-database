package com.example.databaseSync.entity.local;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name ="entities")
@AllArgsConstructor
@NoArgsConstructor
public class EntityB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", unique = true)
    private int id;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "risk_rating")
    private String riskRating;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "risk_category")
    private String riskCategory;

    @Column(name = "status")
    private String status;

    @UpdateTimestamp
    @Column(name = "processing_date")
    private Date processingDate;

    @Column(name = "next_processing_date")
    private Date nextProcessingDate;

    @Column(name = "active")
    private boolean active;
}
