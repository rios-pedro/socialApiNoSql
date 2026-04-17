package pedrorios.socialapinosql.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pedrorios.socialapinosql.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> fidAll(){
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User joao = new User("2", "Joao Nunes", "joao@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, joao));
        return ResponseEntity.ok().body(list);
    }
}
