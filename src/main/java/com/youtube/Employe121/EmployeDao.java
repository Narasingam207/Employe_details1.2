package com.youtube.Employe121;

import java.util.List;

public interface EmployeDao {

    List<Employe> getAll();
    Employe getById(int Id);
    List<Employe> getByName(String name);
int save(Employe employe);
    int update(Employe employe,int id);
    List<Employe> getByNameId(String name,int id);
    List<Employe> getBySalaryAge(long salary,int age);
    int delete (Employe employe,int id);
    int delete(int id);
    List<Employe> getTwoTables();

    int saveEmployeDetails(Employe employe);

int savePersonalDetails(Details details);
    List<Details> getAllPersonalDetails();
}
