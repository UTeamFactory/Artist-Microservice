package com.example.artistmicroservice.query.projections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistViewRepository extends JpaRepository<ArtistView, String> {
}
