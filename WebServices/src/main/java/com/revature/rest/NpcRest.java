package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.beans.Npc;

/*
 * Path annotation denotes what url will be used to access this class's
 * rest methods. Typical path includes the ip & port for the server. 
 * After that you provide the name of the project (which is wither the artifact ID
 * as indicated in the pom file, or 
 * <build>
 * <finalName>ProjectName</finalName>
 * 
 * Followed by whatever url pattern provided in the web.xml under the dispatched
 * servlet for Jersey. (In this case we wrote /rest/*).
 * Convention suggests you have at least something to seperate rest endpoints from
 * actual server url mappings
 */

@Path("/npc")
public class NpcRest {
	public static List<Npc> npcs;
	
	public NpcRest() {
		npcs = new ArrayList<>();
		npcs.add(new Npc(1,"Bobbert","Professional Bob", 9999999));
	}
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	//http://localhost:8085/WebServices/rest/npc/get/all
	public List<Npc> getAllNpcs(){
		
		return npcs;
	}
	
	@GET
	@Path("/get/{arrayListIndex}")
	@Produces(MediaType.APPLICATION_JSON)
	public Npc getNpcById(@PathParam("arrayListIndex")int index) {
		if((npcs.size() < 1) || index >= npcs.size()) {
			return null;
		}else {
			return npcs.get(index);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post")
	public String insertNpc(Npc npc) {
		npcs.add(npc);
		return "success!";
	}
}

