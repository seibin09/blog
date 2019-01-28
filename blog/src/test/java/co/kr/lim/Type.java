package co.kr.lim;

/**
 * @author YoungBoss
 * @since  2019. 1. 28.
 * 
 */
public enum Type {
    // 상수("연결할 문자")
    WALKING("워킹화", true);
     
    final private String name;
    final private Boolean name1;
     
    private Type(String name, Boolean name1) { //enum에서 생성자 같은 역할
        this.name = name;
        this.name1 = name1;
    }
    public String getName() { // 문자를 받아오는 함수
        return name;
    }
    public Boolean getName1() { // 문자를 받아오는 함수
    	return name1;
    }
    
    
}

