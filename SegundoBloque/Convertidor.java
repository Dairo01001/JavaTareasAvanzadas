package JavaTareasAvanzadas.SegundoBloque;

/**
 * @author Dairo Garcia Naranjo
 */
public class Convertidor {
    
    public String getBinario(String decimal) {
        Long l = Long.parseLong(decimal);
        return Long.toBinaryString(l);
    }
    
    public String getDecimal(String binario) {
        int decimal = this.binarioDecimal(Integer.parseInt(binario));
        return decimal + "";
    }
    
    private int binarioDecimal(int n) {
        int num = n;
        int decimal = 0;  
        int base = 1;    
        int temp = num;  
        while(temp > 0){
            int ultimoDigito = temp % 10;
            temp /= 10;     
            decimal += ultimoDigito * base;
            base *= 2;
        }  
        return decimal;
    }
}
