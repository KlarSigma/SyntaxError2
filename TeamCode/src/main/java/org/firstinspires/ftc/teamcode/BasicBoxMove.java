package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Basic Box Move", group = "")

public class BasicBoxMove extends LinearOpMode {

    // Declare motor objects
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        // Initialize the motors using the hardware map
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        // Set motor direction (Reverse right motor, if necessary)
        leftMotor.setDirection(DcMotor.Direction.FORWARD); // Port 2
        rightMotor.setDirection(DcMotor.Direction.FORWARD); // Reverse if motors are inverted; Port 0

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Move in a box pattern
        for (int i = 0; i < 4; i++) {
            // Move forward for 1 second
            moveForward(2.0);
            sleep(2000);

            // Turn right for 0.5 seconds (adjust for a 90-degree turn)
            turnRight(1.0);
            sleep(2000);


        }
    }

    // Function to move forward
    private void moveForward(double timeInSeconds) {
        leftMotor.setPower(1.0);
        rightMotor.setPower(1.0);

        sleep((long) (timeInSeconds * 1000));

        stopMotors();
    }

    // Function to turn right
    private void turnRight(double timeInSeconds) {
        leftMotor.setPower(1.0);  // Left motor moves forward
        rightMotor.setPower(0);   // Right motor stops to pivot right

        sleep((long) (timeInSeconds * 1000));

        stopMotors();
    }

    // Function to stop all motors
    private void stopMotors() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}