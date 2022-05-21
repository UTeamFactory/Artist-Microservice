package query.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import query.projections.ArtistHistoryViewRepository;
import query.projections.ArtistView;
import query.projections.ArtistViewRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
@Tag(name = "Artists")
public class ArtistQueryController {

    private final ArtistViewRepository artistViewRepository;

    private final ArtistHistoryViewRepository artistHistoryViewRepository;

    public ArtistQueryController(ArtistViewRepository artistViewRepository, ArtistHistoryViewRepository artistHistoryViewRepository) {
        this.artistViewRepository = artistViewRepository;
        this.artistHistoryViewRepository = artistHistoryViewRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all Artist")
    public ResponseEntity<List<ArtistView>> getAllArtist(){
        try{
            return new ResponseEntity<List<ArtistView>>(artistViewRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Artist by id")
    public ResponseEntity<ArtistView> getById(@PathVariable("id") String id){
        try{
            Optional<ArtistView> artistViewOptional = artistViewRepository.findById(id);
            if(artistViewOptional.isPresent()){
                return new ResponseEntity<ArtistView>(artistViewOptional.get(), HttpStatus.OK);
            }
            return new ResponseEntity("NOT_FOUND", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
