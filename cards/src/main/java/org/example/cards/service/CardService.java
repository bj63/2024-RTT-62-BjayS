package org.example.cards.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.cards.database.dao.CardDAO;
import org.example.cards.database.dao.OrderDetailsDAO;
import org.example.cards.database.entity.Card;
import org.example.cards.form.CreateCardFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
@Slf4j
@Component
public class CardService {

    @Autowired
    private CardDAO cardDao;

    @Autowired
    private OrderDetailsDAO orderDetailsDao;

    @Transactional
    public void deleteCardById(Integer cardId) {
        // First, delete related orderdetails
        orderDetailsDao.deleteByCardId(cardId);

        // Then, delete the card
        cardDao.deleteById(cardId);
    }

    @Transactional
    public Card createCard(CreateCardFormBean form, MultipartFile image) {

        Card card = new Card();
        card.setCardNumber(form.getCardNumber());
        card.setPlayerName(form.getPlayerName());
        card.setTeamName(form.getTeamName());
        card.setBuyPrice(form.getBuyPrice());

        String saveFilename = "./src/main/webapp/pub/image/" + image.getOriginalFilename();

        try {
            Files.copy(image.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Unable to finish reading file", e);
            // Handle the exception appropriately (e.g., rethrow it or handle it gracefully)
        }

        String url = "/pub/image/" + image.getOriginalFilename();
        card.setImageUrl(url);

        cardDao.save(card);

        return card;
    }
}
