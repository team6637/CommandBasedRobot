package org.usfirst.frc.team6637.robot.subsystems;

import org.usfirst.frc.team6637.robot.RobotMap;
import org.usfirst.frc.team6637.robot.commands.TeleopDrive_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive_Subsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMaster);
	WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlave);
	WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMaster);
	WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlave);
	
	DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
	
	public Drive_Subsystem() {
		leftSlave.follow(leftMaster);
		rightSlave.follow(rightMaster);
	}
	
	public void teleopDrive(double move, double turn) {
		drive.arcadeDrive(move, turn);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDrive_Command());
    }
}

