package org.usfirst.frc.team4729.robot.subsystems;

import org.usfirst.frc.team4729.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotDrive driveTrain = new RobotDrive(RobotMap.LEFT_DRIVE, RobotMap.RIGHT_DRIVE);
    
    double maxSpeed = 1;
	double leftSpeed = 0;
	double rightSpeed = 0;
	double turnSpeed = 0;
	double forwardSpeed = 0;
    
	static double ACCELERATION = 0.5;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
    public void arcade(double desiredMove, double desiredTurn, double maxSpeed) {
    	if (Math.abs(desiredMove) < Math.abs(turnSpeed)){
    		forwardSpeed = desiredMove;
    	}
    	
    	if (Math.abs(desiredTurn) < Math.abs(turnSpeed)) {
    		turnSpeed = desiredTurn;
    	}
    	
    	turnSpeed += (desiredTurn-turnSpeed)*ACCELERATION;
    	forwardSpeed += (desiredMove-forwardSpeed)*ACCELERATION;
    	driveTrain.arcadeDrive(-forwardSpeed*maxSpeed, -turnSpeed*maxSpeed);
    }
      
    public void tank (double desiredLeft, double desiredRight, double maxSpeed) {
    	if (Math.abs(desiredLeft) < Math.abs(leftSpeed)){
    		leftSpeed = desiredLeft;
    	}
    	
    	if (Math.abs(desiredRight) < Math.abs(rightSpeed)) {
    		rightSpeed = desiredRight;
    	}
    	
    	rightSpeed += (desiredRight-rightSpeed)*ACCELERATION;
    	leftSpeed += (desiredLeft-leftSpeed)*ACCELERATION;
    	driveTrain.tankDrive(leftSpeed*maxSpeed, rightSpeed*maxSpeed);
	}
}

