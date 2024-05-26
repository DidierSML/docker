package com.dockercode.docker.service;

import com.dockercode.docker.entity.DockerEntity;

import java.util.List;
import java.util.Optional;

public interface DockerService {

    DockerEntity createEntity (DockerEntity dockerEntity);

    List<DockerEntity> getAllDockerEntities ();

    Optional<DockerEntity> getEntityById (Integer id);

    DockerEntity updateEntityByID (Integer id, DockerEntity dockerEntity);

    String deleteEntityById (Integer id);
}
