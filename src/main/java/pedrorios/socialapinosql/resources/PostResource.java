package pedrorios.socialapinosql.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrorios.socialapinosql.Services.PostService;
import pedrorios.socialapinosql.domain.Post;
import pedrorios.socialapinosql.resources.util.URL;

import java.util.List;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

        text = URL.decodeParam(text);
        List<Post> list = service.findfByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
