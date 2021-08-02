package com.lb.lightboard.controller;

import com.lb.lightboard.model.network.Header;

// CRUD 인터페이스!
public interface CrudInterface<Req, Res> { // abstract 로 자동으로 만들어준대 ㅎㄷㄷ 따로 붙일 필요 없댕!
    Header<Res> create(Header<Req> request);

    Header<Res> findById(Long id);

    Header<Res> findAll();

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);
}