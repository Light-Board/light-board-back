package com.lb.lightboard.model.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.network.status.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    // api 통신 시간
    // json으로 리턴해줄때 명칭을 바꿔줄 수 있다 -> 카멜케이스와 스네이크 표현의 차이점
    // 이렇게 하루종일 다 바꿔주면 시간 날려 먹고 아까워 죽는다 -> resources -> application.properties에서 설정 쌉가능이다 이말이야
    // @JsonProperty("transaction_time")
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime transactionTime; // ISO

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;

    // 계속 계속 바뀌는 data부분 -> 제네릭을 사용하자!
    private T data;

    // DATA INFO SETTING
    public Header(ResponseStatus responseStatus, T data) {
        this.transactionTime = LocalDateTime.now();
        this.resultCode = responseStatus.getResult();
        this.description = responseStatus.getDescription();
        this.data = data;
    }
    
    // DATA OK [ creadted by 전세 ]
    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    // DATA response OK with status code and description
    public static <T> Header<T> OK(T data, String resultCode, String description) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode(resultCode)
                .description(description)
                .data(data)
                .build();
    }

    // ERROR
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
