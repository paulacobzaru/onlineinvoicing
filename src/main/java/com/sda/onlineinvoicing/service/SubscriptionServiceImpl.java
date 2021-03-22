package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Subscription;
import com.sda.onlineinvoicing.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public void saveSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }
}
