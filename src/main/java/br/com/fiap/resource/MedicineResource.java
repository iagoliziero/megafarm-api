package br.com.fiap.resource;

import br.com.fiap.bo.MedicineBO;
import br.com.fiap.to.MedicineTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.Valid;

import java.util.ArrayList;

@Path("/megafarm")
public class MedicineResource {
    private MedicineBO medicineBO = new MedicineBO();

    @GET    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<MedicineTO> result = medicineBO.findAll();
        Response.ResponseBuilder response = null;
        if (result != null) {
            response = Response.ok(); // 200 - OK
        }
        else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        response.entity(result);
        return response.build();
    }

    @GET
    @Path("/{cod}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCode(@PathParam("cod") Long codigo) {
        MedicineTO result = medicineBO.findByCode(codigo);
        Response.ResponseBuilder response = null;
        if (result != null) {
            response = Response.ok();  // 200 (OK)
        } else {
            response = Response.status(404);  // 404 (NOT FOUND)
        }
        response.entity(result);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid MedicineTO medicine) {
        MedicineTO result = MedicineBO.save(medicine);
        Response.ResponseBuilder response = null;
        if (result != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 401 - BAD REQUEST
        }
        response.entity(result);
        return response.build();
    }
}