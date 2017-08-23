package setbackscale.dsmanioto.com.setbackscale.model;

/**
 * Created by danielsmanioto on 8/8/2017.
 */
public class Worker {

    private String name;
    private Team team;

    public Worker(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

}
