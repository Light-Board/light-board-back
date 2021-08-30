package com.lb.lightboard.controller;

import com.lb.lightboard.model.network.Header;
import org.springframework.data.domain.Pageable;

import java.util.List;

// CRUD 인터페이스!
public interface CrudInterface<Req, Res> { // abstract 로 자동으로 만들어준대 ㅎㄷㄷ 따로 붙일 필요 없댕!
    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<List<Res>> search(Pageable pageable);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);
}