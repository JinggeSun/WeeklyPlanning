package com.sun.flux.curd.controller;

import com.sun.flux.curd.entity.Man;
import com.sun.flux.curd.service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sun.dc.pr.PRError;

import java.util.Objects;

/**
 * @ClassName ManController
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@RestController
@RequestMapping("/man")
public class ManController {

    private ManService manService;

    @Autowired
    private ManController(ManService manService){
        this.manService = manService;
    }

    @GetMapping("/list")
    public Flux<Man> getAll(){
        return manService.getAll();
    }

    @GetMapping("/list/{ids}")
    public Flux<Man> getIds(@PathVariable("ids")  String ids){
        return manService.getMore(Flux.fromArray(ids.split(",")));
    }

    @GetMapping("/one/{id}")
    public Mono<Man> getId(@PathVariable("id") String id){
        return manService.getOne(id);
    }

    @PostMapping("/create")
    public Flux<Man> create(@RequestBody Flux<Man> mans){
        return manService.createOrUpdate(mans);
    }

    @PostMapping("/update_mono/{id}")
    public Mono<Man> updateMono(@PathVariable("id") final String id, @RequestBody final Man man){
        Objects.requireNonNull(man);
        man.setId(id);
        return manService.createOrUpdate(man);
    }

    @GetMapping("/delete_mono/{id}")
    public Mono<Man> delete(@PathVariable("id") final String id){
        return manService.delete(id);
    }


}
