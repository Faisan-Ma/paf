package mavan.assign.service;


	
	import java.io.IOException;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	import org.codehaus.jackson.JsonParseException;
	import org.codehaus.jackson.map.JsonMappingException;
	import org.codehaus.jackson.map.ObjectMapper;

	import mavan.assign.com.Powerunit;
import mavan.assign.dao.PowerUnitInsert;
import mavan.assign.DB.DbConnect;


	@Path("/Powerunit")
	public class PowerUnitService {
		
			@Path("/insert")
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			
			public String registerUser(String userdate) throws JsonParseException, JsonMappingException, IOException {

				String str = null;


				try {

					ObjectMapper mapper = new ObjectMapper();
					Powerunit p = mapper.readValue(userdate,  Powerunit.class);
					str =  PowerUnitInsert.Powerunit(p);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}


				return str;
			}


}
