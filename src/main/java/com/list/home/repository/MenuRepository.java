package com.list.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.list.home.Model.Menu;

@Repository
public interface  MenuRepository extends JpaRepository<Menu, Long> {
	  
	//親
	// parent_id가 0인 메뉴들을 정렬해서 가져오기
   // List<Menu> findByParentIdOrderByArrangeAsc(Long parentId);
	//子
 // 특정 parentId에 해당하는 자식 메뉴들 가져오기
   // List<Menu> findByParentId(Long parentId);
}
