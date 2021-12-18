package old;

/**
 *
 * @author ilia
 */
public class Parameter {
    
    private String attr;
    private Integer val;
    
    public Parameter(String attr, Integer val) {

        this.attr = attr;
        this.val = val;
    }
    
    public String getAttr() {
        
        return attr;
    }

    public Integer getVal() {
        
        return val;
    }

    @Override
    public String toString() {
        
        return "<li>"+ attr +" - "+ val +"</li>";
    }
}

