package swd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import swd.service.BlogService;


@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    
}
