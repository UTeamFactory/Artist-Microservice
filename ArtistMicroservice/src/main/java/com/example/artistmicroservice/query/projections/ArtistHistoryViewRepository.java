package com.example.artistmicroservice.query.projections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistHistoryViewRepository extends JpaRepository<ArtistHistoryView,String> {

    @Query(value = "SELECT * FROM artist_history_view WHERE artist_history_id = (SELECT MAX(artist_history_id) FROM artist_history_view WHERE artist_id = :artistId)", nativeQuery = true)
    Optional<ArtistHistoryView> getLastByArtistId(String artistId);

    @Query(value = "SELECT * FROM artist_history_view WHERE artist_id = :artistId ORDER BY created_at", nativeQuery = true)
    List<ArtistHistoryView> getHistoryByArtistId(String artistId);

}
