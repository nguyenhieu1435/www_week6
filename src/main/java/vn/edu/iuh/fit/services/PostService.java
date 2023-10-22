package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Post;
import vn.edu.iuh.fit.repositories.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post insert(Post post){
        return postRepository.save(post);
    }
    public Post update(Post post){
        return postRepository.save(post);
    }
    public void deleteById(long id){
        postRepository.deleteById(id);
        return;
    }
    public Optional<Post> findById(long id){
        return postRepository.findById(id);
    }
    public Page<Post> findAll(int pageNo, int pageSize, String sortBy, String sortDerection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDerection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return postRepository.findAll(pageable);
    }
}
