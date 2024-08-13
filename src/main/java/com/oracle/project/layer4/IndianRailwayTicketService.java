package com.oracle.project.layer4;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oracle.project.layer2.IndianRailwayTicket;

/*
 
 	@Component		@Component		@Component	
  	@Repository		@Service		@Controller
  	CRUD			BUSINESS		INTERACTION	
  					LOGIC			WITH UI AND
  									SERVICE
 */

@Service
public interface IndianRailwayTicketService 
{
		List<IndianRailwayTicket> findAllRailwayTickets();
		List<IndianRailwayTicket> findRailwayTicketBySource(String source);
		List<IndianRailwayTicket> findRailwayTicketByDestination(String destination);
		List<IndianRailwayTicket> findRailwayTicketAboveTicketCost(int cost);
		IndianRailwayTicket findRailwayTicketById(int id);
		String findPassengerName(int id);
		int findPassengerAge(int id);
		
}
