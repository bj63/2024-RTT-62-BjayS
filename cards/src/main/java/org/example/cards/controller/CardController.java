package org.example.cards.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.cards.database.dao.CardDAO;
import org.example.cards.database.dao.UserDAO;
import org.example.cards.database.entity.Card;
import org.example.cards.database.entity.User;
import org.example.cards.form.CreateCardFormBean;
import org.example.cards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardDAO cardDao;

    @Autowired
    private CardService cardService;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(required = false) Integer id, Principal principal) {
        ModelAndView response = new ModelAndView("card/detail");

        Card card = cardDao.findById(id);
        if (card == null) {
            // Handle the case where no card is found
            return new ModelAndView("redirect:/error");
        }
        response.addObject("card", card);

        return response;
    }

    @GetMapping("/search")
    public ModelAndView search() {
        ModelAndView response = new ModelAndView("card/search");
        return response;
    }

    @GetMapping
    public ModelAndView cardSearch(@RequestParam(required = false) String search, @RequestParam(required = false) String team) {
        ModelAndView response = new ModelAndView("card/search");

        List<Card> cards;

        // Trim search and team, and set to null if they're empty or just whitespace
        search = (search != null) ? search.trim() : null;
        team = (team != null && !team.equals("Or Select A Team")) ? team.trim() : null;

        if (search != null && team != null) {
            cards = cardDao.searchCardsByPlayerAndTeam(search, team);
        } else if (search != null) {
            cards = cardDao.searchCards(search);
        } else if (team != null) {
            cards = cardDao.searchByTeam(team);
        } else {
            // Neither search nor valid team is provided
            cards = new ArrayList<>(); // Avoid null pointer exceptions
        }

        // Log the cards for debugging purposes
        cards.forEach(card -> {
            log.debug("Card: {}", card.getPlayerName());
        });

        response.addObject("cards", cards);
        response.addObject("searchTerm", search);
        response.addObject("selectedTeam", team);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView createCardForm() {
        ModelAndView response = new ModelAndView("card/create-card");
        response.addObject("form", new CreateCardFormBean());
        return response;
    }

    @PostMapping("/create")
    public ModelAndView createCardSubmit(@Valid @ModelAttribute("form") CreateCardFormBean form, BindingResult bindingResult, @RequestParam("image") MultipartFile image) {
        if (bindingResult.hasErrors()) {
            ModelAndView response = new ModelAndView("card/create-card");
            response.addObject("form", form);
            return response;
        }

        try {
            Card card = cardService.createCard(form, image);
            return new ModelAndView("redirect:/card/detail?id=" + card.getId());
        } catch (Exception e) {
            log.error("Error creating card", e);
            ModelAndView response = new ModelAndView("card/create-card");
            response.addObject("form", form);
            response.addObject("errorMessage", "An error occurred while creating the card.");
            return response;
        }
    }

    @GetMapping("/edit/{cardId}")
    public ModelAndView editCard(@PathVariable Integer cardId) {
        ModelAndView response = new ModelAndView("card/edit-card");

        Card card = cardDao.findById(cardId);

        if (card != null) {
            CreateCardFormBean form = new CreateCardFormBean();
            form.setId(card.getId());
            form.setCardNumber(card.getCardNumber());
            form.setPlayerName(card.getPlayerName());
            form.setTeamName(card.getTeamName());
            form.setBuyPrice(card.getBuyPrice());

            response.addObject("form", form);
        } else {
            log.warn("Card with id {} not found", cardId);
        }
        return response;
    }

    @PostMapping("/edit")
    public ModelAndView editCardSubmit(@Valid @ModelAttribute("form") CreateCardFormBean form, BindingResult bindingResult, @RequestParam(value = "image", required = false) MultipartFile image) {
        if (bindingResult.hasErrors()) {
            ModelAndView response = new ModelAndView("card/edit-card");
            response.addObject("form", form);
            return response;
        }

        try {
            Card card = cardService.createCard(form, image);
            return new ModelAndView("redirect:/card/detail?id=" + card.getId());
        } catch (Exception e) {
            log.error("Error updating card", e);
            ModelAndView response = new ModelAndView("card/edit-card");
            response.addObject("form", form);
            response.addObject("errorMessage", "An error occurred while updating the card.");
            return response;
        }
    }
}

 /*   @PostMapping("/trade")
    public String tradeCard(@RequestParam Integer cardId, HttpSession session, Principal principal) {
        if (principal == null) {
            // Handle the case where the user is not authenticated
            return "redirect:/login";
        }

        Integer userId = (Integer) session.getAttribute("userId");
        User user = userDao.findById(userId);

        Card card = cardDao.findById(cardId);
        log.info("Card found: {}", card);

        if (card != null && card.getAvailableCopies() > 0) {
            TradedCard tradedCard = new TradedCard(); // Updated entity name
            tradedCard.setUser(user);
            tradedCard.setCard(card);
            tradedCard.setTradeDate(new Date()); // Updated date field
            tradedCard.setDueDate(new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000)); // Optional: Adjust based on your logic
            tradedCardDao.save(tradedCard);

            card.setAvailableCopies(card.getAvailableCopies() - 1);
            cardDao.save(card);
        }

        return "redirect:/user/bookshelf?id=" + user.getId();
    }

    @PostMapping("/return")
    public String returnCard(@RequestParam Integer tradeId, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userDao.findById(userId);

        TradedCard tradedCard = tradedCardDao.findById(tradeId); // Updated DAO method
        if (tradedCard != null) {
            Card card = cardDao.findById(tradedCard.getCard().getId()); // Adjusted to use Card from TradedCard
            if (card != null) {
                card.setAvailableCopies(card.getAvailableCopies() + 1);
                cardDao.save(card);
            }
            tradedCardDao.delete(tradedCard);
        }
        return "redirect:/user/bookshelf?id=" + user.getId();
    }
}*/
