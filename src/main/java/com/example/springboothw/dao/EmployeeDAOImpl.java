package com.example.springboothw.dao;

import com.example.springboothw.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        return entityManager.createQuery("FROM Employee").getResultList();
    }


    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void add(Employee employee) {
        Employee employee1 = employee;
        employee1.setId(null);
        Employee employeeNew = entityManager.merge(employee);
        employee.setId(employeeNew.getId());
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void removeById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee where id=:id"); //javax.persistence.Query;;
        query.setParameter("id", id);
        query.executeUpdate();
    }
}