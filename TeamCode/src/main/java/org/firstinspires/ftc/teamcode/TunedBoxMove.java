package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Tuned Box Move", group = "")
public class TunedBoxMove extends LinearOpMode {

    // Declare motors
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        // Set the motor direction
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Loop to drive in a square
        for (int i = 0; i < 4; i++) {
            // Strafe to the right (omni wheel strafing)
            forward(700); // Move right for 1000 ms
            sleep(100);       // Pause for 1 second

            // Turn 90 degrees to the right
            turnRight(650);    // Turn right for 500 ms
            sleep(100);       // Pause for 1 second
        }
    }

    private void forward(long duration){
        leftMotor.setPower(0.4);
        rightMotor.setPower(0.4);
        sleep(duration);
        stopMotors();
    }

    // Method to strafe the robot to the right
    private void turnRight(long duration) {
        leftMotor.setPower(0.4);
        rightMotor.setPower(-0.4);
        sleep(duration);
        stopMotors();
    }

    // Method to stop the motors
    private void stopMotors() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}