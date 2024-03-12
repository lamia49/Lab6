package com.example.lab6.Controller;

import ch.qos.logback.core.util.DelayStrategy;
import com.example.lab6.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class ControllerEmployee {
    ArrayList<Employee> employees = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Employee> get() {
        return employees;
    }

    @PostMapping("/add")

    public ResponseEntity add(@RequestBody @Valid Employee employee, Errors error) {
        if (error.hasErrors()) {
            String massge = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massge);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body("added");
    }

    @PutMapping("/update/{index}")
    public ResponseEntity upadet(@PathVariable int index, @RequestBody @Valid Employee employee, Errors error) {
        if (error.hasErrors()) {
            String massege = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body("Updated");
    }


    @DeleteMapping("/delete/{index}")
    public ResponseEntity delete(@PathVariable int index) {
                employees.remove(index);
        return ResponseEntity.status(200).body("Deleted");
    }

    @GetMapping("/search/{postion}")

    public ResponseEntity<String> search(@PathVariable String postion) {
        ArrayList<Employee> em = new ArrayList<>();
        if (postion.equalsIgnoreCase("supervisor") || postion.equalsIgnoreCase("coordinator")) {
            for (Employee employe : employees) {
                if (employe.getPostion().equalsIgnoreCase(postion)) {
                    em.add(employe);
                }
            }
            return ResponseEntity.status(200).body(em.toString());
        }
        return ResponseEntity.status(400).body("faild postion");
    }

    @GetMapping("/searchbyage/{age}")

    public ResponseEntity<String> age(@PathVariable int age) {
        ArrayList<Employee> employees1 = new ArrayList<>();
        if (age < 25) {
            ResponseEntity.status(400).body("age must be more then 25");
        }
        for (Employee em : employees) {
            if (em.getAge() == age) {
                employees1.add(em);
            }
        }
        return ResponseEntity.status(200).body(employees1.toString());
    }

    @PutMapping("/anuualyear/{id}")
    public ResponseEntity anuulayear(@PathVariable String id) {
        for (Employee employee1 : employees) {
            if (employee1.getId().equalsIgnoreCase(id)) {
                if (employee1.isOnLeave()) {
                    return ResponseEntity.status(400).body("Employye onLeave");
                } else if (1 > employee1.getAnnualLeave()) {
                    return ResponseEntity.status(400).body("Employee does't have enough anuul year");
                } else
                    employee1.setAnnualLeave(employee1.getAnnualLeave() - 1);
                employee1.setOnLeave(true);
                return ResponseEntity.status(200).body("applyed");
            }
        }
        return ResponseEntity.status(400).body("Not found");
    }

    @GetMapping("/anuualyear/onleave")
    public List anuulyyearEmp() {
        ArrayList<Employee> employess = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.isOnLeave()) {
                employess.add(employee);
            }
        }
        return employess;
    }

    @PutMapping("/promote/{id1},{id2}")

    public ResponseEntity Promote(@PathVariable String id1, @PathVariable String id_2) {
        for (Employee employee1 : employees) {
            if (employee1.getId().equalsIgnoreCase(id1)) {
                if (employee1.getPostion().equalsIgnoreCase("supervisor")) {
                    for (Employee employee2 : employees) {
                        if (employee2.getId().equalsIgnoreCase(id_2)) {
                            if (employee2.getAge() < 30) {
                                return ResponseEntity.status(400).body("must be 30 to be supervisor ");
                            } else if (employee2.isOnLeave()) {
                                return ResponseEntity.status(400).body("employee is onLeave");
                            } else
                                employee2.setPostion("supervisor");
                        }return ResponseEntity.status(400).body("Not found id2");
                    }
                } return ResponseEntity.status(400).body("your not allowed");
            }return ResponseEntity.status(400).body("Not found id1");
        }
        return ResponseEntity.status(200).body("apllayed");
    }
}













