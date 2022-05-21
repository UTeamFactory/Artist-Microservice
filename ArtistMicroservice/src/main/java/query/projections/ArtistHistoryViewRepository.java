package query.projections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistHistoryViewRepository extends JpaRepository<ArtistHistoryView,String> {

    @Query(value = "SELECT *" +
            "       FROM artist_history_view" +
            "       WHERE artist_history_id" +
            "           = (SELECT MAX (artist_history_id)" +
            "               FROM artist_history_view WHERE artist_id = :artistId)", nativeQuery = true)
    Optional<ArtistHistoryView> getLastByUserId(String artistId);

    @Query(value = "SELECT * FROM artist_history_view WHERE artist_id = :artistId", nativeQuery = true)
    List<ArtistHistoryView> getArtistHistoryByUserId(String artistId);

}
