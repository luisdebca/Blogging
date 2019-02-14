package debca.blogging.service;

import debca.blogging.model.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PostService implements AllPostFinder{

    @Override
    public List<Post> getAll() {
        return null;
    }
}
