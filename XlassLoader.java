import java.lang.reflect.Method;
import java.util.Base64;

public class XlassLoader extends ClassLoader{
    private static final String CLASS_NAME = "Hello";
    private static final String METHOD_NAME = "hello";

    public static void main(String[] args) throws Exception{
        XlassLoader xlassLoader = new XlassLoader();
        //使用loadClass方法的话满足"双亲委派"的特点，会先去父类里面load，load不到再执行findClass方法
        Class<?> clazz = xlassLoader.loadClass(CLASS_NAME);
        for(Method method :  clazz.getDeclaredMethods()){
            System.out.println(clazz.getSimpleName() + ": " + method.getName());
        }
        Method helloMethod = clazz.getMethod(METHOD_NAME);
        if(helloMethod != null){
            Object instance = clazz.getDeclaredConstructor().newInstance();
            helloMethod.invoke(instance);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //先吧Hello.xlass文件转换成Base64
        String helloXlassBase64 = "NQFFQf///8v/4/X/+f/x9v/w/+/3/+71/+3/7Pj/6/j/6v7/+cOWkZaLwf7//NfWqf7/+7yQm5r+//CzlpGasYqSnZqNq56dk5r+//qXmpOTkP7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4/+nz/+j/5/7/7Leak5OQ09+ck56MjLOQnpuajd74/+bz/+X/5P7/+reak5OQ/v/vlZ6JntCTnpGY0LCdlZqci/7/75WeiZ7Qk56RmNCshoyLmpL+//yQiov+/+qzlZ6JntCWkNCvjZaRi6yLjZqeksT+/+yVnome0JaQ0K+NlpGLrIuNmp6S/v/4j42WkYuTkf7/6tezlZ6JntCTnpGY0KyLjZaRmMTWqf/e//r/+f///////f/+//j/9//+//b////i//7//v////rVSP/+Tv////7/9f////n//v////7//v/0//f//v/2////2v/9//7////2Tf/97fxJ//tO/////v/1////9f/9////+//3//r//v/z/////f/y";
        byte[] bytes = decode(helloXlassBase64);
        byte[] targetBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            targetBytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(name, targetBytes, 0, targetBytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}
