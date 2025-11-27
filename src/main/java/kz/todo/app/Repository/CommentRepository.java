package kz.todo.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.todo.app.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
} 


