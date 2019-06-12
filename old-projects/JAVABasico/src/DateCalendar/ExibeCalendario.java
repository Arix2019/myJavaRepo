package DateCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class ExibeCalendario {
    
    public static void main(String[] args){
        
        /*DATA INICIAL: 01/01/1970 */
        System.out.println(System.currentTimeMillis());
        
        Date now = new Date();
        System.out.println(now);
        
        //qual data representada por 1 trilhão em milesegundos, apartir de 01/01/1970?
        Date dataMil = new Date(1_000_000_000_000L);
        System.out.println(dataMil);
        
        /* CALENDÁRIO */
        // GregorianCalendar
        Calendar c = Calendar.getInstance();
        c.set(1982, Calendar.DECEMBER,20);
        System.out.println(c.getTime());
        
        System.out.println(c.get(Calendar.YEAR));
        
    }
    
}
