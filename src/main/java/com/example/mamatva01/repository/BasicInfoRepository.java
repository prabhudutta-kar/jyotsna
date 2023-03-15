package com.example.mamatva01.repository;

import com.example.mamatva01.model.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "basicinfo", path = "basicinfo")
public interface BasicInfoRepository extends JpaRepository<BasicInfo, Integer> {
    public boolean existsById(int motherId);
    public BasicInfo findById(int motherId);
}
