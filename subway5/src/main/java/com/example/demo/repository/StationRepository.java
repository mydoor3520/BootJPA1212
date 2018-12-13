package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long>{
	//JPQL, NativeQuery 없이 Like검색을 메소드 규칙으로 수행
	List<Station> findByNameIgnoreCaseContainingOrderByNo(String name);

	List<Station> findByAreaIgnoreCaseContainingOrderByNoAsc(String area);

	List<Station> findByLineIgnoreCaseContainingOrderByNoAsc(String line);
	
	
}
