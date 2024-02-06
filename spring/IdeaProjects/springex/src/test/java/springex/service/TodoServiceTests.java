package springex.service;

import com.springex.domain.TodoVO;
import com.springex.dto.PageRequestDTO;
import com.springex.dto.PageResponseDTO;
import com.springex.dto.TodoDTO;
import com.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
// 직접적으로 연결해서 실제인 것처럼 테스트
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {
    @Autowired
    private TodoService todoService;
    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("test------------")
                .dueDate(LocalDate.now())
                .writer("user11")
                .build();

        todoService.register(todoDTO);
    }
    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        // 페이지에 해당하는 값을 받아와서 처리
        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        log.info(responseDTO);
        // PageResponseDTO
        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }
}
