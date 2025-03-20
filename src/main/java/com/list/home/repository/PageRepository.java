package com.list.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.list.home.Model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{

	Optional<Page> findByTitle(String title);
}
