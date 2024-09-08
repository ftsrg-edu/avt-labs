package hu.bme.mit.avt;

import hu.bme.mit.avt.impl.WiperControllerImpl;

import static org.mockito.Mockito.*;

public class WiperControllerTest {

	public void sample(){
		WiperMotor motor = mock(WiperMotor.class);
		
		WiperController controller = new WiperControllerImpl(motor);
		
		controller.setWiperSwitch(WiperMode.OFF);
	}
	
}
