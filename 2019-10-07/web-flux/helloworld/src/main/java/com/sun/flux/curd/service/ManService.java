package com.sun.flux.curd.service;

import com.sun.flux.curd.entity.Man;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ManService
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-09
 * @Version V1.0
 **/
@Service
public class ManService {

    private final Map<String, Man> manMap = new ConcurrentHashMap<>();

    @PostConstruct
    void init(){
        Man man1 = new Man("1","mickjoust",66,"21313123132");
        Man man2 = new Man("2","mia",66,"21313123132");
        Man man3 = new Man("3","max",66,"21313123132");

        manMap.put(man1.getId(),man1);
        manMap.put(man2.getId(),man2);
        manMap.put(man3.getId(),man3);
    }


    /**
     * 查询所有
     * @return
     */
    public Flux<Man> getAll(){
        return Flux.fromIterable(this.manMap.values());
    }

    /**
     * 获取多个
     * @param ids
     * @return
     */
    public Flux<Man> getMore(Flux<String> ids){
        return ids.flatMap(id -> Mono.justOrEmpty(this.manMap.get(id)));
    }


    /**
     * 获取单个
     * @param id
     * @return
     */
    public Mono<Man> getOne(String id){
        return Mono.justOrEmpty(this.manMap.get(id))
                .switchIfEmpty(Mono.error(new RuntimeException()));
    }

    /**
     * 批处理
     * @param mans
     * @return
     */
    public Flux<Man> createOrUpdate(Flux<Man> mans){
        return mans.doOnNext(man -> this.manMap.put(man.getId(),man));
    }


    /**
     * 单个
     * @param man
     * @return
     */
    public Mono<Man> createOrUpdate(Man man){
        this.manMap.put(man.getId(),man);
        return Mono.justOrEmpty(man);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public Mono<Man> delete(String id){
        return Mono.justOrEmpty(this.manMap.remove(id));
    }

}
