package DateCalendar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datas {

    public static void main(String[] args) {
        
        Calendar c = Calendar.getInstance();
        c.set(1982, Calendar.DECEMBER,20);  
        Date data = c.getTime();
        System.out.println(data);
        
        /* formatação de data/hora */
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(data));
        
        /* formatação de hora */
        DateFormat dft = DateFormat.getTimeInstance();
        System.out.println(dft.format(data));  
        
        
        
    }
}
