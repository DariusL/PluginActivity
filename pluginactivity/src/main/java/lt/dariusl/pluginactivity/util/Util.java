package lt.dariusl.pluginactivity.util;

import java.util.Collection;

public class Util {
    public static <T> boolean any(Collection<T> collection, Predicate<T> predicate){
        for (T value : collection){
            if(predicate.call(value)){
                return true;
            }
        }
        return false;
    }
}
