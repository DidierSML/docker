package com.dockercode.docker.controller;

import com.dockercode.docker.entity.DockerEntity;
import com.dockercode.docker.service.DockerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("docker")
public class DockerController {

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

    @GetMapping("getEntityById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DockerEntity> getEntityById (@PathVariable (value = "id") Integer id){

        return dockerService.getEntityById(id);
    }

    @PutMapping("updateEntityById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DockerEntity updateEntityById (@PathVariable (value = "id") Integer id,
                                          @RequestBody DockerEntity dockerEntity){

        return dockerService.updateEntityByID(id, dockerEntity);
    }

    @DeleteMapping("deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteById (@PathVariable (value = "id") Integer id){

        return dockerService.deleteEntityById(id);

    }

    @GetMapping("testAPI")
    @ResponseStatus(HttpStatus.OK)
    public String apiTest (){
        return "Everything is working fine";
    }
}
