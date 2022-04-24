package com.jersy.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.jersy.bean.PowerInterruptionDeleteBean;
import com.jersy.bean.PowerInterruptionInsertBean;
import com.jersy.bean.PowerInterruptionUpdateBean;

import com.jersy.dao.PowerInterruptionDeleteDao;
import com.jersy.dao.PowerInterruptionInsertDao;
import com.jersy.dao.PowerInterruptionUpdateDao;



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
		
		
		// delete user
		@Path("/deleteinterruptiondetails")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteUser(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				PowerInterruptionDeleteBean powerInterruptionDeleteBean = objectMapper.readValue(s, PowerInterruptionDeleteBean.class);

				if (PowerInterruptionDeleteDao.PowerInterruptionDelete(powerInterruptionDeleteBean) == true) {

					return "user delete successfully";

				} else {
					return "remove failed";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}
		
		// change password
		@Path("/changepower")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String changePassword(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				PowerInterruptionUpdateBean changepowerBean = objectMapper.readValue(s, PowerInterruptionUpdateBean.class);

				if (PowerInterruptionUpdateDao.checkinterruptionid(changepowerBean) == true
						&& PowerInterruptionUpdateDao.updatepowerdetails(changepowerBean) == true) {

					return "change password successfully";

				} else {
					return "password change failed";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}



}
