package com.oracle.project.layer4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.project.layer2.IndianRailwayTicket;
import com.oracle.project.layer3.TicketRepository;

@Service
public class IndianRailwayTicketServiceImpl implements IndianRailwayTicketService
{
	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public List<IndianRailwayTicket> findRailwayTicketBySource(String source) 
	{
		boolean found=false;
		List<IndianRailwayTicket> sourceCityList=new ArrayList<IndianRailwayTicket>();
		Iterable<IndianRailwayTicket> allTickets=ticketRepository.findAll();
		for (IndianRailwayTicket indianRailwayTicket : allTickets) 
		{
			if(indianRailwayTicket.getSourceCity().equalsIgnoreCase(source)) {
				sourceCityList.add(indianRailwayTicket);
				found=true;
			}
		}
		
		if(found)
			return sourceCityList;
		else
			throw new RuntimeException("Source city not found");
		
	}

	@Override
	public List<IndianRailwayTicket> findRailwayTicketByDestination(String destination) {
		boolean found=false;
		List<IndianRailwayTicket> destinationCityList=new ArrayList<IndianRailwayTicket>();
		Iterable<IndianRailwayTicket> allTickets=ticketRepository.findAll();
		for (IndianRailwayTicket indianRailwayTicket : allTickets) 
		{
			if(indianRailwayTicket.getDestinationCity().equalsIgnoreCase(destination)) {
				destinationCityList.add(indianRailwayTicket);
				found=true;
			}
		}
		if(found)
			return destinationCityList;
		else
			throw new RuntimeException("Destination city not found");
		
	}

	@Override
	public List<IndianRailwayTicket> findRailwayTicketAboveTicketCost(int cost) {
		boolean found=false;
		List<IndianRailwayTicket> aboveCostList=new ArrayList<IndianRailwayTicket>();
		Iterable<IndianRailwayTicket> allTickets=ticketRepository.findAll();
		for (IndianRailwayTicket indianRailwayTicket : allTickets) 
		{
			if(indianRailwayTicket.getTicketCost()>=cost) {
				aboveCostList.add(indianRailwayTicket);
				found=true;
			}
		}
		if(found)
			return aboveCostList;
		else
			throw new RuntimeException("No tickets found above the mentioned cost");
		
	}

	@Override
	public IndianRailwayTicket findRailwayTicketById(int id) 
	{
		IndianRailwayTicket thisTkt;
		Optional<IndianRailwayTicket> tkt=null;
		tkt=ticketRepository.findById(id);
		if(tkt.isPresent())
		{
			thisTkt=tkt.get();
			return thisTkt;
		}

		else
			throw new RuntimeException("No ticket found with the mentioned ID (ID): "+id);
		
	}

	@Override
	public String findPassengerName(int id) {
		IndianRailwayTicket thisTkt;
		Optional<IndianRailwayTicket> tkt=null;
		tkt=ticketRepository.findById(id);
		if(tkt.isPresent())
		{
			thisTkt=tkt.get();
			return thisTkt.getPassengerName();
		}

		else
			throw new RuntimeException("No ticket found with the mentioned ID (Name): "+id);
		
	}

	@Override
	public int findPassengerAge(int id) {
		IndianRailwayTicket thisTkt;
		Optional<IndianRailwayTicket> tkt=null;
		tkt=ticketRepository.findById(id);
		if(tkt.isPresent())
		{
			thisTkt=tkt.get();
			return thisTkt.getAge();
		}

		else
			throw new RuntimeException("No ticket found with the mentioned ID (Age): "+id);
		
	}

	@Override
	public List<IndianRailwayTicket> findAllRailwayTickets() {

		//List<IndianRailwayTicket> allTickets=new ArrayList<IndianRailwayTicket>();
		Iterable<IndianRailwayTicket> allTickets=ticketRepository.findAll();
		if(allTickets!=null)
			return (List<IndianRailwayTicket>) allTickets;
		else
			throw new RuntimeException("Tickets not found");
		
	}

}
