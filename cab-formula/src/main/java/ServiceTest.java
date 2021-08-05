import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cabformula.bean.BookingBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

class ServiceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBooking() throws SQLIntegrityConstraintViolationException {
		BookingService service = new BookingServiceImpl();
		BookingBean booking = new BookingBean();

		assertEquals(false, service.addBooking(booking));
	}

}
