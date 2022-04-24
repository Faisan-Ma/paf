package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jersy.bean.PowerInterruptionInsertBean;
import com.jersy.dao.PowerInterruptionInsertDao;


@Path("/powerinterruptiondetails")
public class PowerInterruptionService {
	
		@Path("/insert")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		
		public String registerUser(String userdate) throws JsonParseException, JsonMappingException, IOException {

			String str = null;


			try {

				ObjectMapper mapper = new ObjectMapper();
				PowerInterruptionInsertBean p = mapper.readValue(userdate, PowerInterruptionInsertBean.class);
				str = PowerInterruptionInsertDao.PowerInterruptionInsert(p);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}


			return str;
		}

}
