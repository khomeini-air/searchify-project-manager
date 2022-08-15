package com.searchify.project.entity;

import java.io.Serializable;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class Tracking implements Serializable {

	private static final long serialVersionUID = 1L;

	@DynamoDBAttribute
    private String index;
	
    @DynamoDBAttribute
    private String name;
    
    @DynamoDBAttribute
    private String type;

    @DynamoDBAttribute
    private Map<String,String> values;


}