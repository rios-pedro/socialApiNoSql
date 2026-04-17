package pedrorios.socialapinosql.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedrorios.socialapinosql.Services.UserService;
import pedrorios.socialapinosql.domain.User;
import pedrorios.socialapinosql.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> fidAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){

        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
