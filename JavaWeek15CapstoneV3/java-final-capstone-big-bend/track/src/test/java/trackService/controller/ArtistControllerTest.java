package trackService.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import trackService.model.artist.Artist;
import trackService.model.artist.ArtistBuilder;
import trackService.service.ArtistService;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ArtistControllerTest {

    @Mock
    private ArtistService artistService;

    @Mock
    private UriCreator uriCreator;

    @InjectMocks
    private ArtistController controller;

    @Test
    public void testGetOk(){
        Artist SingerSin = new ArtistBuilder().startArtistBuilder("SingerSin").addMusicGender("Pop").build();

        Mockito.when(artistService.getArtistById(0)).thenReturn(SingerSin);

        ResponseEntity<Artist> artist = controller.getArtistById(0);

        assertEquals(HttpStatus.OK, artist.getStatusCode());

        Mockito.verify(artistService).getArtistById(0);

    }

    @Test
    public void testGetNotFound(){

        Mockito.when(artistService.getArtistById(1199)).thenReturn(null);

        ResponseEntity<Artist> artist = controller.getArtistById(1199);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, artist.getStatusCode());

        Mockito.verify(artistService).getArtistById(1199);

    }

    @Test
    public void testPost() throws URISyntaxException {
        Artist singerSin = new ArtistBuilder().startArtistBuilder("SingerSin").addMusicGender("Pop").build();
        singerSin.setId(0);

        String uri = "http://localhost:8080/artist/0";

        URI uri1 =  new URI(uri);

        Mockito.when(artistService.create(singerSin)).thenReturn(singerSin);

        Mockito.when(uriCreator.getURI(0)).thenReturn(uri1);

        ResponseEntity<?> artist = controller.createArtist(singerSin);

        Assertions.assertEquals(HttpStatus.CREATED, artist.getStatusCode());

        String locHdr = artist.getHeaders().get("Location").get(0);

        Assertions.assertEquals(uri, locHdr);

        Mockito.verify(artistService).create(singerSin);

    }


}
