package org.sails.controller.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nodirbek on 20.04.2015. Project name Sale-Point
 */
@RestController
@RequestMapping(value = "/rest/product", produces = "application/json;charset=UTF-8")
public class ProductRestController {

//    @Autowired
//    ProductService productService;
//
//    @Autowired
//    ProductAsm productAsm;
//
//    /*
//    @ModelAttribute
//        public void productCommonModel(Model model) {
//
//            here add common attributes for all requests
//            model.addAttribute("user",user)
//
//        }
//    */
//    @RequestMapping(value = "/ID/{ID}", method = RequestMethod.GET)
//    public ResponseEntity<ProductResource> getProductID(@PathVariable("ID") Long ID) {
//
//        Product product = productService.getProduct(ID);
//        if (product == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        return new ResponseEntity<>(productAsm.toResource(product), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = {"/barCode/{barCode}"}, method = RequestMethod.GET)
//    public ResponseEntity<ProductResource> getProductBarCode(@PathVariable("barCode") String barCode) {
//
//        Product product = productService.getProduct(barCode);
//
//        if (product == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(productAsm.toResource(product), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public ResponseEntity<List<ProductResource>> getProductAll() {
//        List<Product> all = productService.getAll();
//        if (all == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(productAsm.toResources(all), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/string", method = RequestMethod.GET)
//    public String getStringResponseBody() {
//
//        return "Nodirbek comes here";
//
//    }

}
