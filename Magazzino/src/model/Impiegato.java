package model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

public class Impiegato {
	private String id;
	private String password;
	private String ruolo;
	
	public Impiegato(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getRuolo() {
		return this.ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String accedi(String id, String password) throws JSONException, FileNotFoundException,IOException,ParseException{
		boolean success = false;
		int i = 0;
		String ruolo = null;
		String idFound = null;
		String passwordFound = null;
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("src/data/Impiegato.json"));
		while (!success && i < array.size()) {
			JSONObject jsonObj = (JSONObject) array.get(i);
			idFound = (String) jsonObj.get("id");
			passwordFound = (String) jsonObj.get("password");
			if (idFound.equals(id) && (passwordFound.equals(password))) {
				success = true;
				ruolo = (String) jsonObj.get("ruolo");
			}
			i++;
		}
	
		return ruolo;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode() + password.hashCode() + ruolo.hashCode();
	}
}
