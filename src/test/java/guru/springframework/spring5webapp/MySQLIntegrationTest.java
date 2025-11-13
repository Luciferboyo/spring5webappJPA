package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@Transactional
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testMySQL(){

        long countBefore = bookRepository.count();
        assertThat(countBefore).isLessThan(2);

        bookRepository.save(new Book("商户","123555","self",null));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);

    }

}
