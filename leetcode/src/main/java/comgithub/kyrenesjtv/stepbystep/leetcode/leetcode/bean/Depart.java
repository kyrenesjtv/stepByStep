package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/9/17 18:56
 */
public class Depart {

    private long id;

    private String name;

    private String destion;

    //用户

    Set users = new HashSet();

    //子类部门

    Set departs = new HashSet();

    //父类部门

    private Depart depart;

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public Set getUsers() {
        return users;

    }

    public void setUsers(Set users) {
        this.users = users;

    }

    public Set getDeparts() {
        return departs;

    }

    public void setDeparts(Set departs) {
        this.departs = departs;

    }

    public Depart getDepart() {
        return depart;

    }

    public void setDepart(Depart depart) {
        this.depart = depart;

    }

    public String getDestion() {
        return destion;

    }

    public void setDestion(String destion) {
        this.destion = destion;

    }
}
