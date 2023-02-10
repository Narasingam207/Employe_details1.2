package com.youtube.Employe121;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="details")

public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pId")
    private int id;
    @Column(name = "emp_pan_card")
    private String PanCard;
    @Column(name = "emp_date_of_birth")
    private Date DateOfBirth;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "details")
    private Employe employe;

    public Details()
    {

    }
}
