package com.quickshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quickshift.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class QuickShiftApplication {
	
	private final CalendarRepository calendarRep;

	public static void main(String[] args) {
		SpringApplication.run(QuickShiftApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void initialize() {
//		System.out.println("""
//				=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
//							起動完了
//				=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
//				""");
//		int currentYear = Year.now().getValue();
//		int currentMonth = LocalDate.now().getMonthValue();
//		
//		for(int i = -1; i < 2; i++) {
//			
//			for(int j = 1; j < 13; j++) {
//				
//				YearMonth yearMonth = YearMonth.of(currentYear + i, j);
//				int maxDay = yearMonth.lengthOfMonth();
//				
//				for(int k = 1; k < maxDay + 1; k++) {
//					
//					Calendar calendar = new Calendar();
//					calendar.setCYear(currentYear + i);
//					calendar.setCMonth(j); 
//					calendar.setCDate(k);
//					String str = "" + (currentYear + i) + j + k;
//					Long lo = Long.parseLong(str);
//					calendar.setId(lo);
//					calendarRep.save(calendar);
//				}
//			}
//		}
//		System.out.println("""
//				=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
//					   カレンダー登録完了
//				=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
//				""");
//	}
}