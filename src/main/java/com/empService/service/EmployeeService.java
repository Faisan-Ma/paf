package com.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dao.*;
import com.model.*;

@Path("/employeedetails")
public class EmployeeService {
	
		@Path("/insert")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		
		public String addemployee(String userdate) throws JsonParseException, JsonMappingException, IOException {

			String str = null;


			try {

				ObjectMapper mapper = new ObjectMapper();
				insertEmployee p = mapper.readValue(userdate, insertEmployee.class);
				str = insertEmployeeDao.InsertEmployee(p);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}


			return str;
		}
		
		
		
		@Path("/deleteemployee")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteemployee(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				deleteEmployee deleteemployee = objectMapper.readValue(s, deleteEmployee.class);

				if (deleteEmployeeDao.DeleteEmployee(deleteemployee) == true) {

					return "Deleted successfully";

				} else {
					return "Error while deleting employee";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}
		
		
		@Path("/updateemployee")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String updateemployee(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				updateEmployee changepowerBean = objectMapper.readValue(s, updateEmployee.class);

				if (updateEmployeeDao.checkempID(changepowerBean) == true
						&& updateEmployeeDao.updateemployeedetails(changepowerBean) == true) {

					return "Updated successfully";

				} else {
					return "“Error while updating employee";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}



}