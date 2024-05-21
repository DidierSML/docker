package com.dockercode.docker.repository;

import com.dockercode.docker.entity.DockerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockerRepository extends JpaRepository <DockerEntity,Integer> {

}
