package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Subscription;
import com.sda.onlineinvoicing.entity.User;

public interface SubscriptionService {
    void saveSubscription(Subscription subscription);

    Subscription getSubscriptionByUserId(User user);
}
