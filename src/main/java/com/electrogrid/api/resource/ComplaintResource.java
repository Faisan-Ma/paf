package com.electrogrid.api.resource;

import com.electrogrid.api.model.Complaint;
import com.electrogrid.api.service.ComplaintService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/complaints")
public class ComplaintService {
	
	ComplaintService service = new ComplaintService();
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Complaint addComplaint(Complaint complaint) {
		 return service.addComplaint(complaint);
		
	}


}
