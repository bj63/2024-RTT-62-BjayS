package org.example.cards.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.cards.database.dao.CardDAO;
import org.example.cards.database.dao.UserDAO;
import org.example.cards.database.entity.Card;
import org.example.cards.database.entity.User;
import org.example.cards.form.CreateCardFormBean;
import org.example.cards.form.EditUserFormBean;
import org.example.cards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize(value = "hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private CardDAO cardDao;

    @Autowired
    private CardService cardService;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView response = new ModelAndView("admin/dashboard");
        List<Card> cards = cardDao.findAll();
        response.addObject("cards", cards);
        return response;
    }

    @GetMapping("/createCard")
    public ModelAndView createCardForm() {
        ModelAndView response = new ModelAndView("admin/create-card");
        response.addObject("form", new CreateCardFormBean());
        return response;
    }

    @PostMapping("/createCard")
    public ModelAndView createCardSubmit(@Valid @ModelAttribute("form") CreateCardFormBean form, BindingResult bindingResult, @RequestParam("image") MultipartFile image) {
        if (bindingResult.hasErrors()) {
            ModelAndView response = new ModelAndView("admin/create-card");
            response.addObject("form", form);
            return response;
        }

        try {
            cardService.createCard(form, image);
        } catch (Exception e) {
            log.error("Error creating card", e);
            ModelAndView response = new ModelAndView("admin/create-card");
            response.addObject("form", form);
            response.addObject("errorMessage", "An error occurred while creating the card.");
            return response;
        }
        return new ModelAndView("redirect:/admin/dashboard");
    }

    @GetMapping("/editCard")
    public ModelAndView editCard(@RequestParam Integer cardId) {
        ModelAndView response = new ModelAndView("admin/edit-card");

        Card card = cardDao.findById(cardId);

        if (card != null) {
            CreateCardFormBean form = new CreateCardFormBean();
            form.setId(card.getId());
            form.setCardNumber(card.getCardNumber());
            form.setPlayerName(card.getPlayerName());
            form.setTeamName(card.getTeamName());
            form.setBuyPrice(card.getBuyPrice());

            response.addObject("form", form);
            response.addObject("card", card);
        } else {
            log.warn("Card with id {} not found", cardId);
        }
        return response;
    }

    @PostMapping("/editCard")
    public ModelAndView editCardSubmit(@Valid CreateCardFormBean form, BindingResult bindingResult, @RequestParam(value = "image", required = false) MultipartFile image) {
        ModelAndView response = new ModelAndView("admin/edit-card");

        if (bindingResult.hasErrors()) {
            response.addObject("form", form);
            return response;
        }

        try {
            Card card = cardService.createCard(form, image);
            response.setViewName("redirect:/card/detail/" + card.getId());
        } catch (Exception e) {
            log.error("Error updating card", e);
            response.addObject("errorMessage", "An error occurred while updating the card.");
        }
        return response;
    }

    @GetMapping("/cardSearch")
    public ModelAndView cardSearch(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("admin/search-card");

        List<Card> cards = cardDao.searchCards(search);

        response.addObject("cards", cards);
        response.addObject("searchTerm", search);

        return response;
    }

    @PostMapping("/deleteCard")
    public ModelAndView deleteCard(@RequestParam Integer cardId) {
        try {
            cardService.deleteCardById(cardId);
        } catch (Exception e) {
            log.error("Error deleting card with id {}", cardId, e);
        }
        return new ModelAndView("redirect:/admin/dashboard");
    }




    @GetMapping("/userSearch")
    public ModelAndView userSearch(@RequestParam(required = false) String search, @RequestParam(required = false) Integer searchId) {
        ModelAndView response = new ModelAndView("admin/search-user");

        List<User> users = userDao.searchUser(search, searchId);
        response.addObject("users", users);
        response.addObject("searchTerm", search);
        response.addObject("searchId", searchId);

        return response;
    }

    @GetMapping("/editUser")
    public ModelAndView editUser(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("admin/edit-user");

        User user = userDao.findById(id);

        if (user != null) {
            EditUserFormBean form = new EditUserFormBean();
            form.setId(user.getId());
            form.setEmail(user.getEmail());

            response.addObject("form", form);
        } else {
            log.warn("User with id {} not found", id);
        }
        return response;
    }

    @PostMapping("/editUser")
    public ModelAndView editUserSubmit(@Valid EditUserFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("admin/edit-user");

        if (bindingResult.hasErrors()) {
            response.addObject("form", form);
            return response;
        }

        User user = userDao.findById(form.getId());
        if (user != null) {
            user.setEmail(form.getEmail());
            userDao.save(user);
            response.setViewName("redirect:/admin/userSearch");
        }
        return response;
    }
}