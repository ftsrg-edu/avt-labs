package hu.bme.mit.avt;

/*
 * Controller for the windshield wipers.
 */
public interface WiperController {

	/*
	 * User setting the wiper switch in a new position.
	 */
	public void setWiperSwitch(WiperMode mode);
	
	/*
	 * Receives notification from the rain sensor about
	 * changes in the intensity of the rain.
	 */
	public void rainIntensityChanged(RainMode mode);
}
