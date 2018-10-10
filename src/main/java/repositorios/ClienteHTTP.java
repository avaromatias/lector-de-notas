package repositorios;

import java.util.ArrayList;
import javax.ws.rs.core.MediaType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import dominio.Asignacion;
import dominio.Estudiante;

//TODO Eliminar esta clase cuando todo ande correctamente

public class ClienteHTTP {
    private Client client;
    private static final String URL = "http://notitas.herokuapp.com";
    private static final String RECURSOESTUDIANTE = "/student";
    private static final String RECURSOMATERIAS = "/student/assignments";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    public ClienteHTTP() {
    	ClientConfig config = new DefaultClientConfig();
        this.client = Client.create(config);
    }
    
    public ClientResponse getBookByFilter(String filter, String value){
        WebResource recurso = this.client.resource(URL).path(RECURSOESTUDIANTE);
        WebResource recursoConParametros = recurso.queryParam("q", filter + ":" + value);
        WebResource.Builder builder = recursoConParametros.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        return response;
    }

    //Prueba de concepto de envio de dos parametros, y el envio de mensajes juntos.
    public ClientResponse getBookByFilter(String filter, String value, String fields){
    	ClientResponse response = this.client.resource(URL).path(RECURSOESTUDIANTE)
                .queryParam("q", filter + ":" + value).queryParam("fields",fields)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        return response;
    }

    public ArrayList<Asignacion> getAsignaciones() {
    	ClientResponse response = this.client.resource(URL).path(RECURSOMATERIAS)
                .header("Authorization", "Bearer "+TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
    	if (response.getStatus() < 200 || response.getStatus() > 299) 
    		throw new RuntimeException("Failed - HTTP error code: " + response.getStatus());	
       String salida = response.getEntity(String.class);
       JsonParser parser = new JsonParser();
       JsonArray arrayAsignaciones = parser.parse(salida).getAsJsonObject().getAsJsonObject("assignments").getAsJsonArray();
       ArrayList <Asignacion> lasAsignaciones = new ArrayList<Asignacion>();
       
       for (JsonElement asignacion : arrayAsignaciones) {
    	    JsonObject objeto = asignacion.getAsJsonObject();
    	   int idTarea = objeto.get("id").getAsInt();
    	   String nombreTarea = objeto.get("title").getAsString();
    	  // Tarea tarea = new Tarea(nombreTarea,)
    	   String descripcion = objeto.get("description").getAsString();
    	   ArrayList<String> listaNotas = new ArrayList<String>();
       }
       
       return lasAsignaciones;
    }
    
    public Estudiante getEstudiante() {
    	ClientResponse response = this.client.resource(URL).path(RECURSOESTUDIANTE)
                .header("Authorization", "Bearer " + TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
    	if (response.getStatus() < 200 || response.getStatus() > 299) 
    		throw new RuntimeException("Failed - HTTP error code: " + response.getStatus());	
       String salida = response.getEntity(String.class);
       JsonParser parser = new JsonParser();
       JsonObject mi = parser.parse(salida).getAsJsonObject();
       int codigo = mi.get("code").getAsInt();
       String nombre = mi.get("first_name").getAsString();
       String apellido = mi.get("last_name").getAsString();
       String usuarioGit = mi.get("github_user").getAsString();
       return new Estudiante(apellido, nombre, codigo, usuarioGit, new ArrayList<>());
    }
}
