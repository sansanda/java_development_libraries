import com.serotonin.modbus4j.msg.ReadDiscreteInputsRequest;
import com.serotonin.modbus4j.msg.ReadDiscreteInputsResponse;
import com.serotonin.modbus4j.msg.ReadInputRegistersRequest;
import com.serotonin.modbus4j.msg.ReadInputRegistersResponse;
import com.serotonin.modbus4j.msg.WriteRegisterRequest;
import com.serotonin.modbus4j.msg.WriteRegisterResponse;
import com.serotonin.io.serial.SerialParameters;
import com.serotonin.io.serial.SerialUtils;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;


public class Test {
    public static void main(String[] args){
    	
    	try {
    		
    		int slaveID;
	    	int exceptionCode;
	    	int functionCode;
	    	short[] data;
	    	
    		SerialUtils su;
    		SerialParameters sp;
    		ReadInputRegistersRequest rirRequest;
    		ReadInputRegistersResponse rirResponse;
    		WriteRegisterRequest wrRequest;
    		WriteRegisterResponse wrResponse;
    		
    		su = new SerialUtils();
    		sp = new SerialParameters();
    		
    		sp.setPortOwnerName("COM6");
	    	sp.setCommPortId("COM6");
	    	sp.setBaudRate(9600);
	    	sp.setDataBits(8);
	    	sp.setStopBits(1);
	    	sp.setParity(0);
	    	
	    	ModbusMaster modbusMaster;
	    	modbusMaster = new ModbusFactory().createRtuMaster(sp, false);
	    	modbusMaster.init();
	    	
    		int firstRegisterToRead = 1;
    		int numberOfRegistersToRead = 1;
    		
    		rirRequest = new ReadInputRegistersRequest(1,firstRegisterToRead,numberOfRegistersToRead);
    		rirResponse = (ReadInputRegistersResponse)modbusMaster.send(rirRequest);
	    	
    		slaveID = rirResponse.getSlaveId();
	    	exceptionCode = rirResponse.getExceptionCode();
	    	functionCode = rirResponse.getFunctionCode();
	    	data = rirResponse.getShortData();
	    	
	    	System.out.println("Slave ID = " + slaveID);
	    	System.out.println("exceptionCode = " + exceptionCode);
	    	System.out.println("functionCode = " + functionCode);
	    	for (int i=0;i<data.length;i++){
	    		System.out.print(data[i]);
	    		System.out.print("-");
	    	}
    		
	    	int registerToWrite = 2;
	    	int registerValue = 30;
    		
	    	wrRequest = new WriteRegisterRequest(1,registerToWrite,registerValue);
	    	wrResponse = (WriteRegisterResponse)modbusMaster.send(wrRequest);
	    	
	    	
	    	modbusMaster.destroy();
	    	
	    	System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getLocalizedMessage());
			System.exit(-1);
		}
		
    }
}