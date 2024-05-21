package com.dockercode.docker.service;


import com.dockercode.docker.entity.DockerEntity;

import java.util.List;

public interface DockerService {

    DockerEntity createEntity (DockerEntity dockerEntity);

    List<DockerEntity> getAllDockerEntities ();
}
