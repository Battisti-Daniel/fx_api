package database.DatabaseDTO;

public class ServerDTO {
    
    private int id;
    private String name;
    private String ip;
    private String status;

    public ServerDTO(){
        
    }

    public ServerDTO(int id, String name, String ip, String status) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.status = status;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getIp(){
        return ip;
    }

    public String getStatus(){
        return status;
    }

}
