package com.mopahta.recklesstelephone.repository;

import com.mopahta.recklesstelephone.model.Department;

import java.util.List;

public interface SearchRepository {
    List<Department> findAll (String fullname, String number, String mail, String position,
                              String department, boolean getPrivateNumber);
}
