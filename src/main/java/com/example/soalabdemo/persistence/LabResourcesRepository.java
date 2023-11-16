package com.example.soalabdemo.persistence;

import com.example.soalabdemo.entity.LabResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "labResourcesRepository")
public interface LabResourcesRepository extends JpaRepository<LabResources, Integer> {
    LabResources getLabResourcesByResourceName(String resourceName);
}
