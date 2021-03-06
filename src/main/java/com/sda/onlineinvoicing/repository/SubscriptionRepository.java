package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Subscription;
import com.sda.onlineinvoicing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    public Subscription findByUser(User user);
}
