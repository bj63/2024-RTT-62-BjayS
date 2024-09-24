package com.pupz.pupz.controller;

import com.pupz.pupz.database.dao.BreedDAO;
import com.pupz.pupz.database.dao.DogDAO;
import com.pupz.pupz.database.dao.OwnerDAO;
import com.pupz.pupz.database.dao.UserDAO;
import com.pupz.pupz.database.entity.Breed;
import com.pupz.pupz.database.entity.Dog;
import com.pupz.pupz.database.entity.Owner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private DogDAO dogDAO;
    @Autowired
    private OwnerDAO ownerDAO;
    @Autowired
    private BreedDAO breedDAO;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        List<Dog> dogs = dogDAO.findAll(); // Assuming you want to display all dogs
        response.addObject("profiles", dogs);
        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer ownerId) {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("file-upload");
        response.addObject("ownerId", ownerId);

        return response;
    }




    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        // This page is for another page of the website which is expressed as "/page-url"
        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search);

        // I am going to add the user input back to the model so that
        // we can display the search term in the input field
        response.addObject("search", search);

        List<Breed> breeds = breedDAO.findByName(search);

        log.debug("=================================== stream ===============================");

        // This is a stream with a lambda function
        breeds.stream().forEach(breed -> {
            log.debug("Breed: " + breed.getName());
        });

        log.debug("=================================== for loop ===============================");

        // Essentially the same as the above stream
        for (Breed breed : breeds) {
            log.debug("Breed: " + breed.getName());
        }

        response.addObject("breeds", breeds);

        return response;
    }
}