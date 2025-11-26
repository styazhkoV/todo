package kz.todo.app.Mapper;
import kz.todo.app.Mapper.TaskMapper;
import kz.todo.app.DTO.TaskRequestDto;
import kz.todo.app.DTO.TaskResponseDto;
import kz.todo.app.Entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// @Mapper(componentModel = "spring") говорит MapStruct'у:
// "Сгенерируй реализацию этого интерфейса и сделай её Spring Bean-ом, 
// чтобы мы могли внедрить её через @Autowired или конструктор".
@Mapper(componentModel = "spring")
public interface TaskMapper {

    // Превращаем DTO от клиента в Сущность для БД
    // (Игнорируем id, так как он создается базой)
    @Mapping(target = "id", ignore = true)
    Task toEntity(TaskRequestDto dto);

    // Превращаем Сущность из БД в DTO для ответа
    TaskResponseDto toDto(Task task);

    // MapStruct сам поймет, что нужно пройтись циклом по списку
    List<TaskResponseDto> toDtoList(List<Task> tasks);
}