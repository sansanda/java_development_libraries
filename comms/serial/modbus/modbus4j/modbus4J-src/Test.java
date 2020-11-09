import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.NodeScanListener;
import com.serotonin.modbus4j.ip.IpParameters;

public class Test {
    public static void main(String[] args) throws Exception {
        IpParameters ipParameters = new IpParameters();
        ipParameters.setHost("172.25.162.4");
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createTcpMaster(ipParameters, false);
        master.init();
        
        master.scanForSlaveNodes(new NodeScanListener() {
            public void nodeFound(int nodeNumber) {
                System.out.println("***Found: "+ nodeNumber);
            }

            public void progressUpdate(float progress) {
                System.out.println("   Progress: "+ progress);
            }

            public void taskCancelled() {
                System.out.println("Cancelled");
            }

            public void taskCompleted() {
                System.out.println("Done");
            }
        });
    }
}
