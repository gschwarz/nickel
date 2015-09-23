package gwtquery.plugins.draggable.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class StopDragException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, gwtquery.plugins.draggable.client.StopDragException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static gwtquery.plugins.draggable.client.StopDragException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new gwtquery.plugins.draggable.client.StopDragException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, gwtquery.plugins.draggable.client.StopDragException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return gwtquery.plugins.draggable.client.StopDragException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    gwtquery.plugins.draggable.client.StopDragException_FieldSerializer.deserialize(reader, (gwtquery.plugins.draggable.client.StopDragException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    gwtquery.plugins.draggable.client.StopDragException_FieldSerializer.serialize(writer, (gwtquery.plugins.draggable.client.StopDragException)object);
  }
  
}
