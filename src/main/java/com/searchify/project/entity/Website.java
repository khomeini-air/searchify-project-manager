package com.searchify.project.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class Website implements Serializable {

	private static final long serialVersionUID = 1L;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String url;
    
    @DynamoDBAttribute
    private String tokenId;
    
    @DynamoDBAttribute
    private String ranking; 
    
    @DynamoDBAttribute
    private Map<String, String> settings;
    
    @DynamoDBAttribute
    private List<Template> templates;
    
    @DynamoDBAttribute
    private List<Webpage> webpages;
}