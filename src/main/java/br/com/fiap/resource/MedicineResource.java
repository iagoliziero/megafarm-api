package br.com.fiap.resource;

import br.com.fiap.bo.MedicineBO;
import br.com.fiap.to.MedicineTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/megafarm")
public class MedicineResource {
    private MedicineBO medicineBO = new MedicineBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<MedicineTO> result = medicineBO.findAll();

        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

}
