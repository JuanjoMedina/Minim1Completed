package edu.upc.dsa.services;


import edu.upc.dsa.*;
import edu.upc.dsa.models.Producte;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(value = "/manager", description = "Endpoint to Track Service")
@Path("/manager")
public class ProductServices {

    private ProductManager pm;

    public ProductServices() {
        this.pm = ProductManagerImpl.getInstance();
        ProductManagerImpl Impl= ProductManagerImpl.getInstance();
        Producte CocaCola=new Producte("CocaCola",2,0);
        Producte Bocata=new Producte("Bocata",4,0);
        Producte Aquarius=new Producte("Aquarius",3,0);
        Producte Croissant=new Producte("Croissant",1,0);
        Map<String,Producte> listProductes= Map.of("CocaCola",CocaCola ,"Bocata",Bocata,"Aquarius",Aquarius,"Croissant",Croissant);
        Impl.setListProductes(listProductes);
    }

    @GET
    @ApiOperation(value = "get all Products", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producte.class, responseContainer="List"),
    })
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Producte> products = new ArrayList<>(ProductManagerImpl.getInstance().getListProductes().values());

        GenericEntity<List<Producte>> entity = new GenericEntity<>(products){};
        return Response.status(201).entity(entity).build()  ;

    }
/*
    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.pm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.pm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.pm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.pm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.pm.addTrack(track);
        return Response.status(201).entity(track).build();
    }
*/
}