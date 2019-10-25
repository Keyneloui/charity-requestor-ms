package com.revature.charityapprequestorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.charityapprequestorms.model.RequestorTransaction;

@Repository
public interface RequestorTransactionRepository extends JpaRepository<RequestorTransaction,Integer> {

}
