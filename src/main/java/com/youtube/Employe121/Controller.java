package com.youtube.Employe121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeDao employeDao;
    @Autowired
    private ServiceEmp serviceEmp;

    @GetMapping("/emp")
    public List<Employe> getEmploye() {
        return employeDao.getAll();
    }

    @GetMapping("/emp1")
    public Employe getById(@RequestParam(required = true) int id) {
        return employeDao.getById(id);
    }

    @PostMapping("/postEmp")
    public String saveEmploye(@RequestBody Employe employe) {
        return employeDao.save(employe) + "inserted sucessfully";
    }

    @GetMapping("/listEmp")
    public List<Employe> getByName(@RequestParam(required = true) String name) {
        return employeDao.getByName(name);
    }

    @GetMapping("/emp2")
    public List<Employe> getByNameId(@RequestParam String name, int id) {
        return employeDao.getByNameId(name, id);
    }

    @GetMapping("emp/sal/age")
    public List<Employe> getBySalaryAge(@RequestParam long salary, int age) {
        return employeDao.getBySalaryAge(salary, age);
    }

    @GetMapping("/employeAgeSalaryService")
    public List<Employe> getService(@RequestParam int age, long salary) {
        return serviceEmp.employeService(age, salary);
    }

    @GetMapping("/employeDetails")
    public List<Employe> getTwotables() {
        return employeDao.getTwoTables();
    }

    @PutMapping("/employeUpdation")
    public String updateEmploye(@RequestBody Employe employe, @RequestParam(required = true) int id) {
        return employeDao.update(employe, id) + "Updated sucess fully";
    }

    @DeleteMapping("/delete")
    public Object delete(@RequestBody Employe employe, @RequestParam int id) {
        return serviceEmp.DeleteEmploye(employe, id);
    }
    @DeleteMapping("/deleteById")
    public  int delete(@RequestParam (required = true) int id)
    {
        return employeDao.delete(id);
    }
    @PostMapping("/employeInsertion")
    public String  saveEmployeDetails(@RequestBody Employe employe) {
        return employeDao.saveEmployeDetails(employe)+"Sucessfully inserted";
    }


    @PostMapping("/personalDetails")
    public String savePersonalDetails(@RequestBody Details details) {
        return employeDao.savePersonalDetails(details)+"suscessfully inserted";
    }
    @GetMapping("/getAllPersonalDetails")
    public List<Details> getAllPersonalDetails()
    {
     return employeDao.getAllPersonalDetails();
    }

}
