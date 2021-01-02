import com.sun.jna.Library;
import com.sun.jna.Native;

public class GetAESF {

    public interface Dll extends Library{

        Dll INSTANCE=(Dll) Native.loadLibrary("E:\\项目\\DynamicsSimulaion\\DST\\DST",Dll.class);

        int Start();


    }
}
