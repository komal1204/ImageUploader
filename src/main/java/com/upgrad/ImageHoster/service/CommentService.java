package com.upgrad.ImageHoster.service;


import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;

import java.util.List;



public interface CommentService {
   // List<Comment> getAll();
    //List<Comment> getByImage(int imageId);
    void createComment(Comment comment);
    List<Comment> getAllComments();
    //Comment editComment(Comment comment);
    //boolean delComment(Comment)
    //List<Comment> getByUser(int userId);

}
