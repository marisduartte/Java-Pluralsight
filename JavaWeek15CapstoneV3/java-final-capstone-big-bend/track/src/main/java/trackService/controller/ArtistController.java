package trackService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trackService.model.artist.Artist;
import trackService.model.track.Track;
import trackService.service.ArtistService;


import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private UriCreator uriCreator;

    @GetMapping
    public ResponseEntity<?> getAllArtist() {
        List<Artist> artists = artistService.getAllArtists();
        return ResponseEntity.ok().body(artists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable int id) {
        Artist artistResult = artistService.getArtistById(id);
        if (artistResult == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(artistResult);
    }

    @PostMapping
    public ResponseEntity<?> createArtist(@RequestBody Artist artist) {
        Artist resultArtist = this.artistService.create(artist);
        URI newResource = uriCreator.getURI(resultArtist.getId());
        return ResponseEntity.created(newResource).body(resultArtist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArtist(@PathVariable("id") int id,@RequestBody Artist artist) {
        boolean updated = this.artistService.updateArtist(artist);
        if (!updated) {
            return ResponseEntity.notFound().build();
        }
        URI newResource = uriCreator.getURI(artist.getId());
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") int id) {
        try {
            this.artistService.deleteArtist(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

    }

}


