package org.sasanlabs.internal.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author KSASAN preetkaran20@gmail.com
 *
 */
public class JSONSerializationUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static <T> String serialize(T object) throws JsonProcessingException {
		return MAPPER.writeValueAsString(object);
	}

	public static <T> String serializeWithPrettyPrintJSON(T object) throws JsonProcessingException {
		return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

	public static <T> T deserialize(InputStream in, TypeReference<T> typeReference)
			throws JsonParseException, JsonMappingException, IOException {
		return MAPPER.readValue(in, typeReference);
	}
}