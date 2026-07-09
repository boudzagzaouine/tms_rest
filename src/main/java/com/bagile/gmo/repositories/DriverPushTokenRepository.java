package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoDriverPushToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverPushTokenRepository extends JpaRepository<GmoDriverPushToken, Long> {

    List<GmoDriverPushToken> findByDriverId(Long driverId);

    Optional<GmoDriverPushToken> findFirstByToken(String token);
}
