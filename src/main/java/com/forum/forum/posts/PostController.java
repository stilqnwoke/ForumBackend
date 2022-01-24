package com.forum.forum.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPost( @PathVariable long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost( @PathVariable long id) {
        Post post = postService.deleteByID(id);

        if(post!=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long id, @RequestBody Post post) {
        Post postUpdated = postService.save(post);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> addPost( @RequestBody Post post) {
        Post createdPost = postService.save(post);

        //Location
        //Get current resource url
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(createdPost.getId())
                .toUri();


        return  ResponseEntity.created(uri).build();
    }
}
