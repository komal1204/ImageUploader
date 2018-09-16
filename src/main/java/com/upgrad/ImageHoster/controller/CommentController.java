package com.upgrad.ImageHoster.controller;
import com.upgrad.ImageHoster.common.ImageManager;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.model.Image;
import org.springframework.ui.Model;
import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    /**
     * This controller method returns all the comments that have been
     * writen to the website
     * @param model used to pass data to the view for rendering
     *
     * @return the homepage view
     */
    @RequestMapping(value = "/image/{id}/comments/create",method = RequestMethod.POST)
    public String createComment(@RequestParam("comment") String comment,
                                @PathVariable int id, Model model,
                                HttpSession session) {
        User currUser = (User) session.getAttribute("currUser");
        ImageManager image=new ImageManager();
        Image imageNew=image.getImageByTitle(id);
        Comment comments = new Comment(comment,imageNew,currUser);
        commentService.createComment(comments);
        List<Comment> commentList;
        commentList = commentService.getAllComments();
        model.addAttribute("comments", commentList);

        return "redirect:/images/{id}";
    }
}
