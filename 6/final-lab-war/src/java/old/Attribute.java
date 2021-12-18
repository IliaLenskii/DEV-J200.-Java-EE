package old;

import java.util.HashSet;


/**
 *
 * @author ilia
 */
public class Attribute {
    
    private HashSet<Parameter> parameters = new HashSet<>();
            
    public Attribute(String attr, Integer val) {
        
        parameters.add(new Parameter(attr, val));
    }
    
    public void addParameter(String attr, Integer val) {
        
        parameters.add(new Parameter(attr, val));
    }
    
}
