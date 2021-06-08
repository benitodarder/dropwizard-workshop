package local.tin.tests.dropwizard.hello.world;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author benitodarder
 */
public class HelloWorld {
    
    private Date date;
    private String string;

    public HelloWorld(Date date, String string) {
        this.date = date;
        this.string = string;
    }

    public HelloWorld() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.date);
        hash = 71 * hash + Objects.hashCode(this.string);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HelloWorld other = (HelloWorld) obj;
        if (!Objects.equals(this.string, other.string)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    
    
}
