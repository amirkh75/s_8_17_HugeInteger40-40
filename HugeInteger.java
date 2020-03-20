



/**
 *
 * @author amirkh
 */
public class HugeInteger {
    
    private int[] Huge_Integer = new int[5];
    private String Huge_Integer_str ;
    private int numberOfHugeIntInUse=0;
    public static final HugeInteger one = new HugeInteger("1");
     
    public HugeInteger(){
        Huge_Integer_str=null;
    }
   
    public HugeInteger(String Huge_Integer_str){
        this.Huge_Integer_str=Huge_Integer_str;
        parse_String2int(this.Huge_Integer_str);
    }
    
    public void parse_String2int(String Huge_Integer_str){
        if(!Huge_Integer_str.isEmpty()){
            if(Huge_Integer_str.length()>=9){
                Huge_Integer[0] = Integer.parseInt(Huge_Integer_str.substring(0, 9));
                numberOfHugeIntInUse++;
            }
            else{
                Huge_Integer[0] = Integer.parseInt(Huge_Integer_str.substring(0, Huge_Integer_str.length()));
                numberOfHugeIntInUse++;
            }
            if(Huge_Integer_str.length()>=18){
               Huge_Integer[1] = Integer.parseInt(Huge_Integer_str.substring(9, 18));
               numberOfHugeIntInUse++;
            }
            else if(9<Huge_Integer_str.length() && Huge_Integer_str.length()<18){
                Huge_Integer[1] = Integer.parseInt(Huge_Integer_str.substring(9, Huge_Integer_str.length()));
                numberOfHugeIntInUse++;
            }
            if(Huge_Integer_str.length()>=27){
               Huge_Integer[2] = Integer.parseInt(Huge_Integer_str.substring(18, 27));
               numberOfHugeIntInUse++;
            }
            else if(18<Huge_Integer_str.length() && Huge_Integer_str.length()<27){
                Huge_Integer[2] = Integer.parseInt(Huge_Integer_str.substring(18, Huge_Integer_str.length()));
                numberOfHugeIntInUse++;
            }
            if(Huge_Integer_str.length()>=36){
               Huge_Integer[3] = Integer.parseInt(Huge_Integer_str.substring(27, 36));
               numberOfHugeIntInUse++;
            }
            else if(27<Huge_Integer_str.length() && Huge_Integer_str.length()<36){
                Huge_Integer[3] = Integer.parseInt(Huge_Integer_str.substring(27, Huge_Integer_str.length()));
                numberOfHugeIntInUse++;
            }
            if(Huge_Integer_str.length()>=40){
               Huge_Integer[3] = Integer.parseInt(Huge_Integer_str.substring(36, 40));
               numberOfHugeIntInUse++;
            }
            else if(36<Huge_Integer_str.length() && Huge_Integer_str.length()<40){
                Huge_Integer[3] = Integer.parseInt(Huge_Integer_str.substring(37, Huge_Integer_str.length()));
                numberOfHugeIntInUse++;
            }
        }
    }
    
    public void plus(HugeInteger a , HugeInteger b){
        int carry = 0;
        for (int i = 4; i >= 0; i--) {
            
            if(a.Huge_Integer[i] + b.Huge_Integer[i] + carry >999999999){
                this.Huge_Integer[i] = a.Huge_Integer[i] + b.Huge_Integer[i]-999999999+carry;
                carry = 1;
            }
            else{
                this.Huge_Integer[i] = a.Huge_Integer[i] + b.Huge_Integer[i]+carry;
                carry = 0;
            }
        }
        
    }
    
    public void mines(HugeInteger a , HugeInteger b){
        int carry = 0;
        for (int i = 4; i >= 0; i--) {
            
            if(a.Huge_Integer[i] - b.Huge_Integer[i] - carry <0){
                this.Huge_Integer[i] = a.Huge_Integer[i] - b.Huge_Integer[i]+999999999-carry;
                carry = 1;
            }
            else{
                this.Huge_Integer[i] = a.Huge_Integer[i] - b.Huge_Integer[i]-carry;
                carry = 0;
            }
        }
        
    }
    
    public void multyply(HugeInteger a , HugeInteger b){
        if(HugeInteger.isZero(a) || HugeInteger.isZero(b)){
            for (int i = 0; i < 4; i++) {
                this.Huge_Integer[i] = 0;
            }
            
        }
        else
        {
            boolean continue_ =true;
            this.parse_String2int(a.toString());
            while(continue_==true){
                b.mines(b, one);
                if(!HugeInteger.isZero(b)){
                    this.plus(this, a);
                } else {
                    continue_ =false;
                }
            }
        }
        
    } 
    
    public static boolean isZero(HugeInteger a){
        return a.Huge_Integer[0]==0 && a.Huge_Integer[1]==0 && a.Huge_Integer[2]==0 && a.Huge_Integer[3]==0 && a.Huge_Integer[4]==0;
    }  // true if ==zero                so butiful ;)))!
    
    public void print_Huge_Int(){
        System.out.println(this);
    }
    
    @Override
    public String toString(){
        if(Huge_Integer[4]!=0){
            return String.format("%d%d%d%d%d", Huge_Integer[0],Huge_Integer[1],Huge_Integer[2],Huge_Integer[3],Huge_Integer[4]);
        }
        else if(Huge_Integer[3]!=0){
            return String.format("%d%d%d%d", Huge_Integer[0],Huge_Integer[1],Huge_Integer[2],Huge_Integer[3]);
        }
        else if(Huge_Integer[2]!=0){
            return String.format("%d%d%d", Huge_Integer[0],Huge_Integer[1],Huge_Integer[2]);
        }
        else if(Huge_Integer[1]!=0){
            return String.format("%d%d", Huge_Integer[0],Huge_Integer[1]);
        }
        else if(Huge_Integer[0]!=0){
            return String.format("%d", Huge_Integer[0]);
        }
        else {
            return String.format("0");
        }
    }
}
