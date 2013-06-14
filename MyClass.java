import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-14
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class MyClass {
    private String str1;
    private String str2;
    public MyClass(String s1,String s2){
        str1 = s1;
        str2 = s2;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String sayHello(String name){
        return "Hello" + name;
    }
    public static void main(String[] args){
         try{
             Class[] types = new Class[]{String.class,String.class};
             Constructor cons = MyClass.class.getConstructor(types);
             System.out.println(cons);
             Object[] objs = new Object[]{"a","b"};
             MyClass clazz = (MyClass)cons.newInstance(objs);
             System.out.println(clazz.toString());

             //创建类的方法
             Class[] types2 = new Class[]{String.class};
             Method method = MyClass.class.getMethod("sayHello", types2);

             //调用方法
             Object[] strs = new Object[]{"World"};
             Object result = method.invoke(clazz,strs);
             System.out.println(result.toString());
         }   catch(Exception e){

         }


    }
}
