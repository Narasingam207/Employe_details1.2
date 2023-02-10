package com.youtube.Employe121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceEmp {
    @Autowired
    private EmployeDaoImp employeDaoImp;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employe> employeService(int age, long salary) {
        ArrayList<Employe> employes = new ArrayList<>();

        List<Employe> d1 = employeDaoImp.getAll();
        for (Employe w : d1) {
            if ((w.getAge() > age) && (w.getSalary() > salary)) {
                employes.add(w);
            }
        }
        return employes;
    }

    public Object DeleteEmploye(Employe employe, int id) {
        Employe d2 = employeDaoImp.getById(id);
        if (d2.getName().equals(employe.getName())) {
          return jdbcTemplate.update("DELETE FROM EMPLOYE WHERE ID=?",id)+"deleted sucess fully";
        }
        else
        {
            return "User not Allowed to delete";
        }
    }
}






