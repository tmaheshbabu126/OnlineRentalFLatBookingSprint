package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Flat;
import com.advice.FlatNotFoundException;
import com.service.IFlatService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping(path="/Flat")
public class IFlatController {
	
	@Autowired
	IFlatService iflatservice;
	

	  
	
	  @GetMapping(path="/view") 
	  public ResponseEntity<List<Flat>> viewAllFlat()
	  {
		  List<Flat> fa1=iflatservice.viewAllFlat();
	  ResponseEntity<List<Flat>> rf=new ResponseEntity<List<Flat>>(fa1,HttpStatus.OK);
	  return rf;
	
	  }
	  
	  @PostMapping("/add")
		public ResponseEntity<Flat> addFlat( @RequestBody Flat fa)
		{

			Flat fa1=iflatservice.addFlat(fa);
			
			ResponseEntity<Flat> rt=new ResponseEntity<Flat>(fa1,HttpStatus.OK);
			return rt;
		}
	
	  @PutMapping(path="/update")
		public ResponseEntity<Flat> updateTenant( @RequestBody Flat flat) throws Exception
		{
			Flat t1=iflatservice.updateFlat(flat);
			
			ResponseEntity<Flat> re=new ResponseEntity<Flat>(t1,HttpStatus.OK);
			return re;
		}

	  @GetMapping(path="/view/{tid}")
		public ResponseEntity<Flat> viewFlat(@PathVariable  int id) throws Exception
		{
		  System.out.println("in controller ");
			Flat le=iflatservice.viewFlat(id);
			
			ResponseEntity<Flat> re=new ResponseEntity<Flat>(le,HttpStatus.OK);
			return re;
		}
	
	  @DeleteMapping(path="/delete")
		public ResponseEntity<String> deleteFlat(@RequestBody Flat flat) throws Exception
		{
			String res =iflatservice.deleteFlat(flat);

			ResponseEntity<String> re=new ResponseEntity<String>(res,HttpStatus.OK);
			return re;
		}
	
	  

	
	
	

}