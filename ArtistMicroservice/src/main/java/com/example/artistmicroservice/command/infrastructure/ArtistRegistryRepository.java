package com.example.artistmicroservice.command.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ArtistRegistryRepository extends JpaRepository<ArtistRegistry, String> {
    Optional<ArtistRegistry> getByArtistId(String artistRegistryId);
}
