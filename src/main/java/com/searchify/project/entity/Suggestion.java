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
public class Suggestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@DynamoDBAttribute
    private String createdDate;
    
    @DynamoDBAttribute
    private List<FieldContent> fieldContents;
  
}