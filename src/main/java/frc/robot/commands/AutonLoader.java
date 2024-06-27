package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
// import frc.robot.commands.Autos.BlueSourceSide;
import frc.robot.commands.Autos.Fire;
import frc.robot.commands.Autos.OneNote;
// import frc.robot.commands.Autos.RedAmpSide;
import frc.robot.commands.Autos.RedSourceSide;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PhotonSubsystem;
import frc.robot.subsystems.A_Star.A_Star;

public class AutonLoader {
    private final DriveBase m_driveBase;
    private final Intake m_intake;
    private final PhotonSubsystem m_photonsubsystem;
    private final SendableChooser<Command> m_chooser = new SendableChooser<>();

    

    public AutonLoader(DriveBase driveBase, Intake intake, PhotonSubsystem photon) {
        m_driveBase = driveBase;
        m_intake = intake;
        m_photonsubsystem = photon;

        A_Star.rectangularObstacle(Constants.Auton.BlueObstacle_TopLeft, Constants.Auton.BlueObstacle_BottomRight);
        A_Star.rectangularObstacle(Constants.Auton.RedObstacle_TopLeft, Constants.Auton.RedObstacle_BottomRight);
        
        RobotContainer.defineNamedCommands();
        

        m_chooser.addOption("Fire 1.5", new Fire(1.5));
        m_chooser.addOption("Red Source Side", new RedSourceSide(driveBase));
        // m_chooser.addOption("Red Amp Side", new RedAmpSide(driveBase));
        m_chooser.addOption("One Note", new OneNote(driveBase));
        // m_chooser.addOption("Blue Source Side", new BlueSourceSide(driveBase));

        SmartDashboard.putData(m_chooser);
        SmartDashboard.updateValues();
    }

    public Command getAuton() {
        return m_chooser.getSelected();
    }    
}