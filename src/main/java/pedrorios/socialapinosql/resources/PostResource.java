package pedrorios.socialapinosql.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedrorios.socialapinosql.Services.PostService;
import pedrorios.socialapinosql.Services.UserService;
import pedrorios.socialapinosql.domain.Post;
import pedrorios.socialapinosql.domain.User;
import pedrorios.socialapinosql.dto.UserDto;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
