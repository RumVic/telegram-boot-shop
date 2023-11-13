package springboottelegrambot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboottelegrambot.dto.idto.ProductInput;
import springboottelegrambot.dto.odto.OutPage;
import springboottelegrambot.dto.odto.ProductOutput;
import springboottelegrambot.service.api.IProductService;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    private final IProductService productService;

    @PostMapping
    protected ResponseEntity<String> createProduct(@RequestBody @Valid ProductInput idto) {
        //final String authHeader = request.getHeader(AUTHORIZATION);
        ProductOutput created = this.productService.create(idto);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping()
    protected ResponseEntity<OutPage> getList (@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        OutPage pageOfProducts = productService.read(pageable);
        return new ResponseEntity<>(pageOfProducts, HttpStatus.OK);
    }


}
