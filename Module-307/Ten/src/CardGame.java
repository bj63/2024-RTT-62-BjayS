import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardGame extends JFrame {
    private Deck deck;
    private Card[] player1Cards;
    private Card[] player2Cards;
    private DefaultListModel<String> discardPile;
    private JList<String> discardPileList;
    private JLabel drawnCardLabel;
    private int currentPlayer;

    public CardGame() {
        deck = new Deck();
        player1Cards = new Card[10];
        player2Cards = new Card[10];
        discardPile = new DefaultListModel<>();
        currentPlayer = 1;

        setTitle("Card Game 10");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel player1Panel = new JPanel();
        player1Panel.setBorder(BorderFactory.createTitledBorder("Player 1"));
        player1Panel.setLayout(new GridLayout(1, 10));
        add(player1Panel, BorderLayout.NORTH);

        JPanel player2Panel = new JPanel();
        player2Panel.setBorder(BorderFactory.createTitledBorder("Player 2"));
        player2Panel.setLayout(new GridLayout(1, 10));
        add(player2Panel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        drawnCardLabel = new JLabel("Drawn Card: None", SwingConstants.CENTER);
        centerPanel.add(drawnCardLabel, BorderLayout.NORTH);

        JButton drawButton = new JButton("Draw Card");
        drawButton.addActionListener(new DrawCardListener());
        centerPanel.add(drawButton, BorderLayout.CENTER);

        discardPileList = new JList<>(discardPile);
        centerPanel.add(new JScrollPane(discardPileList), BorderLayout.SOUTH);

        setVisible(true);
        updatePlayerPanels();
    }

    private class DrawCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Card drawnCard = deck.drawCard();
            if (drawnCard == null) {
                JOptionPane.showMessageDialog(null, "No more cards in the deck!");
                return;
            }

            drawnCardLabel.setText("Drawn Card: " + drawnCard.toString());

            Card[] currentPlayerCards = currentPlayer == 1 ? player1Cards : player2Cards;

            if ("K".equals(drawnCard.getValue()) || "Q".equals(drawnCard.getValue())) {
                discardPile.addElement(drawnCard.toString());
                switchPlayer();
                return;
            }

            if ("J".equals(drawnCard.getValue())) {
                placeWildCard(drawnCard, currentPlayerCards);
            } else {
                int position = Integer.parseInt(drawnCard.getValue()) - 1;
                if (currentPlayerCards[position] == null) {
                    currentPlayerCards[position] = drawnCard;
                } else {
                    discardPile.addElement(drawnCard.toString());
                }
            }

            checkForWinner(currentPlayerCards);
            switchPlayer();
            updatePlayerPanels();
        }
    }

    private void placeWildCard(Card card, Card[] playerCards) {
        for (int i = 0; i < playerCards.length; i++) {
            if (playerCards[i] == null) {
                playerCards[i] = card;
                break;
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    private void checkForWinner(Card[] playerCards) {
        boolean won = true;
        for (Card card : playerCards) {
            if (card == null) {
                won = false;
                break;
            }
        }
        if (won) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
            System.exit(0);
        }
    }

    private void updatePlayerPanels() {
        JPanel player1Panel = (JPanel) getContentPane().getComponent(0);
        player1Panel.removeAll();
        for (Card card : player1Cards) {
            player1Panel.add(new JLabel(card != null ? card.toString() : "Empty"));
        }

        JPanel player2Panel = (JPanel) getContentPane().getComponent(2);
        player2Panel.removeAll();
        for (Card card : player2Cards) {
            player2Panel.add(new JLabel(card != null ? card.toString() : "Empty"));
        }

        player1Panel.revalidate();
        player1Panel.repaint();
        player2Panel.revalidate();
        player2Panel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CardGame::new);
    }
}
