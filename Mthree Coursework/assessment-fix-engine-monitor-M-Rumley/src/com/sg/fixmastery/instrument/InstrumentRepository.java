package com.sg.fixmastery.instrument;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstrumentRepository extends JpaRepository<Instrument,Long> {
	Collection<Instrument> findByName(String name);
	
	@Query(value = "select * from instrument i where i.NAME = 'Apple Inc.'",nativeQuery=true)
	Collection<Instrument> getApple();
}
