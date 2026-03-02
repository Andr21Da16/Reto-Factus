package pe.andree.retofactusbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
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