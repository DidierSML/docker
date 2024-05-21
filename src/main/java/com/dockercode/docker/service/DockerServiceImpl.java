package com.dockercode.docker.service;


import com.dockercode.docker.entity.DockerEntity;
import com.dockercode.docker.repository.DockerRepository;
import jakarta.persistence.EntityNotFoundException;
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

        Optional <DockerEntity> isExisting = getDockerEntityById(id);

        if(isExisting.isPresent()){

            DockerEntity entityExisting = isExisting.get();

            entityExisting.setCenterName(dockerEntity.getCenterName());
            entityExisting.setCenterCountry(dockerEntity.getCenterCountry());

            return dockerRepository.save(entityExisting);
        }else{
            throw new EntityNotFoundException("La entidad con dicho ID no existe en la BD");
        }

    }

    @Override
    public String deleteEntityById(Integer id) {
        return null;
    }
}
