package com.oracle.project.model;

import com.oracle.project.layer2.IndianRailwayTicket;

public class RequiredResponse 
{
	IndianRailwayTicket ticket; //http://localhost:8081/IndianRailwayTickets/123
	NewsPaper paper;			//http://localhost:8082/NewsPapers/101
	
	public IndianRailwayTicket getTicket() {
		return ticket;
	}
	public void setTicket(IndianRailwayTicket ticket) {
		this.ticket = ticket;
	}
	public NewsPaper getPaper() {
		return paper;
	}
	public void setPaper(NewsPaper paper) {
		this.paper = paper;
	}
	
}
