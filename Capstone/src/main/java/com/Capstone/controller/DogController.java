package com.Capstone.controller;

import com.Capstone.database.dao.DogCategoryDAO;
import com.Capstone.database.dao.DogProfileDAO;
import com.Capstone.database.dao.UserDAO;
import com.Capstone.database.entity.DogCategory;
import com.Capstone.form.CreateDogProfileFormBean;
import com.Capstone.database.entity.DogProfile;
import com.Capstone.database.entity.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogProfileDAO dogProfileDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private DogCategoryDAO dogCategoryDao;

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer dogProfileId) {
        ModelAndView response = new ModelAndView("dog/detail");

        DogProfile dogProfile = dogProfileDao.findById(dogProfileId);
        if (dogProfile != null) {
            response.addObject("dogProfile", dogProfile);
        } else {
            response.addObject("errorMessage", "Dog profile not found.");
        }

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("dog/create");

        List<User> users = userDao.findAll();
        response.addObject("users", users);

        List<DogCategory> categories = dogCategoryDao.findAll();
        response.addObject("categories", categories);

        return response;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer dogProfileId) {
        ModelAndView response = new ModelAndView("dog/create");

        List<User> users = userDao.findAll();
        response.addObject("users", users);

        List<DogCategory> categories = dogCategoryDao.findAll();
        response.addObject("categories", categories);

        if (dogProfileId != null) {
            DogProfile dogProfile = dogProfileDao.findById(dogProfileId);
            if (dogProfile != null) {
                CreateDogProfileFormBean form = new CreateDogProfileFormBean();
                form.setId(dogProfile.getId());
                form.setName(dogProfile.getName());
                form.setBreed(dogProfile.getBreed());
                form.setAge(dogProfile.getAge());
                form.setDescription(dogProfile.getDescription());
                form.setImageUrl(dogProfile.getImageUrl());
                form.setOwner(dogProfile.getOwner().getId());
                form.setCategories(dogProfile.getCategories().stream().map(DogCategory::getId).collect(Collectors.toSet()));

                response.addObject("form", form);
            } else {
                response.addObject("errorMessage", "The dog profile was not found.");
            }
        }

        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateDogProfileFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            List<User> users = userDao.findAll();
            response.addObject("users", users);

            List<DogCategory> categories = dogCategoryDao.findAll();
            response.addObject("categories", categories);

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            response.setViewName("dog/create");

            return response;
        } else {
            log.debug(form.toString());

            DogProfile dogProfile = dogProfileDao.findById(form.getId());
            if (dogProfile == null) {
                dogProfile = new DogProfile();
            }

            dogProfile.setName(form.getName());
            dogProfile.setBreed(form.getBreed());
            dogProfile.setAge(form.getAge());
            dogProfile.setDescription(form.getDescription());
            dogProfile.setImageUrl(form.getImageUrl());

            User owner = userDao.findById(form.getOwner());
            dogProfile.setOwner(owner);

            Set<DogCategory> categories = form.getCategories().stream()
                    .map(dogCategoryDao::findById)
                    .collect(Collectors.toSet());
            dogProfile.setCategories(categories);

            dogProfile = dogProfileDao.save(dogProfile);

            response.setViewName("redirect:/dog/detail?dogProfileId=" + dogProfile.getId());
            return response;
        }
    }
}

