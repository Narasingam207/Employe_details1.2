package com.youtube.Employe121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeDaoImp implements EmployeDao{

@Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Employe> getAll() {
     return   jdbcTemplate.query("Select * from EMPLOYE;",new BeanPropertyRowMapper<Employe>(Employe.class));
    }

    @Override
    public Employe getById(int id) {
        return jdbcTemplate.queryForObject("select * from employe where id=?",new BeanPropertyRowMapper<Employe>(Employe.class),id);
    }

    @Override
    public List<Employe> getByName(String name) {
        return jdbcTemplate.query("select * from EMPLOYE  where name=?",new BeanPropertyRowMapper<Employe>(Employe.class),name);
    }

    @Override
    public int save(Employe employe) {
        return (jdbcTemplate.update("insert into employe (address,email,name) values(?, ?, ?)" , new Object[]{employe.getAddress(),employe.getEmail(),employe.getName()}));
    }

    @Override
    public int update(
            Employe employe,int id) {
        return jdbcTemplate.update("update employe set address=?, email=?, name=? where id=?",new Object[]{employe.getAddress(),employe.getEmail(),employe.getName(),id});
    }

    @Override
    public List<Employe> getByNameId(String name, int id) {
        return jdbcTemplate.query("select * from EMPLOYE WHERE NAME=? AND ID=?",new BeanPropertyRowMapper<Employe>(Employe.class),name,id);
    }

    @Override
    public List<Employe> getBySalaryAge(long salary, int age) {
        return jdbcTemplate.query("select * from EMPLOYE WHERE SALARY>=? AND AGE>=?",new BeanPropertyRowMapper<Employe>(Employe.class),salary,age);
    }

    @Override
    public int delete( Employe employe,int id) {
        return jdbcTemplate.update("DELETE FROM EMPLOYE WHERE ID=?",id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM EMPLOYE WHERE ID=?",id);
    }

    @Override
    public List<Employe> getTwoTables() {
        return jdbcTemplate.query("SELECT * FROM employe JOIN personal_details ON employe.id=personal_details.id",new TwoTablesMapper());
    }

    @Override
    public int saveEmployeDetails(Employe employe) {
        return (jdbcTemplate.update("insert into employe (name,age,salary,email,address) values(?, ?, ?, ?, ?)",new Object[]{employe.getName(),employe.getAge(),employe.getSalary(),employe.getEmail(),employe.getAddress()}));
    }

    @Override
    public int savePersonalDetails(Details details) {
        return (jdbcTemplate.update("insert into details (emp_date_of_birth,emp_pan_card) values(?, ?)",new Object[]{details.getDateOfBirth(), details.getPanCard()}));
    }

    @Override
    public List<Details> getAllPersonalDetails() {
        return (jdbcTemplate.query("select * from details;",new BeanPropertyRowMapper<Details>(Details.class)));
    }


}
