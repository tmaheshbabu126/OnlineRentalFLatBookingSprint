package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Flat;
import com.advice.FlatNotFoundException;

public interface IFlatRepository extends JpaRepository <Flat,Integer> {


	

}
