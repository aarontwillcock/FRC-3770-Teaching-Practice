package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;

public class Robot extends TimedRobot {

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  @Override
  public void robotInit() {
    //System.out.println("Robot init");
  }

  @Override
  public void robotPeriodic() {    
    
  }

  @Override
  public void autonomousInit() {
    System.out.println("Auton init");
  }

  @Override
  public void autonomousPeriodic() {
    System.out.println("Auton periodic");
  }

  @Override
  public void teleopPeriodic() {
    Color detectedColor = m_colorSensor.getColor();
    
    double IR = m_colorSensor.getIR();
    
    System.out.printf("Red: %2.2f \n", detectedColor.red);
    System.out.printf("Green: %2.2f \n", detectedColor.green);
    System.out.printf("Blue: %2.2f \n", detectedColor.blue);
    System.out.printf("IR: %2.2f \n", IR);
    
    int proximity = m_colorSensor.getProximity();

    System.out.printf("Proximity: %d\n", proximity);
  }

  @Override
  public void testPeriodic() {
    System.out.println("Test periodic");
  }
}
