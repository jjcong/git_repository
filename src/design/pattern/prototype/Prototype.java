package design.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式：新建一个原型类,实现深浅复制的功能
 *     浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *     深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
 *
 * @author  j_cong
 * @date    2017/08/25
 * @version V1.0
 */
public class Prototype implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String string;
	
	private SerializableObject  obj; 
	
	//浅复制
    @Override
	public Object clone() throws CloneNotSupportedException {
		
		Prototype proto = (Prototype) super.clone();
		return proto;
	}
	
	//深复制
	public Object deepClone() throws IOException, ClassNotFoundException {
		
		//写入当前对象的二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		//读出二进制流产生的新对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public String getString() {
		return  string;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public SerializableObject  getObj() {
		return obj;
	}
	
	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}
	
	class SerializableObject implements Serializable {
		private static final long serialVersionUID = 1L;
	}
	
}
