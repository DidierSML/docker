package com.dockercode.docker.controller;

import com.dockercode.docker.entity.DockerEntity;
import com.dockercode.docker.service.DockerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("docker")
public class DockerDemoController {

    private final DockerServiceImpl dockerService;

    @PostMapping("saveEntity")
    @ResponseStatus(HttpStatus.CREATED)
    public DockerEntity save (@RequestBody DockerEntity dockerEntity){

        return dockerService.createEntity(dockerEntity);
    }

    @GetMapping("getAllEntities")
    @ResponseStatus(HttpStatus.OK)
    public List <DockerEntity> testMethod(){
        return dockerService.getAllDockerEntities();
    }

    @GetMapping("testAPI")
    @ResponseStatus(HttpStatus.OK)
    public String apiTest (){
        return "Everything is working fine";
    }
}
