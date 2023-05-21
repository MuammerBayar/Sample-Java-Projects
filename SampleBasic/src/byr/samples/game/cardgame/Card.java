/*----------------------------------------------------------------------------------------------------------------------
    Card Sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.game.cardgame;

import java.util.Random;

public class Card
{
   private CardValue m_value;
   private CardType m_type;

   private static void fillDeck(Card [] deck)
   {
      int i = 0;

      for (CardType type : CardType.values())
         for (CardValue value : CardValue.values())
            deck[i++] = new Card(value, type);
   }

   private static void swap(Card [] cards, int i, int k)
   {
      Card temp = cards[i];
      cards[i] = cards[k];
      cards[k] = temp;
   }

   private static void shuffledDeck(Card [] deck)
   {
      boolean [] numbers = new boolean[52];
      Random r = new Random();

      for (int i = 0 ; i < 52; ++i) {
         int j = r.nextInt(52);
         int k = r.nextInt(52);

         if (!numbers[j] && !numbers[k]) {
            swap(deck, j, k);
            numbers[j] = true;
            numbers[k] = true;
         }
      }
   }
   public static Card [] getShuffledDeck()
   {
      Card [] deck = new Card[52];

      fillDeck(deck);
      shuffledDeck(deck);

      return deck;
   }

   public Card(String cardName)
   {
      setName(cardName.trim());
   }

   public Card(CardValue value, CardType type)
   {
      //...
      m_value = value;
      m_type = type;
   }

   public String getName()
   {
      return m_value + "-" + m_type;
   }

   public void setName(String cardName)
   {
      String [] cardInfos = cardName.split("[-]+");

      if (cardInfos.length < 2 ) {
         System.out.println("Wrong Card Name");
         System.exit(0);
      }
      m_value = CardValue.valueOf(cardInfos[0].toUpperCase());
      m_type = CardType.valueOf(cardInfos[1].toUpperCase());

   }
   public String toString()
   {
      return String.format("%s-%s", m_type.toString(), m_value.toString());
   }

}
