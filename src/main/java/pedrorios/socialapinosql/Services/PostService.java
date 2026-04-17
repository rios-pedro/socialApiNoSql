package pedrorios.socialapinosql.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedrorios.socialapinosql.Services.exception.ObjectNotFoundException;
import pedrorios.socialapinosql.domain.Post;
import pedrorios.socialapinosql.repositories.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
    return repo.findAll();
    }

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public List<Post> findfByTitle(String text){
        return repo.searchTitle(    text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

}
