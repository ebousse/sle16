package org.gemoc.arduino.sequential.arduino.aspects;

import java.util.Map;
import org.gemoc.arduino.sequential.arduino.aspects.Utilities_ExecutableAspectUtilitiesAspectProperties;
import org.gemoc.arduino.sequential.arduino.arduino.Utilities;

@SuppressWarnings("all")
public class Utilities_ExecutableAspectUtilitiesAspectContext {
  public final static Utilities_ExecutableAspectUtilitiesAspectContext INSTANCE = new Utilities_ExecutableAspectUtilitiesAspectContext();
  
  public static Utilities_ExecutableAspectUtilitiesAspectProperties getSelf(final Utilities _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.arduino.sequential.arduino.aspects.Utilities_ExecutableAspectUtilitiesAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Utilities, Utilities_ExecutableAspectUtilitiesAspectProperties> map = new java.util.WeakHashMap<org.gemoc.arduino.sequential.arduino.arduino.Utilities, org.gemoc.arduino.sequential.arduino.aspects.Utilities_ExecutableAspectUtilitiesAspectProperties>();
  
  public Map<Utilities, Utilities_ExecutableAspectUtilitiesAspectProperties> getMap() {
    return map;
  }
}
