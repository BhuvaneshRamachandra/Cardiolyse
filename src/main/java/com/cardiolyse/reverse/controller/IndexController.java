package com.cardiolyse.reverse.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
@Controller
public class IndexController implements ErrorController {

    Logger logger = LogManager.getLogger(ReverseController.class);
    private final static String PATH = "/error";

    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        logger.error("User has encountered an error while calling an API");
        return "Please provide an Input string or use the format - http://localhost:8081/api/reverse/test (where test is the input String) ";
    }

}
