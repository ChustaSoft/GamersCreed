package gamerscreed.rocketstats.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterHelper {

	public static String getFormattedDate(Date aDate){
		SimpleDateFormat tmpDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return tmpDateFormat.format(aDate);
	}	
}
