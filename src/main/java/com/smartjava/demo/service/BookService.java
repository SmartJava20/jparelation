package com.smartjava.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjava.demo.model.Author;
import com.smartjava.demo.model.Book;
import com.smartjava.demo.repository.BookRepository;
import com.smartjava.demo.resultresponse.MetaDataResponse;
import com.smartjava.demo.resultresponse.ResultRespone;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public ResultRespone create(Book book) {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		try {
			Book bookSave=bookRepository.save(book);
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("Success");
			metaDataResponse.setNoOfRecords(1);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(bookSave);
			return respone;
			
		} catch (Exception e) {
			metaDataResponse.setCode("400");
			metaDataResponse.setMessage("Failed");
			metaDataResponse.setNoOfRecords(0);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(null);
			return respone;
		}
	}

	public ResultRespone findAll() {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		try {
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("Success");
			metaDataResponse.setNoOfRecords(bookRepository.findAll().size());
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(bookRepository.findAll());
			return respone;
			
		} catch (Exception e) {
			metaDataResponse.setCode("400");
			metaDataResponse.setMessage("Failed");
			metaDataResponse.setNoOfRecords(0);
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(null);
			return respone;
		}
	}


}
