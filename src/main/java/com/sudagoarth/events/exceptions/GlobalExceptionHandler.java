package com.sudagoarth.events.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sudagoarth.events.Models.LocaledData;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneralException(Exception ex) {
        LOGGER.error("Unhandled exception: ", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(new LocaledData(
                        "An unexpected error occurred.",
                        "حدث خطأ غير متوقع"),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "INTERNAL_SERVER_ERROR", null));
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ApiResponse> handleDuplicateException(DuplicateException ex) {
        List<Map<String, String>> errorDetails = List.of(Map.of("defaultMessage", ex.getMessage()));

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.error(new LocaledData(
                        "Duplicate entry",
                        "تكرار الإدخال"),
                        HttpStatus.CONFLICT.value(),
                        "DUPLICATE_ENTRY",
                        errorDetails));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException ex) {
        List<Map<String, String>> errorDetails = List.of(Map.of("defaultMessage", ex.getMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(new LocaledData(
                        "Resource not found",
                        "المورد غير موجود"),
                        HttpStatus.NOT_FOUND.value(),
                        "RESOURCE_NOT_FOUND",
                        errorDetails));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errorDetails = List.of(Map.of("defaultMessage", ex.getMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(new LocaledData(
                        "Validation error",
                        "خطأ في التحقق"),
                        HttpStatus.BAD_REQUEST.value(),
                        "VALIDATION_ERROR",
                        errorDetails));
    }

    //java.lang.IllegalArgumentException: Event category ID is required for update.
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
            List<Map<String, String>> errorDetails = List.of(Map.of("defaultMessage", ex.getMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(new LocaledData(
                            "Validation error",
                            "خطأ في التحقق"),
                            HttpStatus.BAD_REQUEST.value(),
                            "VALIDATION_ERROR",
                            errorDetails));
        }

}
