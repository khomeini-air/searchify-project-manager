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
public class Webpage implements Serializable {

	private static final long serialVersionUID = 1L;

	@DynamoDBAttribute
    private String id;
	
	@DynamoDBAttribute
    private String templateId;
	
    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String url;
    
    @DynamoDBAttribute
    private String ranking;
    
    @DynamoDBAttribute
    private Suggestion currentSuggestion;
    
    @DynamoDBAttribute
    private List<Suggestion> revisions;
    
    @DynamoDBAttribute
    private Map<String, String> settings;
    
    @DynamoDBAttribute
    private List<FieldContent> fieldContents;
    
    @DynamoDBAttribute
    private List<Answer> answers;
    
    @DynamoDBAttribute
    private Map<String, List<Tracking>> gaTrackings;
}