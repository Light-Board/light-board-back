package com.lb.lightboard.model.network;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Pagination {

    private int totalPages;
    private long totalElements;
    private int currentPage;
    private int currentElements;

    public <T> Pagination(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.currentPage = page.getNumber();
        this.currentElements = page.getNumberOfElements();
    }
}
