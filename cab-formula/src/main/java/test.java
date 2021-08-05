import java.util.List;

import com.cabformula.bean.CarBean;
import com.cabformula.bean.CityBean;
import com.cabformula.service.BookingService;
import com.cabformula.service.BookingServiceImpl;

public class test {

	public static BookingService service;
	
	public static void main(String[] args) {
		service = new BookingServiceImpl();
		
		List<CarBean> cars = service.getCars();
		
		List<CityBean> cities = service.getCities();
		
		
		System.out.println(cities);
		System.out.println(cars);
		
	}
}
