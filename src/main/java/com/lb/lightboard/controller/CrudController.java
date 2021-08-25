package com.lb.lightboard.controller;

import com.lb.lightboard.bo.BaseBO;
import com.lb.lightboard.model.network.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    @Autowired(required = false)
    protected BaseBO<Req, Res, Entity> baseBO;

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        log.info("🟢🟢🟢CrudController create: {}", request.getData());
        return baseBO.create(request);
    }

    @GetMapping("{id}")
    public Header<Res> read(@PathVariable Long id) {
        return baseBO.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseBO.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<Res> delete(@PathVariable Long id) {
        return baseBO.delete(id);
    }
}
