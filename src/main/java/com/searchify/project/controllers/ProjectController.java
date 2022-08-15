package com.searchify.project.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.searchify.project.entity.Project;
import com.searchify.project.repositories.ProjectRepository;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @CrossOrigin
    @PostMapping(value = "/add/project")
    public Project saveProject(@RequestBody Project project) {
        return projectRepository.saveProject(project);
    }
    
    @CrossOrigin
    @GetMapping("/get/projects")
    public List<Project> getKeywordById() {
        return projectRepository.getProjects();
    }
    
    @CrossOrigin
    @GetMapping("/get/keywords")
    public Object getKeywords() {
    	 RestTemplate restTemplate = new RestTemplate();
    	 HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.set("accept-version", "1.0.0");
         headers.set("Authorization", "Bearer 8ad19466ef78f8fcbdf9fa1c40b9d2c89f21a1a9fd310d705f6ab693d9848402");
         HttpEntity<String> entity = new HttpEntity<String>(headers);
         return restTemplate.exchange("https://api.webflow.com/collections/61628ac3b06a6765eff1d9cc/items/61628b6c3eb108af858dddec", HttpMethod.GET, entity, String.class).getBody();
    }
    
    @CrossOrigin
    @PutMapping("/update/keywords")
    public Object updateKeywords(@RequestBody Object object) {
    	 RestTemplate restTemplate = new RestTemplate();
    	 HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.set("accept-version", "1.0.0");
         headers.set("Authorization", "Bearer 8ad19466ef78f8fcbdf9fa1c40b9d2c89f21a1a9fd310d705f6ab693d9848402");
         HttpEntity<Object> entity = new HttpEntity<Object>(object, headers);
         
         return restTemplate.exchange("https://api.webflow.com/collections/61628ac3b06a6765eff1d9cc/items/61628b6c3eb108af858dddec", HttpMethod.PUT, entity, String.class).getBody();
    }
    
    @CrossOrigin
    @GetMapping("/get/project/{id}")
    public Project getProjectById(@PathVariable("id") String projectId) {
        return projectRepository.getProjectById(projectId);
    }
    
    @CrossOrigin
    @GetMapping("/get/project/customerId/{customerId}")
    public Project getProjectByCustomerId(@PathVariable("customerId") String customerId) {
        return projectRepository.getProjectByCustomerId(customerId);
    }

    @CrossOrigin
    @DeleteMapping("/delete/project/{id}")
    public String deleteProjectById(@PathVariable("id") String projectId) {
        return  projectRepository.deleteProjectById(projectId);
    }

    @CrossOrigin
    @PutMapping("/update/project/{id}")
    public Project updateProject(@PathVariable("id") String projectId, @RequestBody Project project) {
         String id = projectRepository.updateProject(projectId,project);
         return getProjectById(id);
    }
}
