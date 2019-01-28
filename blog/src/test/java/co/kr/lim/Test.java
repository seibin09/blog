/**
 * 
 */
package co.kr.lim;

/**
 * @author YoungBoss
 * @since  2019. 1. 28.
 * 
 */
public class Test {
    public static void main(String[] args) {
        for(Type type : Type.values()){
            System.out.println(type.getName() + ":" + type.getName1() );
        }
        
    }
}
