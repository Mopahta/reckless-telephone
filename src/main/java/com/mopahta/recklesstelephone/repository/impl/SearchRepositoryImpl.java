package com.mopahta.recklesstelephone.repository.impl;

import com.mopahta.recklesstelephone.model.Department;
import com.mopahta.recklesstelephone.model.PhoneNumber;
import com.mopahta.recklesstelephone.model.QueriedDetails;
import com.mopahta.recklesstelephone.model.Worker;
import com.mopahta.recklesstelephone.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchRepositoryImpl implements SearchRepository {

    private final EntityManager em;

    private List<Predicate> createPredicateList() {

        return null;
    }

    public List<QueriedDetails> findAll (String fullname, String number, String mail,
                                     String position, String department) {
        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<QueriedDetails> query = criteria.createQuery(QueriedDetails.class);

        Root<Department> departmentTable = query.from(Department.class);
        Join<Department, Worker> workerJoin = departmentTable.join( "workers", JoinType.INNER);
        Join<Department, PhoneNumber> phoneNumberJoin = departmentTable.join( "phoneNumbers", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();

        if (number != null) {
            predicates.add(criteria.like(criteria.upper(phoneNumberJoin.get("telNumber")),
                    "%" + number.toUpperCase() + "%"));
        }

        if (department != null) {
            predicates.add(criteria.like(criteria.upper(departmentTable.get("depName")),
                    "%" + department.toUpperCase() + "%"));
        }

        if (mail != null) {
            predicates.add(criteria.like(
                    criteria.upper(criteria.upper(workerJoin.get("workingMail"))),
                    "%" + mail.toUpperCase() + "%"));
        }

        query.multiselect(
                departmentTable.get("depName"),
                workerJoin.get("workerName"),
                workerJoin.get("workingMail"),
                workerJoin.get("jobTitle"),
                phoneNumberJoin.get("telNumber"),
                phoneNumberJoin.get("isPublic")
        );

        query.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Department> findAll (String fullname, String number, String mail,
                                     String position, String department, boolean getPrivateNumber) {
        CriteriaBuilder criteria = em.getCriteriaBuilder();

        CriteriaQuery<Department> cq = criteria.createQuery(Department.class);

        Root<Department> departmentRoot = cq.from(Department.class);
//        departmentRoot.join("phoneNumbers", JoinType.LEFT);
//        departmentRoot.join("workers", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();


        if (department != null) {
            predicates.add(criteria.like(criteria.upper(departmentRoot.get("depName")),
                    "%" + department.toUpperCase() + "%"));
        }

        System.out.println(departmentRoot.toString());
        if (number != null) {
            predicates.add(criteria.like(
                    departmentRoot.join("phoneNumbers").get("number"), "%" + number + "%"));
            if (!getPrivateNumber) {
                predicates.add(criteria.equal(departmentRoot.join("phoneNumbers")
                        .get("isPublic"), true));
            }
        }


//        cq.where(criteria.and(predicates.toArray(new Predicate[0])));
//        List<Department> phonesQuery = em.createQuery(cq).getResultList();
//
//        predicates.clear();
//        departmentRoot = cq.from(Department.class);

        if (department != null) {
            predicates.add(criteria.like(criteria.upper(departmentRoot.get("depName")),
                    "%" + department.toUpperCase() + "%"));
        }

        if (mail != null) {
            predicates.add(criteria.like(
                    criteria.upper(criteria.upper(departmentRoot.join("workers").get("workingMail"))),
                    "%" + mail.toUpperCase() + "%"));
        }

        if (position != null) {
            predicates.add(criteria.like(criteria.upper(departmentRoot.join("workers").get("position")),
                    "%" + position.toUpperCase() + "%"));
        }

        if (fullname != null) {
            String[] parts = fullname.split(" ");

            for (var part: parts) {
                predicates.add(criteria.like(criteria.upper(departmentRoot.join("workers").get("name")),
                        "%" + part.toUpperCase() + "%" ));
            }
        }

        cq.where(criteria.and(predicates.toArray(new Predicate[0]))).distinct(true);
        return em.createQuery(cq).getResultList();
    }
}
