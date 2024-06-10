package com.smartjava.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjava.demo.model.Profile;
import com.smartjava.demo.model.User;
import com.smartjava.demo.repository.ProfileRepository;
import com.smartjava.demo.resultresponse.MetaDataResponse;
import com.smartjava.demo.resultresponse.ResultRespone;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	public ResultRespone create(Profile profile) {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		
		try {
			Profile profileSave=profileRepository.save(profile);
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("record save succesfully in database");
			metaDataResponse.setNoOfRecords(1);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(profileSave);
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
			respone.setResult(profileRepository.findById(id));
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

	public ResultRespone update(int id, Profile profile) {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		
		try {
			Optional<Profile> profileSave=profileRepository.findById(id);
			Profile profileData=profileSave.get();
			profileData.setFirstName(profile.getFirstName());
			profileData.setLastName(profile.getFirstName());
			profileData.setUser(profile.getUser());
			
		 Profile profileUpdate	=profileRepository.save(profileData);
			
			
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("records Updated");
			metaDataResponse.setNoOfRecords(1);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(profileUpdate);
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
