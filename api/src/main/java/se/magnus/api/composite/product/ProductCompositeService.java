package se.magnus.api.composite.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// Chapter 5: Provide general description of the API
@Api("REST API for composite product information")
public interface ProductCompositeService {


    // Chapter 5: Spring Fox to describe the operation and its expected error responses.
    @ApiOperation(
            value = "${api.product-composite.get-composite-product.description}",
            notes = "${api.product-composite.get-composite-product.notes}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request, invalid format of the request. See response message for more information."),
            @ApiResponse(code = 404, message = "Not found, the specified id does not exist."),
            @ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fails. See response message for more information.")
    })
    /**
     * Sample usage: curl $HOST:$PORT/product-composite/1
     *
     * @param productId
     * @return the composite product info, if found, else null
     */
    @GetMapping(
        value    = "/product-composite/{productId}",
        produces = "application/json")
    ProductAggregate getProduct(@PathVariable int productId);
}
