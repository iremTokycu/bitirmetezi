package com.taxi.core.request;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestEntityRepository extends JpaRepository<RequestEntity, Long> {
}
