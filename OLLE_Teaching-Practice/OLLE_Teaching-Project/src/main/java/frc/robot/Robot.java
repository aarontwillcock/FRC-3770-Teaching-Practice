/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  DigitalInput HitSwitch;
  Relay LEDSwitch;
  AnalogInput Pot;
  ADXRS450_Gyro gyro;

  char MyCharacter;
  String Myname;
  Integer ANumber;
  Float ADecimal;
  Double MoreSigFigs;
  Boolean OnOff;
  Float a, b, resultF;
  Integer c, d, resultI;
  Integer degree;
  Double GyroAngle;
  TalonSRX FR, BR;
  TalonSRX FL, BL;
  Joystick controller;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    // MyCharacter = 'B';
    // Myname = "Natalie";
    // ANumber = 7;
    // ADecimal = (float)3.14;
    // MoreSigFigs = 3.1415926;
    // OnOff = true;
    // 6.02 * 10^23 = 1 mol
    // a = (float)6.022;p
    // // 22.4 L gas/ 1 mol
    // b = (float)22.4;
    // resultF = (float)0;
    // //Favorite number
    // c = 7;
    // //Vball Jersey number
    // d = 77;
    // resultI = 0;
    HitSwitch = new DigitalInput(0);
    LEDSwitch = new Relay(0);
    Pot = new AnalogInput(0);
    gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    FR = new TalonSRX(1);
    BR = new TalonSRX(4);
    FL = new TalonSRX(3);
    BL = new TalonSRX(2);
    degree = 55;
    GyroAngle = (double)7;
    gyro.calibrate();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    controller = new Joystick(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    for(Integer i=0; i<5; i++){
      System.out.println("Hello");
      }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // System.out.println("Natalie");
    // System.out.println(MyCharacter);
    // System.out.println(Myname);
    // System.out.println(ANumber);
    // System.out.println(ADecimal);
    // System.out.println(MoreSigFigs);
    // System.out.println(OnOff);
    // System.out.println("FloatMath:");
    // resultF = (a+b);
    // System.out.println(resultF);
    // resultF = (a-b);
    // System.out.println(resultF);
    // resultF = (a*b);
    // System.out.println(resultF);
    // resultF = (a/b);
    // System.out.println(resultF);
    // resultI = (d%c);
    // System.out.println("IntegerMath:");
    // System.out.println(resultI);
    // resultI = (d^c);
    // System.out.println(resultI);
    // resultI = (d+=c);
    // System.out.println(resultI);
    // resultI = (d-=c);
    // System.out.println(resultI);
    // resultI = (d/=c);
    // System.out.println(resultI);
    // resultI = (d*=c);
    // System.out.println(resultI);
    // resultI = (d>>3);
    // System.out.println(resultI);
    // for(Integer i=0; i<5; i++){
    // System.out.println("Hello");
    // }
    // if(HitSwitch.get() == true){
    //   System.out.println("Go");
    //   LEDSwitch.set(Relay.Value.kReverse);
    // }else{
    //   System.out.println("ObjectHere");
    //   LEDSwitch.set(Relay.Value.kForward);
    // }
      // degree = Pot.getValue();
      // System.out.println(degree);
      // GyroAngle = gyro.getAngle();
      // System.out.println(GyroAngle);
      // Natalies motors (leftside)
      if (controller.getRawButton(3)){
        BL.set(ControlMode.PercentOutput,1);
      }else{
        BL.set(ControlMode.PercentOutput,0);
      }
      if (controller.getRawButton(5)){
        FL.set(ControlMode.PercentOutput,1);
      }else{
        FL.set(ControlMode.PercentOutput,0);
      }
      // Hadens motors (rightside)
      if (controller.getRawButton(4)){
        BR.set(ControlMode.PercentOutput,-1);
      }else{
        BR.set(ControlMode.PercentOutput,0);
      }
      if (controller.getRawButton(6)){
        FR.set(ControlMode.PercentOutput,-1);
      }else{
        FR.set(ControlMode.PercentOutput,0);
      }
  }


  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

}
