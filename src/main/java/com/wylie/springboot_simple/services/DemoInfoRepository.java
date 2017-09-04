package com.wylie.springboot_simple.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wylie.springboot_simple.model.mongodb.DemoInfo;

public interface  DemoInfoRepository extends MongoRepository<DemoInfo, String>{

	DemoInfo findByName(String name);

}
