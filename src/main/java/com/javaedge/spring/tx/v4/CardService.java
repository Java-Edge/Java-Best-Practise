package com.javaedge.spring.tx.v4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JavaEdge
 * @date 2021/11/22
 */
@Service
public class CardService {

    @Autowired
    private CardMapper cardMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DataSource(DataSource.card)
    public void createCard(int userId) throws Exception {
        Card card = new Card();
        card.setUserId(userId);
        card.setBalance(1000);
        cardMapper.saveCard(card);
    }
}
