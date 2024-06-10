package com.smartjava.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjava.demo.model.Author;
import com.smartjava.demo.model.Book;
import com.smartjava.demo.repository.AuthorRepository;
import com.smartjava.demo.resultresponse.MetaDataResponse;
import com.smartjava.demo.resultresponse.ResultRespone;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	
	public ResultRespone create(Author author) {
	    MetaDataResponse metaDataResponse = new MetaDataResponse();
	    ResultRespone response = new ResultRespone();
	    try {
	        // Ensure that each Book in the list has the author set
	        if (author.getBook() != null) {
	            for (Book book : author.getBook()) {
	                book.setAuthor(author);
	            }
	        }

	        // Save the author along with the books
	        Author authorSaved = authorRepository.save(author);

	        metaDataResponse.setCode("200");
	        metaDataResponse.setMessage("Success");
	        metaDataResponse.setNoOfRecords(1);
	        response.setMetaDataResponse(metaDataResponse);
	        response.setResult(authorSaved);
	        return response;

	    } catch (Exception e) {
	        e.printStackTrace();
	        metaDataResponse.setCode("400");
	        metaDataResponse.setMessage("Failed");
	        metaDataResponse.setNoOfRecords(0);
	        response.setMetaDataResponse(metaDataResponse);
	        response.setResult(null);
	        return response;
	    }
	}


	public ResultRespone findAll() {
		MetaDataResponse metaDataResponse=new MetaDataResponse();
		ResultRespone respone=new ResultRespone();
		try {
			metaDataResponse.setCode("200");
			metaDataResponse.setMessage("Success");
			metaDataResponse.setNoOfRecords(authorRepository.findAll().size());
			respone.setMetaDataResponse(metaDataResponse);
			respone.setResult(authorRepository.findAll());
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
