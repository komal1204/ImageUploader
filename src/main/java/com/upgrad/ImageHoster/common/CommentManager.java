package com.upgrad.ImageHoster.common;


import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import org.hibernate.Session;

import java.util.List;

@SuppressWarnings("unchecked")
public class CommentManager extends SessionManager {

    /**
     * This method saves a Comment object to the database
     *
     * @param comment Comment object to be saved into the database
     *
     * @return the saved Comment object
     */


    public void createComment(final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);

    }
    public List<Comment> getAllComments() {
        Session session = openSession();
        List<Comment> commentList = session.createCriteria(Comment.class).list();
        commitSession(session);

        return commentList;
    }


}
