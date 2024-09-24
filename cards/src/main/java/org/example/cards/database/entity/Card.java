package org.example.cards.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "card_year")
    private Integer cardYear;

    @Column(name = "card_condition")
    private String cardCondition;

    @Column(name = "buy_price", columnDefinition = "DECIMAL")
    private Double buyPrice;

    @Column(name = "msrp", columnDefinition = "DECIMAL")
    private Double msrp;

    @Column(name = "available_copies")
    private Integer availableCopies;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "player_stats", columnDefinition = "TEXT")
    private String playerStats;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
