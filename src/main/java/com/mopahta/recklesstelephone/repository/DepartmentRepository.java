package com.mopahta.recklesstelephone.repository;

import com.mopahta.recklesstelephone.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepName(String name);
}
