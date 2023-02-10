package com.youtube.Employe121;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TwoTablesMapper implements RowMapper<Employe> {
    @Override
    public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {


        Employe emp=new Employe();
        emp.setId(rs.getInt("Employe.Id"));
        emp.setAddress(rs.getString("employe.Address"));
        emp.setAge(rs.getInt("employe.Age"));
        emp.setEmail(rs.getString("employe.Email"));
        emp.setSalary(rs.getLong("employe.Salary"));
        Details pd=new Details();
        pd.setId(rs.getInt("PersonalDetails.Id"));
        pd.setPanCard(rs.getString("personalDetails.PanCard"));
       // pd.setDateOfBirth(rs.getDate("PersonalDetails.DateOfBirth"));

//.setPersonalDetails(pd);


        return emp;
    }
}
