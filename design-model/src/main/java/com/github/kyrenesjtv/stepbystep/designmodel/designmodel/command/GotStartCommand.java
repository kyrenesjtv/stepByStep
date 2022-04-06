package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.command;

/**
 * @author huojianxiong
 * @Description GotStartCommand
 * @Date 2022/4/5 23:16
 */
public class GotStartCommand implements Command {
    private Integer var;

    public GotStartCommand(Integer var) {
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
