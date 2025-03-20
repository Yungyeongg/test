package com.list.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.list.home.Model.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
