package com.dockercode.docker.service;


import com.dockercode.docker.entity.DockerEntity;
import com.dockercode.docker.repository.DockerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DockerServiceImpl implements DockerService{

    private final DockerRepository dockerRepository;


    @Override
    public DockerEntity createEntity(DockerEntity dockerEntity) {

        DockerEntity entity = dockerRepository.save(dockerEntity);

        return entity;
    }

    @Override
    public List<DockerEntity> getAllDockerEntities() {

        List <DockerEntity> dockerEntityList = dockerRepository.findAll();

        return dockerEntityList;
    }
}
