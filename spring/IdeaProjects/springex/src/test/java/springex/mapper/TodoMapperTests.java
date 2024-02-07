package springex.mapper;

import com.springex.domain.TodoVO;
import com.springex.dto.PageRequestDTO;
import com.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
// Spring Container , test bean 주입하고 같이 사용해서 테스트
@ExtendWith(SpringExtension.class)
// root를 기반으로 테스트를 진행해라.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {
    // 존재하지 않아도 (null이어도) 실행 (느슨하게) - 단순 테스트 용도이기 때문에 유연하게 ㅇ
    // true : 반드시 bean이 존재해야 함
    @Autowired(required = false)
    private TodoMapper todoMapper;
    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }
    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder()
                .title("스프링테스트")
                .dueDate(LocalDate.of(2024, 12, 12))
                .writer("user22")
                .build();
        todoMapper.insert(todoVO);
    }
    @Test
    public void testSelectAll() {
        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));
    }
    @Test
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info(todoVO);
    }
    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }
    @Test
    public void testSelectSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"}) // t : title , w : writer
                .keyword("스프링")
                .from(LocalDate.of(2024, 1, 1))
                .to(LocalDate.of(2025, 1, 1))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));

        log.info(todoMapper.getCount(pageRequestDTO));
    }
}
