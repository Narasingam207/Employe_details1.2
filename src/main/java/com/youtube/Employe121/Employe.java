package com.youtube.Employe121;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Employe")
public class Employe {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "salary")
    private long salary;
    @Column(name = "email")
    private  String email;
    @Column(name = "address")
    private String address;
  @OneToOne(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
  @JoinColumn(name = "pId")
  private Details details;

  public Employe()
  {

  }
}


