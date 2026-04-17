package pedrorios.socialapinosql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pedrorios.socialapinosql.domain.Post;
import pedrorios.socialapinosql.domain.User;
import pedrorios.socialapinosql.dto.AuthorDto;
import pedrorios.socialapinosql.dto.CommentDto;
import pedrorios.socialapinosql.repositories.PostRepository;
import pedrorios.socialapinosql.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("12/05/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(bob));
        CommentDto c3 = new CommentDto("Tenha um ótimo dia", sdf.parse("12/05/2018"), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);



    }
}
