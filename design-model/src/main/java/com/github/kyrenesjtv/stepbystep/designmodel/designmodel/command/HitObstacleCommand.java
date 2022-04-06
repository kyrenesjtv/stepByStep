package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.command;

/**
 * @author huojianxiong
 * @Description HitObstacleCommand
 * @Date 2022/4/5 23:17
 */
public class HitObstacleCommand implements Command {

    private Integer var;

    public HitObstacleCommand(Integer var) {
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
