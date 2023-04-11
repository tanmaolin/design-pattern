package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-10-09 8:20
 */
public class Command {

    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();

        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);

        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        RemosteController remosteController = new RemosteController();
        remosteController.setCommand(0, lightOnCommand, lightOffCommand);

        remosteController.onButtonPush(0);

        remosteController.offButtonPush(0);

        remosteController.undoButtonPush();
    }
}
class RemosteController {
    private ICommand[] onCommand;
    private ICommand[] offCommand;

    //撤销命令
    ICommand undoCommand;

    public RemosteController() {
        this.onCommand = new ICommand[5];
        this.offCommand = new ICommand[5];

        for(int i = 0; i < 5; i++) {
            onCommand[i] = new NoCommand();
            offCommand[i] = new NoCommand();
        }
    }

    public void setCommand(int no, ICommand onCommand1, ICommand offCommand1) {
        onCommand[no] = onCommand1;
        offCommand[no] = offCommand1;
    }

    public void onButtonPush(int no) {
        onCommand[no].execute();
        //记录撤销
        undoCommand = onCommand[no];
    }

    public void offButtonPush(int no) {
        offCommand[no].execute();
        //记录撤销
        undoCommand = offCommand[no];
    }

    public void undoButtonPush() {
        undoCommand.undo();
    }
}

interface ICommand {
    //执行动作
    void execute();
    //取消动作
    void undo();
}

class LightOnCommand implements  ICommand{

    private LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.on();
    }

    @Override
    public void undo() {
        lightReceiver.off();
    }
}

class LightOffCommand implements  ICommand{

    private LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.off();
    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}

class NoCommand implements ICommand {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
class LightReceiver {
    public void on() {
        System.out.println("电灯打开了");
    }

    public void off() {
        System.out.println("电灯关闭了");
    }
}



