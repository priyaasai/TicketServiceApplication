package com.oracle.project.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.project.layer2.IndianRailwayTicket;
import com.oracle.project.layer4.IndianRailwayTicketService;

@RestController
@RequestMapping("/IndianRailwayTickets")

public class IndianRailwayTicketControllerImpl implements IndianRailwayTicketController
{
	@Autowired
	IndianRailwayTicketService indianRailwayTicketService;
	
	@GetMapping //http://localhost:8080/IndianRailwayTickets
	public ResponseEntity<List<IndianRailwayTicket>> getAll() 
	{
		List<IndianRailwayTicket> allTkts=indianRailwayTicketService.findAllRailwayTickets();
		return new ResponseEntity<>(allTkts,HttpStatus.OK);
		
	}
	
	@GetMapping("/{tid}") //http://localhost:8080/IndianRailwayTickets/124
	
	public ResponseEntity<IndianRailwayTicket> getById(@PathVariable int tid) 
	{
		IndianRailwayTicket thisTkt=indianRailwayTicketService.findRailwayTicketById(tid);
		return new ResponseEntity<>(thisTkt,HttpStatus.OK);
		
	}

}
