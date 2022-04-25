package com.electrogrid.api.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electrogrid.api.model.Complaint;
import com.electrogrid.api.service.ComplaintService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
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

	@Path("/getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Complaint>  getComplaint() throws SQLException {
		 return service.getComplaint();
		
	}

	@Path("/getById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Complaint>  getComplaint(@PathParam("id") int id) throws SQLException {
		return service.getComplaintById(id);
		
	}

	@Path("/updateComplaint")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Complaint updateComplaint(Complaint complaint) {
		 return service.updatetcomplaint(complaint);
		
	}

	@Path("/deleteComplaintById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteComplaint(@PathParam("id") int id) {
		return service.deletetComplaint(id);
		
	}
}
