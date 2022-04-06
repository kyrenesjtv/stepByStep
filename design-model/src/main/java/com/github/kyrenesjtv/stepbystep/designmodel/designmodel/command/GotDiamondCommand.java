package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.command;

/**
 * @author huojianxiong
 * @Description GotDiamondCommand
 * @Date 2022/4/5 23:14
 */
public class GotDiamondCommand implements Command {

    private Integer var;

    public GotDiamondCommand(Integer var) {
        if (var == null) {
            this.var = 0;
        } else {
            this.var = var;
        }

    }

    @Override
    public void execute() {
        System.out.println(var++);
    }
}
