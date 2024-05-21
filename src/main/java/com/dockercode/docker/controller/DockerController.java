package com.dockercode.docker.controller;

import com.dockercode.docker.entity.DockerEntity;
import com.dockercode.docker.service.DockerServiceImpl;
import jakarta.persistence.EntityNotFoundException;
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
    public DockerEntity getEntityById (@PathVariable (value = "id") Integer id){

        Optional <DockerEntity> object = dockerService.getDockerEntityById(id);

        if(object.isPresent()){
            return object.get();
        }else{
            throw new EntityNotFoundException("La entidad no existe en nuestra BD");
        }
    }

    @PutMapping("updateEntityById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DockerEntity updateEntityById (@PathVariable (value = "id") Integer id,
                                          @RequestBody DockerEntity dockerEntity){

        return dockerService.updateEntityByID(id, dockerEntity);
    }

    @GetMapping("testAPI")
    @ResponseStatus(HttpStatus.OK)
    public String apiTest (){
        return "Everything is working fine";
    }
}
