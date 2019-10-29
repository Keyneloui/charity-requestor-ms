package com.revature.charityapprequestorms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.charityapprequestorms.model.RequestorTransaction;

@Repository
public interface RequestorTransactionRepository extends JpaRepository<RequestorTransaction,Integer> {
	@Query(" from RequestorTransaction where id = :id")
	RequestorTransaction findByTransactionId(Integer id);
	

}
