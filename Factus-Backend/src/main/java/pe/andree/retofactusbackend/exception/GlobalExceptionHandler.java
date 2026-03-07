package pe.andree.retofactusbackend.exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import pe.andree.retofactusbackend.dto.ApiResponse;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){

        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequestException(BadRequestException ex, WebRequest request){
        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(null)
                .meta(null)
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleEntityNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(null)
                .meta(null)
                .build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<Void>> handleDataIntegrityViolationException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(null)
                .meta(null)
                .build(), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAccessDeniedException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(null)
                .meta(null)
                .build(), HttpStatus.CONFLICT);
    }



    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse<Void>> handleResponseStatusException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.<Void>builder()
                .timeStamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(null)
                .meta(null)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
