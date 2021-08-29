package com.cardiolyse.reverse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping(value = "/api")
public class ReverseController {

    Logger logger = LogManager.getLogger(ReverseController.class);

    @GetMapping(value = "/reverse/{input}")
    public String reverse(@PathVariable(value = "input") String input) {

            StringBuilder output = new StringBuilder();
            output.append(input);
        logger.info("Successfully converted the String: {}", input);
        return output.reverse().toString();

    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
        logger.error(e.getMessage());
        return e.getMessage() ;
    }

}

