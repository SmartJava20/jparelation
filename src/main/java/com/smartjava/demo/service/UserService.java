package com.smartjava.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjava.demo.model.User;
import com.smartjava.demo.repository.UserRepository;
import com.smartjava.demo.resultresponse.MetaDataResponse;
import com.smartjava.demo.resultresponse.ResultRespone;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public ResultRespone create(User user) {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		
		try {
			User userSave=userRepository.save(user);
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("record save succesffull in database");
			metaDataResponse.setNoOfRecords(1);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(userSave);
			return respone;
		} catch (Exception e) {
			metaDataResponse.setCode("401");
			metaDataResponse.setMessage("failed to save records");
			metaDataResponse.setNoOfRecords(0);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(null);
			return respone;
		}
	}

	public ResultRespone getById(int id) {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		
		try {
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("get records from database for perticuler id");
			metaDataResponse.setNoOfRecords(1);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(userRepository.findById(id));
			return respone;
		} catch (Exception e) {
			metaDataResponse.setCode("401");
			metaDataResponse.setMessage("failed to fetch records");
			metaDataResponse.setNoOfRecords(0);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(null);
			return respone;
		}
	}

	public ResultRespone update(int id, User user) {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		
		try {
			Optional<User> userSave=userRepository.findById(id);
			User userData=userSave.get();
			userData.setUserName(user.getUserName());
			userData.setProfile(user.getProfile());
			User userUpdate=userRepository.save(userData);
			
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("records upadate");
			metaDataResponse.setNoOfRecords(1);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(userUpdate);
			return respone;
		} catch (Exception e) {
			metaDataResponse.setCode("401");
			metaDataResponse.setMessage("failed to update records");
			metaDataResponse.setNoOfRecords(0);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(null);
			return respone;
		}
	}

}
