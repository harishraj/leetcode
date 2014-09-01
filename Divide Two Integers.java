public class Solution {
    public int divide(int dividend, int divisor) {
        /*
            if dr==0:
                throw new IllegalArgumentException();
            sign = (dd>0 && dr<0 || dd<0 && dr>0)? -1:1
            dd = Math.abs(dd)
            dr = Math.abs(dr)
            
            r=0
            while dd>=dr:
                bp=1
                tmp=dr
                while (tmp<<1)>0 && dd>(tmp<<1):
                    tmp<<=1
                    bp<<=1
                dd-=tmp
                r+=bp
                
            return r*sign
        */
        if(divisor==0) throw new IllegalArgumentException();
        int sign = ((dividend>0 && divisor<0) || (dividend<0 && divisor>0))? -1:1;
        int dd = Math.abs(dividend);
        int dr = Math.abs(divisor);
        
        int r = 0;
        while (dd>=dr) {
            int bp = 1;
            int tmp = dr;
            while((tmp<<1)>0 && dd>(tmp<<1)) {
                tmp <<= 1;
                bp<<=1;
            }
            dd-=tmp;
            r+=bp;
        }
        return r*sign;
    }
}
