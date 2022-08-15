package com.searchify.project.repositories;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.searchify.project.entity.Project;

@Repository
public class ProjectRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Project saveProject(Project project) {
        dynamoDBMapper.save(project);
        return project;
    }
    
    public List<Project> getProjects(){
    	List<Project> scanResult = dynamoDBMapper.scan(Project.class, new DynamoDBScanExpression());
    	((PaginatedList<Project>) scanResult).loadAllResults();//Eagerly loads all results for this list.
    	//Total results loaded into the list
    	System.out.println(scanResult.size());
		return scanResult;
    }


    public Project getProjectById(String projectId) {
        return dynamoDBMapper.load(Project.class, projectId);
    }
    
    public Project getProjectByCustomerId(String customerId) {
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(customerId));

		DynamoDBScanExpression queryExpression = new DynamoDBScanExpression()
		    .withFilterExpression("customerId = :v1")
		    .withExpressionAttributeValues(eav);
		 List<Project> result = dynamoDBMapper.scan(Project.class, queryExpression);
		 if(result!=null && !result.isEmpty() ) {
			 Project project = result.get(0);
			 return project;
			 
		 }
		 return null;
	}


    public String deleteProjectById(String projectId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Project.class, projectId));
        return "Project Id : "+ projectId +" Deleted!";
    }

    public String updateProject(String projectId, Project project) {
        dynamoDBMapper.save(project,
                new DynamoDBSaveExpression()
        .withExpectedEntry("projectId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(projectId)
                )));
        return projectId;
    }
}