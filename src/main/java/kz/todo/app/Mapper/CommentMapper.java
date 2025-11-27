package kz.todo.app.Mapper;

import kz.todo.app.DTO.CommentRequestDto;
import kz.todo.app.DTO.CommentResponseDto;
import kz.todo.app.Entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "task", ignore = true)
    Comment toEntity(CommentRequestDto dto);
    
    CommentResponseDto toDto(Comment comment);
    
} 