package com.lb.lightboard.controller;

import com.lb.lightboard.model.network.Header;

// CRUD 인터페이스!
public interface CrudInterface<Req, Res> {
    Header<Res> create(Header<Req> request);

    Header<Res> read(long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(long id);
}