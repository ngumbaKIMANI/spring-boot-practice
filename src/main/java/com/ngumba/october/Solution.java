package com.ngumba.october;

import java.util.*;

class Results {
    public String set_name;
    public String[] cards;

    public Results(String set_name, String[] cards) {
        this.set_name = set_name;
        this.cards = cards;
    }
}

public class Solution {
    public Results solution(String[] cards) {
        Map<String, Integer> rankCount = new HashMap<>();


        for (String card : cards) {
            String rank = card.substring(0, card.length() - 1);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }


        if (isFiveInARow(cards)) {
            return new Results("five in a row", getFiveInARow(cards));
        } else if (isTriple(rankCount)) {
            return new Results("triple", getTriple(cards, rankCount));
        } else if (isPair(rankCount)) {
            return new Results("pair", getPair(cards, rankCount));
        } else {
            return new Results("single card", new String[]{cards[0]});
        }
    }


    private boolean isFiveInARow(String[] cards) {
        List<String> ranks = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
        Arrays.sort(cards, Comparator.comparingInt((String card) -> ranks.indexOf(card.substring(0, card.length() - 1))));

        for (int i = 0; i < cards.length - 1; i++) {
            String currentRank = cards[i].substring(0, cards[i].length() - 1);
            String nextRank = cards[i + 1].substring(0, cards[i + 1].length() - 1);

            if (ranks.indexOf(nextRank) - ranks.indexOf(currentRank) != 1) {
                return false;
            }
        }

        return true;
    }


    private String[] getFiveInARow(String[] cards) {
        return cards;
    }


    private boolean isTriple(Map<String, Integer> rankCount) {
        return rankCount.containsValue(3);
    }


    private String[] getTriple(String[] cards, Map<String, Integer> rankCount) {
        String tripleRank = rankCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");

        List<String> tripleCards = new ArrayList<>();
        for (String card : cards) {
            String rank = card.substring(0, card.length() - 1);
            if (rank.equals(tripleRank)) {
                tripleCards.add(card);
            }
        }
        return tripleCards.toArray(new String[0]);
    }


    private boolean isPair(Map<String, Integer> rankCount) {
        return rankCount.containsValue(2);
    }


    private String[] getPair(String[] cards, Map<String, Integer> rankCount) {
        String pairRank = rankCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey)
                .max(Comparator.comparingInt(rank -> Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A").indexOf(rank)))
                .orElse("");

        List<String> pairCards = new ArrayList<>();
        for (String card : cards) {
            String rank = card.substring(0, card.length() - 1);
            if (rank.equals(pairRank)) {
                pairCards.add(card);
            }
        }
        return pairCards.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cards = {"KS", "10H", "10S", "AH", "AD", "AC", "7S", "8S", "9S", "10S", "JS"};
        Results result = solution.solution(cards);
        System.out.println("Set Name: " + result.set_name);
        System.out.println("Cards: " + Arrays.toString(result.cards));
    }
}
