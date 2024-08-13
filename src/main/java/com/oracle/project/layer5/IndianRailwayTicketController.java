package com.oracle.project.layer5;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.project.layer2.IndianRailwayTicket;

@RestController

public interface IndianRailwayTicketController 
{
	ResponseEntity<List<IndianRailwayTicket>> getAll();
	ResponseEntity<IndianRailwayTicket> getById(int id);
}
