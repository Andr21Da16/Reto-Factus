package pe.andree.retofactusbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private boolean success;
    private String message;
    private String description;
    private T data;
    private Meta meta;
}