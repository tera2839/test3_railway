package com.quickshift.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickshift.entity.Calendar;
import com.quickshift.entity.MemberRequest;
import com.quickshift.entity.Store;
import com.quickshift.entity.Timeplan;

@Repository
public interface MemberRequestRepository extends JpaRepository<MemberRequest, Long>{
	List<MemberRequest> findByCalendarAndStoreAndTimeplan(Calendar calendar, Store store, Timeplan timeplan);
}