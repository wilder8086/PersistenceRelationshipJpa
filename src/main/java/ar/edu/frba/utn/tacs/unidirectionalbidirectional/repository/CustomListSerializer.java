package ar.edu.frba.utn.tacs.unidirectionalbidirectional.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Medal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomListSerializer extends StdSerializer<List<Medal>>{
	 
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomListSerializer() {
	        this(null);
	    }
	 
	    public CustomListSerializer(Class<List<Medal>> t) {
	        super(t);
	    }
	 
	    @Override
	    public void serialize(List<Medal> medals, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
	         
	        List<Long> ids = new ArrayList<Long>();
	        for (Medal medal : medals) {
	            ids.add(medal.getId());
	        }
	        generator.writeObject(ids);
	    }
	}
