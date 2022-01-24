package com.forum.forum.posts;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private static List<Post> posts = new ArrayList();
    private static long idCounter = 0;

    static {
        posts.add(new Post(++idCounter, "Best movies",
                new Date(),
                "stkwe", "sadsadsafjengjivneibnienviinvierniv"));
        posts.add(new Post(++idCounter, "Best series",
                new Date(),
                "stkwe", "sadsadsafjengjivneibnienviinviernsdaiv"));
        posts.add(new Post(++idCounter, "Best athletes",
                new Date(),
                "stkwe", "sadsadsafjengjivneibnienviinviernivda"));
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        if(post.getId() == -1) {
            post.setId(++idCounter);
            posts.add(post);
        } else {
            deleteByID(post.getId());
            posts.add(post);
        }

        return post;
    }

    public Post deleteByID(long id) {
        Post post = findById(id);

        if(post == null) return null;

        if(posts.remove(post)){
            return post;
        }
        return post;
    }

    public Post findById(long id) {
        for(Post post: posts) {
            if(post.getId() == id) {
                return post;
            }
        }

        return null;
    }
}
