package com.revature.charityapprequestorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.charityapprequestorms.model.FundRequest;
import com.revature.charityapprequestorms.model.RequestorTransaction;

@Repository
public interface FundRequestRepository extends JpaRepository<FundRequest, Integer> {
	@Query("SELECT a FROM FundRequest a WHERE a.categoryId = :categoryId")
	public FundRequest findById(@Param("categoryId") int categoryId);
	
	@Query(" from FundRequest where id = :id")
	RequestorTransaction findByTransactionId(Integer id);

}
