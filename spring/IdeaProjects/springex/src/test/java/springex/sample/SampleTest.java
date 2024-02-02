package springex.sample;

import com.springex.sample.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
// '테스트 환경 = 제이유닛(junit)'을 만들어주는 클래스 , 현재 5버전 사용중
@ExtendWith(SpringExtension.class)
// 현재 프로젝트가 설정되어 있는 기준 , 스프링의 설정 정보
// spring = (locations = xml) , boot = (classes = java)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTest {
    // SampleService의 경우 root-context.xml에서 bean으로 설정해 놨으므로,
    // bean으로 설정된 친구들은 @Autowired만 쓰면 어디서든 꺼내서 쓸 수 있다.
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNull(connection);

        connection.close();
    }
}
