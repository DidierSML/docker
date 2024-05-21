package com.dockercode.docker.service;


import com.dockercode.docker.entity.DockerEntity;
import com.dockercode.docker.repository.DockerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<DockerEntity> getDockerEntityById(Integer id) {

         return dockerRepository.findById(id);
    }

    @Override
    public DockerEntity updateEntityByID(Integer id, DockerEntity dockerEntity) {
        return null;
    }

    @Override
    public String deleteEntityById(Integer id) {
        return null;
    }
}
